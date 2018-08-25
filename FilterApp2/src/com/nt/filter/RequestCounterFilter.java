/**
 * 
 */
package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author niranjan
 *
 */
public class RequestCounterFilter implements Filter 
{
	private FilterConfig fg;
	private ServletContext sc;
	private int counter;
	
	@Override
	public void destroy() 
	{
		fg=null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		sc=fg.getServletContext();
		counter++;
		sc.setAttribute("counter", counter);
		chain.doFilter(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig fg) throws ServletException 
	{
		this.fg=fg;
		counter=0;
	}
}