//VoteServlet.java
package com.jit.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class VoteServlet extends HttpServlet
{
	PrintWriter pw=null;
	String pname=null;
	int age=0;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		//create PrintWriter obj
		pw=response.getWriter();
		//set content type
		response.setContentType("text/html");
		//design  the form
		pw.println("<center><img src='eligibletovote.jpg' width='300' height='300'></center>");
		//read form values
		pname=request.getParameter("tpname");
		age=Integer.parseInt(request.getParameter("tage"));
		//check for eligibility
		if(age<18)
		{
			pw.println("<center><h1 style='color:red;'>");
			pw.println("Sorry ! <br>"+pname+", You are not eligible.");
			pw.println("</center></h1>");
		}//if
		else
		{
			pw.println("<center><h1 style='color:green;'>");
			pw.println("Congracts ! <br>"+pname+", You are eligible.");
			pw.println("</center></h1>");
		}//else
		//create a hyper link to html page
		pw.println("<center><a style='color:red;' href='input.html'><img src='back.png'/></a></center>");
		//close stream
		pw.close();
	}//doGet(-,-)
}//class