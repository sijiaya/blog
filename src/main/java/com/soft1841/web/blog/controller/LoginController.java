package com.soft1841.web.blog.controller;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.factory.DaoFactory;
import com.soft1841.web.blog.util.StringUtil;

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
 * @Description 登录
 * @Author sj_yao
 * @Date 2019/12/4
 **/
@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //获取用户名
        String mobile = request.getParameter("mobile");
        //获取密码
        String password = request.getParameter("password");
        String flag = request.getParameter("flag");
        //将集合对象保存到应用上下文中
        request.setAttribute("mobile", mobile);
        request.setAttribute("password", password);
        //实例化User类
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        user.setFlag(flag);
        //获取session对象
        HttpSession session = request.getSession();
        //重定向地址保存在path中
        String path = null;
        String rand = (String) session.getAttribute("rand");
        String input = request.getParameter("verify");
        try {
            //判断用户名
            if (DaoFactory.getUserDaoInstance().login(user)&&rand.equals(input)){
                System.out.println("judge login 123");
                session.setAttribute("nickname",user.getNickname());
                session.setAttribute("avatar",user.getAvatar());
                session.setAttribute("id",user.getId());
                    path = "homePage.jsp";
                   request.getRequestDispatcher(path).forward(request,response);
                   request.getSession().setAttribute("nickname",mobile);
            }else {
                request.setAttribute("error","用户名或密码错误");
                //服务器跳转（重新登录）
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //判断用户名和密码是否为空
        if (StringUtil.isEmpty(mobile) || StringUtil.isEmpty(password)){
            request.setAttribute("error","用户名或密码为空");
            //如果用户名和密码为空则重定向到登录页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
