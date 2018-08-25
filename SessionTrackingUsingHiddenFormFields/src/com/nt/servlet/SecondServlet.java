package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/surl")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		String name=null, fName=null, mStatus=null, f2val1=null, f2val2=null;
		//general settings
		pw=response.getWriter();
		response.setContentType("text/html");
		
		//read request 1 data
		name=request.getParameter("name");
		fName=request.getParameter("fname");
		mStatus=request.getParameter("mStatus");
		f2val1=request.getParameter("f2val1");
		f2val2=request.getParameter("f2val2");
		
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td>Name</td>");
		pw.println("<td>"+name+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Father Name</td>");
		pw.println("<td>"+fName+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Maritial Status</td>");
		pw.println("<td>"+mStatus+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>First Answer:</td>");
		pw.println("<td>"+f2val1+"</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Second Answer:</td>");
		pw.println("<td>"+f2val2+"</td>");
		pw.println("</tr>");
		pw.println("</table>");
		
		pw.println("<a href='form1.html'>home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
