package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.ArticleDao;
import com.soft1841.web.blog.entity.Article;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName ArticleDaoImplTest
 * @Description TODO
 * @Author sj_yao
 * @Date 2019/12/9
 **/
public class ArticleDaoImplTest {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();

    @Test
    public void findAll() throws Exception{
        List<Article> articleList = articleDao.findAll();
        articleList.forEach(article -> System.out.println(article));
    }

    @Test
    public void selectByKeywords() throws Exception{
        List<Article> articleList = articleDao.selectByKeywords("中");
        System.out.println(articleList.size());
    }

    @Test
    public void selectHotArticles() throws Exception{
        List<Article> articleList = articleDao.selectHotArticles();
        System.out.println(articleList.size());
    }

    @Test
    public void getArticleById() throws Exception{
        Article article = articleDao.getArticleById(1);
        System.out.println(article);
    }

    @Test
    public void selectByUserId() throws Exception{
        List<Article> articleList = articleDao.selectByUserId(3);
        System.out.println("根据用户id查询："+articleList);
    }

    @Test
    public void selectByTopicId() throws Exception{
        List<Article> articleList = articleDao.selectByTopicId(3);
        System.out.println("根据标题id查询："+articleList);
    }

    @Test
    public void delete() throws Exception{
        long n = articleDao.delete(5);
        System.out.println(n);
    }

    @Test
    public void insert() {
    }
}
