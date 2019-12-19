package com.soft1841.web.blog.controller;

import com.soft1841.web.blog.dao.UserDao;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ${NAME}
 * @Description TODO
 * @Author sj_yao
 * @Date 2019/12/19
 **/
@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //获取session对象
        HttpSession session = request.getSession(true);
        UserDao userDao = DaoFactory.getUserDaoInstance();
        String flag = request.getParameter("flag");
        if (flag.equals("update")){
            //获取用户名
            String mobile = request.getParameter("mobile");
            //获取密码
            String password = request.getParameter("password");
            String nickname = request.getParameter("nickname");
            String introduction = request.getParameter("introduction");
            //实例化User类
            User user = new User();
            user.setMobile(mobile);
            user.setPassword(password);
            user.setNickname(nickname);
            user.setIntroduction(introduction);
            try {
                int n = userDao.update(user);
                if (n==1){
                    request.getRequestDispatcher("personal.jsp").forward(request,response);
                }else {
                    request.getRequestDispatcher("err.jsp").forward(request,response);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
