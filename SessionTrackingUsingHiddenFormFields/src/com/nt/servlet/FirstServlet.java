package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/furl")
public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=null;
		String name=null, fName=null, mStatus=null;
		//general settings
		pw=response.getWriter();
		response.setContentType("text/html");
		
		//read request 1 data
		name=request.getParameter("name");
		fName=request.getParameter("fname");
		mStatus=request.getParameter("mStatus");
		pw.println("<form name='form1' method='post' action='surl'>");
		if(mStatus.equalsIgnoreCase("single"))
		{
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<td>When will you marry:</td>");
			pw.println("<td><input type='text' name='f2val1'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Why will you marry:</td>");
			pw.println("<td><input type='text' name='f2val2'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td></td>");
			pw.println("<td><input type='submit' value='Submit'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type='hidden' name='name' value="+name+"><input type='hidden' name='mStatus' value="+mStatus+"></td>");
			pw.println("<td><input type='hidden' name='fname' value="+fName+"></td>");
			pw.println("</tr>");
			pw.println("</table>");
		}
		else
		{
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<td>Spouse Name:</td>");
			pw.println("<td><input type='text' name='f2val1'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>No. of Kids:</td>");
			pw.println("<td><input type='text' name='f2val2'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td></td>");
			pw.println("<td><input type='submit' value='Submit'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type='hidden' name='name' value="+name+"><input type='hidden' name='mStatus' value="+mStatus+"></td>");
			pw.println("<td><input type='hidden' name='fname' value="+fName+"></td>");
			pw.println("</tr>");
			pw.println("</table>");
		}
		pw.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}