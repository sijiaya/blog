package com.soft1841.web.blog.controller;

import com.soft1841.web.blog.dao.ArticleDao;
import com.soft1841.web.blog.entity.Article;
import com.soft1841.web.blog.factory.DaoFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AIServlet",urlPatterns = "/AIServlet")
public class AIController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        String thumbnail= (String) session.getAttribute("image");
        System.out.println("图片是"+thumbnail);
        String s_userId=request.getParameter("userId");
        Long userId=Long.parseLong(s_userId);
        System.out.println("作者是"+s_userId);
        String s_topicId=request.getParameter("topicId");
        Long topicId=Long.parseLong(s_topicId);
        System.out.println("主题是"+topicId);
        String title=request.getParameter("title");
        System.out.println( "标题是"+title);
        String content=request.getParameter("content");
        System.out.println("内容是"+content);
        Article article=new Article();
        article.setUserId(userId);
        article.setTopicId(topicId);
        article.setTitle(title);
        article.setContent(content);
        article.setThumbnail(thumbnail);
        ArticleDao articleDAO= DaoFactory.getArticleDaoInstance();
        try {
            if (articleDAO.insert(article)==1){
                request.getRequestDispatcher("article.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("err.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
