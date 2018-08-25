package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/regurl")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		String name=null, age=null;
		
		//general settings
		pw=response.getWriter();
		response.setContentType("text/html");
		
		//form data
		name=request.getParameter("name");
		age=request.getParameter("age");
		
		//display form data
		pw.println("<br>Name:: "+name);
		pw.println("<br>Age :: "+age);
		
		//add hyper link
		pw.println("<br><a href='index.html'>home</a>");
		
		//display request counter
		pw.println("<br><br><br><br><br>Request Counter :: <span style='color:red;'>"+request.getServletContext().getAttribute("counter")+"<span>");
		
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