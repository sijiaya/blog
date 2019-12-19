package com.soft1841.web.blog.dao;

import com.soft1841.web.blog.entity.Comment;
import java.util.List;

/**
 * @ClassName CommentDAO
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/12/11
 **/
public interface CommentDao {
  public int insert(Comment comment)  throws Exception;
  public int delete(long id)throws Exception;
  public List<Comment> queryByArticleId(long id) throws Exception;

}
