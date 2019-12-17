package com.soft1841.web.blog.factory;

import com.soft1841.web.blog.dao.Impl.ArticleDaoImpl;
import com.soft1841.web.blog.dao.Impl.UserDaoImpl;
import com.soft1841.web.blog.dao.ArticleDao;
import com.soft1841.web.blog.dao.Impl.TopicDaoImpl;
import com.soft1841.web.blog.dao.TopicDao;
import com.soft1841.web.blog.dao.UserDao;


/**
 * @ClassName DaoFactory
 * @Description 工厂类
 * @Author sj_yao
 * @Date 2019/12/4
 **/
public class DaoFactory {
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
    public static ArticleDao getArticleDaoInstance(){
        return new ArticleDaoImpl();
    }
    public static TopicDao getTopicDaoInstance(){
        return new TopicDaoImpl();
    }
    }
