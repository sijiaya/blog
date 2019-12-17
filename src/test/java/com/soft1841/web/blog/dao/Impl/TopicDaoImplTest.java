package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.TopicDao;
import com.soft1841.web.blog.entity.Article;
import com.soft1841.web.blog.entity.Topic;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.factory.DaoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName TopicDaoImplTest
 * @Description TODO
 * @Author sj_yao
 * @Date 2019/12/10
 **/
public class TopicDaoImplTest {
    private TopicDao topicDao = DaoFactory.getTopicDaoInstance();

    @Test
    public void findAll() throws Exception{
        List<Topic> topicList = topicDao.findAll();
        topicList.forEach(topic -> System.out.println(topic));
    }

    @Test
    public void selectHotTopic() throws Exception{
        List<Topic> topicList = topicDao.selectHotTopic();
        System.out.println(topicList.size());
    }

    @Test
    public void getTopicById() throws Exception{
        List<Topic> topicList = topicDao.getTopicById(2);
        System.out.println(topicList);
    }

    @Test
    public void selectByKeywords() throws Exception{
        List<Topic> topicList = topicDao.selectByKeywords("俄罗斯");
        System.out.println(topicList.size());
    }
}
