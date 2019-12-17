package com.soft1841.web.blog.dao;

import com.soft1841.web.blog.entity.Article;

import java.util.List;

/**
 * @ClassName ArticleDAO
 * @Description 文章Dao接口
 * @Author mq_xu
 * @Date 2019/12/5
 **/
public interface ArticleDao {
    /**
     * 展示所有日志
     * @return
     * @throws Exception
     */
     List<Article> findAll() throws Exception;

    /**
     * 根据关键字模糊查询所有文章
     * @param keywords
     * @return
     * @throws Exception
     */
     List<Article> selectByKeywords(String keywords)throws Exception;

    /**
     * 查询热门文章
     * @return
     * @throws Exception
     */
     List<Article> selectHotArticles()throws Exception;

    /**
     * 根据id获取文章详情
     * @param id
     * @return
     * @throws Exception
     */
     Article getArticleById(long id)throws Exception;

    /**
     * 根据作者id查询所有文章
     * @param userId
     * @return
     * @throws Exception
     */
     List<Article> selectByUserId(long userId)throws Exception;

    /**
     * 根据专题id查询所有文章
     * @param topicId
     * @return
     * @throws Exception
     */
     List<Article> selectByTopicId(long topicId)throws Exception;

    /**
     * 删除文章
     * @param id
     * @return
     * @throws Exception
     */
    int delete(long id)throws Exception;

    /**
     * 新增文章
     * @param article
     * @return
     * @throws Exception
     */
    int insert(Article article) throws Exception;
}
