package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.TopicDao;
import com.soft1841.web.blog.entity.Topic;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TopicDaoImpl
 * @Description 专题Dao接口实现类
 * @Author sj_yao
 * @Date 2019/12/7
 **/
public class TopicDaoImpl implements TopicDao {
    @Override
    public List<Topic> findAll() throws Exception {
        Connection con = DbUtil.getConnection();
        String sql = "SELECT * FROM db_space.t_topic ORDER BY id";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<Topic> topicList =convert(rs);
        DbUtil.close(con,pst,rs);
        return topicList;
    }

    @Override
    public List<Topic> selectHotTopic() throws Exception {
        Connection con = DbUtil.getConnection();
        String sql = "SELECT * FROM db_space.t_topic ORDER BY follows DESC LIMIT 100";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<Topic> topicList = convert(rs);
        DbUtil.close(con,pst,rs);
        return topicList;
    }

    @Override
    public List<Topic> getTopicById(long id) throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM db_space.t_topic WHERE id = ?";
        PreparedStatement pst  = conn.prepareStatement(sql);
        pst.setLong(1,id);
        ResultSet rs = pst.executeQuery();
        List<Topic> topicList = convert(rs);
        DbUtil.close(conn,pst,rs);
        return topicList;
    }

    @Override
    public List<Topic> selectByKeywords(String keywords) throws Exception {
        Connection con = DbUtil.getConnection();
        String sql ="SELECT * FROM db_space.t_topic WHERE topic_name LIKE ? OR description LIKE ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,"%"+keywords+"%");
        pst.setString(2,"%"+keywords+"%");
        ResultSet rs = pst.executeQuery();
        List<Topic> topicList = convert(rs);
        DbUtil.close(con, pst, rs);
        return topicList;
    }

    private List<Topic> convert(ResultSet rs)throws Exception{
        List<Topic> topicList = new ArrayList<>();
        while (rs.next()){
            Topic topic = new Topic();
            topic.setId(rs.getLong("id"));
            topic.setUserId(rs.getLong("userId"));
            topic.setTopicName(rs.getString("topic_name"));
            topic.setLogo(rs.getString("logo"));
            topic.setDescription(rs.getString("description"));
            topic.setArticles(rs.getInt("articles"));
            topic.setFollows(rs.getInt("follows"));
            topic.setCreateTime(rs.getTimestamp("creat_time").toLocalDateTime());
            topicList.add(topic);
        }
        return topicList;
    }
}
