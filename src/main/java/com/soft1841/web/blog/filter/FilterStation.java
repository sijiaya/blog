package com.soft1841.web.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterStation extends HttpServlet implements Filter
{
    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws ServletException,
            IOException 
            {
		HttpSession session=((HttpServletRequest)request).getSession();
        response.setCharacterEncoding("UTF-8");
       	if(session.getAttribute("me")==null)
       	{
      	 	PrintWriter out=response.getWriter();
       		out.print("<script language=javascript>alert('Äú»¹Ã»ÓÐµÇÂ¼£¡£¡£¡');window.location.href='login.html';</script>");
      	}
       	else
       	{
        	filterChain.doFilter(request, response);
      	}
    }
    public void destroy() { }
}
