//MarryServlet.java
package com.jit.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MarryServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	PrintWriter pw=null;
	String pname=null;
	String gender=null;
	int age=0;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		//create PrintWriter obj
		pw=response.getWriter();
		//set content type
		response.setContentType("text/html");
		//read form values
		pname=request.getParameter("tpname");
		gender=request.getParameter("tgender");
		age=Integer.parseInt(request.getParameter("tage"));
		//check for eligibility
		if(((gender.equals("male")) && (age>20))||((gender.equals("female")) && (age>17)))
		{
			//design  the form
			pw.println("<center><img src='marriage ring.jpg' width='400' height='300'></center>");
			pw.println("<center><h1 style='color:green;'>");
			pw.println("Yes ! <br>"+pname+", You are eligible.");
			pw.println("</center></h1>");
		}//if
		else
		{
			//design  the form
			pw.println("<center><img src='NoMarriage.jpg' width='300' height='300'></center>");
			pw.println("<center><h1 style='color:red;'>");
			pw.println("Sorry ! <br>"+pname+", You are not eligible.");
			pw.println("</center></h1>");
		}//else if
		//create a hyper link to html page
		pw.println("<center><a href='input.html'><img src='back.png'/></a></center>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//call doGet(-,-)
		doGet(request, response);
	}
}//class