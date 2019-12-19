package com.soft1841.web.blog.factory;

import com.soft1841.web.blog.dao.*;
import com.soft1841.web.blog.dao.Impl.*;

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
    public static CommentDao getCommentDaoInstance(){ return new CommentDaoImpl();
    }
    public static NoteDao getNoteDAOInstance(){
        return new NoteDaoImpl();
    }

}
