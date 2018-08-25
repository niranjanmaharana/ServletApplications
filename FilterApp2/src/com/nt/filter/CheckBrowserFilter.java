package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CheckBrowserFilter implements Filter 
{

	@Override
	public void destroy() 
	{
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		PrintWriter pw=null;
		String browser=null;
		
		pw=response.getWriter();
		browser=((HttpServletRequest)request).getHeader("user-agent");
		System.out.println(browser);
		if(browser.indexOf("Firefox")==-1)
		{
			pw.println("<h1 style='color:red; text-align:center;'>Please execute web page on firefox !");
			return;
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
	
	}

}
