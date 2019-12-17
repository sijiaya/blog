package com.soft1841.web.blog.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CharFilter implements Filter
{
	public void init(FilterConfig filterConfig)
          throws ServletException
	{
		// System.out.println("** ��������ʼ��...") ;
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
              throws IOException, ServletException
	{
		request.setCharacterEncoding("UTF-8");//������������ᵼ�º��ִ������ݿ�������
		String content=request.getParameter("content");//System.out.println(content);
		// ���indexOf����-1���ʾû�в鵽��Ҫ������
		if(content!=null)
		{
			if(content.indexOf("��")==-1)
			{
				chain.doFilter(request,response) ;
			}
			else
			{
				System.out.println("�зǷ�����") ;
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
	       		out.print("<script language=javascript>alert('�зǷ����֣�');window.location.href='insert_error.jsp';</script>");
				
				// �����Ҫ�Ļ����˴�����ʹ��RequestDispatcher������ת				
				//request.getRequestDispatcher("insert_error.jsp").forward(request,response) ;
			}	
		}
		else
		{
			chain.doFilter(request,response) ;
		}
		
	}
	public void destroy()
	{
		// System.out.println("** ����������...") ;
	}
};

