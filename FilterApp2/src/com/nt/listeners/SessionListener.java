/**
 * 
 */
package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author niranjan
 *
 */
public class SessionListener implements HttpSessionListener 
{
	long start, end;
	ServletContext sc;
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) 
	{
		start=System.currentTimeMillis();
		System.out.println("session is created at "+new Date()+" ms");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent)
	{
		System.out.println("session is destroyed at "+new Date());
		end=System.currentTimeMillis();
		sc=sessionEvent.getSession().getServletContext();
		System.out.println("Session Duration :: "+(end-start)+" ms");
	}
}