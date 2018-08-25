/**
 * 
 */
package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author niranjan
 *
 */
public class ValidationFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	static
	{
		System.out.println("ValidationFilter.static");
	}
	
	@Override
	public void destroy() 
	{
		System.out.println("ValidationFilter.destroy()");
	}

	public ValidationFilter() 
	{
		System.out.println("ValidationFilter.ValidationFilter()");
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException 
	{
		PrintWriter pw=null;
		int val1=0, val2=0;
		System.out.println("ValidationFilter.doFilter()");
		//general settings
		pw=response.getWriter();
		response.setContentType("text/html");
		
		try
		{
			//read form data
			val1=Integer.parseInt(request.getParameter("value1"));
			val2=Integer.parseInt(request.getParameter("value2"));
			
			//validate the form data
			if(val1>0 && val2>0)
				chain.doFilter(request, response);
			else
			{
				pw.println("<h1 style='color:red; font-size:20px; text-align:center;'>Error Occured During Request Processing</h1>");
				pw.println("<hr>");
				pw.println("<span style='color:red; font-size:15px;'>Please enter some vlaid data.</span>");
				//create hyper link
				pw.println("<div><a href='index.html'>Home</a></div>");
			}			
		}
		catch(Exception e)
		{
			pw.println("<h1 style='color:red; font-size:20px;'>Error Occured During Request Processing</h1>");
			pw.println("<hr>");
			pw.println("<span style='color:red; font-size:15px;'>"+e.getMessage()+"</span>");
			//create hyper link
			pw.println("<div><a href='index.html'>Home</a></div>");
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		System.out.println("ValidationFilter.init()");
	}

}
