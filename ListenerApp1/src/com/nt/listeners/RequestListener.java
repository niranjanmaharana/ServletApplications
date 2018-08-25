/**
 * 
 */
package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author niranjan
 *
 */
public class RequestListener implements ServletRequestListener 
{
	long start, end;
	ServletContext sc;
	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestListener#requestDestroyed(javax.servlet.ServletRequestEvent)
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent request) 
	{
		end=System.currentTimeMillis();
		String msg="Request Processing Time for the web application("+sc.getContextPath()+" :: "+(end-start)+" ms";
		System.out.println("Request obj is destroyed at "+new Date());
		sc.log(msg);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestListener#requestInitialized(javax.servlet.ServletRequestEvent)
	 */
	@Override
	public void requestInitialized(ServletRequestEvent request)
	{
		sc=request.getServletContext();
		start=System.currentTimeMillis();
		System.out.println("Request obj is created at "+new Date()+" ms");
		sc.log("Request obj is created at "+new Date());
	}
}