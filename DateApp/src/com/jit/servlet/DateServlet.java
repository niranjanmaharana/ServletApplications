//DateServlet.java

package com.jit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

public class DateServlet extends HttpServlet
{
	PrintWriter pw=null;
	Date dt=null;

	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		//set response content type
		res.setContentType("text/html");
		//get PrintWriter obj
		pw=res.getWriter();
		//place request processing logic
		dt=new Date();
		//write op to response obj
		pw.println("<b><center>Date and Time is <span style='color:red'>"+dt+"</span></center></b>");
		//close stream
		pw.close();
	}//service(-,-)
}//class