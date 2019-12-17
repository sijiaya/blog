package com.soft1841.web.blog.filter;

/**
 * 处理所有资源的乱码
 */

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter
{
	public void init(FilterConfig filterConfig)
          throws ServletException
	{

	}
	public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
              throws IOException,
            ServletException
	{
		try
		{
			request.setCharacterEncoding("UTF-8") ;	
			response.setCharacterEncoding("UTF-8");
		}
		catch (Exception e)
		{
		}
		
		chain.doFilter(request,response) ;
	}
	public void destroy()
	{

	}
};