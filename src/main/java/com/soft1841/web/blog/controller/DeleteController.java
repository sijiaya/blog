package com.soft1841.web.blog.controller;

import com.soft1841.web.blog.dao.ArticleDao;
import com.soft1841.web.blog.dao.CommentDao;
import com.soft1841.web.blog.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet",urlPatterns = {"/DeleteServlet"})
public class DeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s_Id = (String) request.getParameter("id");
        Long id=Long.parseLong(s_Id);
        request.setCharacterEncoding("utf-8");
        CommentDao commentDao=DaoFactory.getCommentDaoInstance();

            try {
                if (commentDao.delete(id)==1){
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
