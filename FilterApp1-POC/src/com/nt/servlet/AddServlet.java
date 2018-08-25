package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addurl")
public class AddServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		int val1=0,val2=0;
		//general settings
		pw=response.getWriter();
		response.setContentType("text/html");
		
		//read form data
		val1=Integer.parseInt(request.getParameter("value1"));
		val2=Integer.parseInt(request.getParameter("value2"));
		
		//print sum
		pw.println("<span style='color:blue; font-weight:bold; font-size:20px;'>");
		pw.println("Sum of two values is "+(val1+val2));
		pw.println("</span>");
		
		//add hyper link
		pw.println("<br><span><a href='index.html'>Home</a></span>");
		
		//close stream
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}