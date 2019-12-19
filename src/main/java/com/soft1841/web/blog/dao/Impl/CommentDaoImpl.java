package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.CommentDao;
import com.soft1841.web.blog.entity.Comment;
import com.soft1841.web.blog.util.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommentDAOImpl
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/12/11
 **/
public class CommentDaoImpl implements CommentDao {
    @Override
    public int insert(Comment comment) throws Exception {
        int n=0;
       String sql="INSERT INTO db_space.t_comment(userId,articleId,content)VALUES(?,?,?)" ;
        PreparedStatement psmt=null;
        DataBaseConnection dbc=null;
        dbc=new DataBaseConnection();
        try {
            psmt=dbc.getConnection().prepareStatement(sql);
            psmt.setLong(1,comment.getUserId());
            psmt.setLong(2,comment.getArticleId());
            psmt.setString(3,comment.getContent());
          n=psmt.executeUpdate();
            psmt.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            dbc.close();
        }
        return n;
    }

    @Override
    public int delete(long id) throws Exception {
        int n=0;
String sql="delete from db_space.t_comment where id=? ";
PreparedStatement psmt=null;
DataBaseConnection dbc=null;
dbc=new DataBaseConnection();
try {
    psmt=dbc.getConnection().prepareStatement(sql);
    psmt.setLong(1,id);
   n=psmt.executeUpdate();
    psmt.close();
}catch (Exception ex){
    ex.printStackTrace();
}finally {
    dbc.close();
}

        return n;
    }

    @Override
    public List<Comment> queryByArticleId(long id) throws Exception {
        List<Comment> all=new ArrayList<>();
        String sql="SELECT a.content,a.userId,a.articleId,a.id,b.nickname " +
                "FROM db_space.t_comment a LEFT JOIN db_space.t_user b ON a.userId=b.id WHERE articleId=? " ;
        PreparedStatement psmt=null;
        DataBaseConnection dbc=null;
        dbc=new DataBaseConnection();
        try{
            psmt=dbc.getConnection().prepareStatement(sql);
            psmt.setLong(1,id);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                Comment comment=new Comment();
                comment.setId(rs.getLong("id"));
                comment.setUserId(rs.getLong("userId"));
                comment.setArticleId(rs.getLong("articleId"));
                comment.setContent(rs.getString("content"));
                comment.setUserName(rs.getString("nickname"));
                all.add(comment);
            }
            rs.close();
            psmt.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbc.close();
        }
        return all;
    }
}
