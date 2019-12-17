package com.soft1841.web.blog.controller;

import com.soft1841.web.blog.dao.Impl.UserDaoImpl;
import com.soft1841.web.blog.dao.UserDao;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.factory.DaoFactory;
import com.soft1841.web.blog.util.Mail;
import com.soft1841.web.blog.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

/**
 * @ClassName ${NAME}
 * @Description 注册
 * @Author sj_yao
 * @Date 2019/12/4
 **/
@WebServlet(name = "RegisterServlet",urlPatterns = "/register.do")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<body><center><h3>");
        //获取用户名
        String mobile = request.getParameter("mobile");
        //获取密码
        String password = request.getParameter("password");
        String email= request.getParameter("email");
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        user.setEmail(email);
        user.setFlag("1");
        user.setStatus((short) 0);
        UserDao userDao = DaoFactory.getUserDaoInstance();
        try {
            if (!userDao.checkUser(user)){
                userDao.insert(user);
                String s_id = userDao.checkId(user);
                Long id = Long.parseLong(s_id);
                user.setId(id);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }else {
                request.setAttribute("error","用户名存在");
                //服务器跳转（重新登录）
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        out.println("</h3></center></body></html>");
        //判断用户名和密码是否为空
        if (StringUtil.isEmpty(mobile) || StringUtil.isEmpty(password)){
            request.setAttribute("error","用户名或密码为空");
            //如果用户名和密码为空则重定向到登录页面
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
