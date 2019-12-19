package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.CommentDao;
import com.soft1841.web.blog.entity.Comment;
import com.soft1841.web.blog.factory.DaoFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName CommentDaoImplTest
 * @Description TODO
 * @Author sj_yao
 * @Date 2019/12/18
 **/
public class CommentDaoImplTest {
CommentDao commentDao= DaoFactory.getCommentDaoInstance();
    @Test
    public void insert() {
       Comment comment1=new Comment() ;
       comment1.setUserId((long) 1);
       comment1.setArticleId((long) 1);
       comment1.setContent("yao");
        try {
            commentDao.insert(comment1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        long n = 0;
        try {
            n = commentDao.delete(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }
}