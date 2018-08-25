/**
 * 
 */
package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author niranjan
 *
 */
public class RequestAnalyzerListener implements ServletRequestListener 
{
	long start, end;
	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestListener#requestDestroyed(javax.servlet.ServletRequestEvent)
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent request) 
	{
		System.out.println("Request obj is destroyed");
		end=System.currentTimeMillis();
		ServletContext sc=request.getServletContext();
		System.out.println("Time required for the web application("+sc.getContextPath()+" :: "+(end-start)+" ms");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestListener#requestInitialized(javax.servlet.ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(ServletRequestEvent request)
	{
		System.out.println("Request obj is created");
		start=System.currentTimeMillis();
	}
}