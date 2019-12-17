package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.ArticleDao;
import com.soft1841.web.blog.entity.Article;
import com.soft1841.web.blog.entity.Topic;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.util.DbUtil;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**

/**
 * @ClassName ArticleDaoImpl
 * @Description 文章Dao接口实现类
 * @Author sj_yao
 * @Date 2019/12/9
 **/
public class ArticleDaoImpl implements ArticleDao {
    @Override
    public List<Article> findAll() throws Exception {
        Connection con = DbUtil.getConnection();
        List<Article> all = new ArrayList<>();
        String sql = "SELECT * FROM db_space.t_article";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Article article = new Article();
                article.setTitle(rs.getString("title"));
                article.setThumbnail(rs.getString("thumbnail"));
                article.setContent(rs.getString("content"));
                article.setId(rs.getLong("id"));
                all.add(article);
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public List<Article> selectByKeywords(String keywords) throws Exception {
        Connection con = DbUtil.getConnection();
        //从文章、专题、用户表联查出前端需要展示的数据
        String sql = "SELECT a.*,b.topic_name,b.logo,c.nickname,c.avatar " +
                "FROM db_space.t_article a " +
                "LEFT JOIN db_space.t_topic b " +
                "ON a.topicId = b.id " +
                "LEFT JOIN db_space.t_user c " +
                "ON a.userId = c.id " +
                "WHERE a.title LIKE ?  OR a.content LIKE ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, "%" + keywords + "%");
        pst.setString(2, "%" + keywords + "%");
        ResultSet rs = pst.executeQuery();
        List<Article> articleList = convert(rs);
        DbUtil.close(con,pst,rs);
        return articleList;
    }

    @Override
    public List<Article> selectHotArticles() throws Exception {
        Connection con = DbUtil.getConnection();
        String sql = "SELECT a.id,a.userId,a.topicId,a.title,a.thumbnail,a.content,a.comments,a.create_time,\n" +
                "b.topic_name,b.logo,\n" +
                "c.nickname,c.avatar\n" +
                "FROM db_space.t_article a \n" +
                "LEFT JOIN db_space.t_topic b \n" +
                "ON a.`topicId` = b.`id`\n" +
                "LEFT JOIN db_space.t_user c \n" +
                "ON a.`userId` = c.`id`\n" +
                "ORDER BY a.`comments` DESC LIMIT 50";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //调用封装的方法，将结果集解析成List
        List<Article> articleList = convert(rs);
        DbUtil.close(con,pst,rs);
        return articleList;
    }

    @Override
    public Article getArticleById(long id) throws Exception {
        Connection con = DbUtil.getConnection();
        String sql = "SELECT a.*,b.topic_name,b.logo,c.nickname,c.avatar " +
                "FROM db_space.t_article a " +
                "LEFT JOIN db_space.t_topic b " +
                "ON a.topicId = b.id " +
                "LEFT JOIN db_space.t_user c " +
                "ON a.userId = c.id " +
                "WHERE a.id = ?  ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1, id);
        ResultSet rs = pst.executeQuery();
        Article article = convert(rs).get(0);
        //注意这里，上一步执行完毕后，结果集的指针已经在当前这行记录的下方，所以回退一下
        rs.previous();
        //列表页的文章数据一般不需要详细内容，但是文章详情页需要，所以补上content属性
        article.setContent(rs.getString("content"));
        DbUtil.close(con,pst,rs);
        return article;
    }

    @Override
    public List<Article> selectByUserId(long userId) throws Exception {
        Connection con = DbUtil.getConnection();
        String sql = "SELECT a.*,b.topic_name,b.logo,c.nickname,c.avatar " +
                "FROM db_space.t_article a " +
                "LEFT JOIN db_space.t_topic b " +
                "ON a.topicId = b.id " +
                "LEFT JOIN db_space.t_user c " +
                "ON a.userId = c.id " +
                "WHERE a.topicId = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1, userId);
        ResultSet rs = pst.executeQuery();
        List<Article> articleList = convert(rs);
        DbUtil.close(con,pst,rs);
        return articleList;
    }

    @Override
    public List<Article> selectByTopicId(long topicId) throws Exception {
        Connection con = DbUtil.getConnection();
        //从文章、专题、用户表联查出前端需要展示的数据
        String sql = "SELECT a.*,b.topic_name,b.logo,c.nickname,c.avatar " +
                "FROM db_space.t_article a " +
                "LEFT JOIN db_space.t_topic b " +
                "ON a.topicId = b.id " +
                "LEFT JOIN db_space.t_user c " +
                "ON a.userId = c.id " +
                "WHERE a.topicId = ? ";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1, topicId);
        ResultSet rs = pst.executeQuery();
        List<Article> articleList = convert(rs);
        DbUtil.close(con,pst,rs);
        return articleList;
    }

    @Override
    public int delete(long id) throws Exception {
        int n = 0;
        String sql = "DELETE FROM db_space.t_article WHERE id=?";
        Connection con = DbUtil.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1,id);
        n = pst.executeUpdate();
        DbUtil.close(con,pst);
        return n;
    }

    @Override
    public int insert(Article article) throws Exception {
        int n =0;
        String sql = "INSERT INTO db_space.t_article (userId,title,thumbnail,content) VALUES (?,?,?,?)";
        Connection con = DbUtil.getConnection();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1,article.getUserId());
            pst.setString(2,article.getTitle());
            pst.setString(3,article.getThumbnail());
            pst.setString(4,article.getContent());
            n = pst.executeUpdate();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }
        return n;
    }

    private List<Article> convert(ResultSet rs)throws Exception{
        List<Article> articleList = new ArrayList<>();
        while (rs.next()){
            //文章自身信息
            Article article = new Article();
            article.setId(rs.getLong("id"));
            article.setUserId(rs.getLong("userId"));
            article.setTopicId(rs.getLong("topicId"));
            article.setTitle(rs.getString("title"));
            article.setThumbnail(rs.getString("thumbnail"));
            article.setContent(rs.getString("content"));
            article.setComments(rs.getInt("comments"));
            article.setCreatTime(rs.getTimestamp("create_time").toLocalDateTime());

            //作者信息
            User author = new User();
            author.setId(rs.getLong("id"));
            author.setNickname(rs.getString("nickname"));
            author.setAvatar(rs.getString("avatar"));

            //专题信息
            Topic topic = new Topic();
            topic.setId(rs.getLong("id"));
            topic.setTopicName(rs.getString("topic_name"));
            topic.setLogo(rs.getString("logo"));

            //给文章视图对象设置三块内容
            article.setArticle(article);
            article.setAuthor(author);
            article.setTopic(topic);
            //加入列表
            articleList.add(article);
        }
        return articleList;
    }
}
