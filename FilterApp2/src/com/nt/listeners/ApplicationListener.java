/**
 * 
 */
package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author niranjan
 *
 */
public class ApplicationListener implements ServletContextListener 
{
	ServletContext sc;
	long start, end;
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) 
	{
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) 
	{
		sc=servletContextEvent.getServletContext();
		sc.setAttribute("counter",0);
	}

}
