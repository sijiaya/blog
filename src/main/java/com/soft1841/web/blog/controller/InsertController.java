package com.soft1841.web.blog.controller;

import com.soft1841.web.blog.dao.CommentDao;
import com.soft1841.web.blog.entity.Comment;
import com.soft1841.web.blog.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertServlet",urlPatterns = "/InsertServlet")
public class InsertController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_userId = (String) request.getParameter("userId");
        System.out.print(s_userId);
        Long userId=Long.parseLong(s_userId);
        String s_articleId = (String) request.getParameter("articleId");
        System.out.print(s_articleId);
        Long articleId=Long.parseLong(s_articleId );
        String content=request.getParameter("content");
            Comment c=new Comment();
            c.setUserId(userId);
            c.setArticleId(articleId);
            c.setContent(content);
            CommentDao commentDAO= DaoFactory.getCommentDaoInstance();
            try {
                if (commentDAO.insert(c)==1){
                    request.getRequestDispatcher("success.jsp").forward(request, response);
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
