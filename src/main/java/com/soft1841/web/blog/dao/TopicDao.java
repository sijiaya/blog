package com.soft1841.web.blog.dao;

import com.soft1841.web.blog.entity.Article;
import com.soft1841.web.blog.entity.Topic;

import java.util.List;

/**

/**
 * @ClassName TopicDao
 * @Description 专题Dao接口
 * @Author sj_yao
 * @Date 2019/12/7
 **/
public interface TopicDao {
    /**
     * 获取所有专题
     * @return
     * @throws Exception
     */
    List<Topic> findAll() throws Exception;

    /**
     * 获取热门专题
     * @return
     * @throws Exception
     */
    List<Topic> selectHotTopic() throws Exception;

    /**
     * 根据id获取专题详情
     * @param id
     * @return
     * @throws Exception
     */
    List<Topic> getTopicById(long id)throws Exception;

    /**
     * 根据关键字模糊查询专题
     * @param keywords
     * @return
     * @throws Exception
     */
    List<Topic> selectByKeywords(String keywords)throws Exception;

}
