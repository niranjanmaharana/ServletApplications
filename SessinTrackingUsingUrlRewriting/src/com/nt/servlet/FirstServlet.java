package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/furl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=null;
		HttpSession session=null;
		String name=null, fname=null, ms=null;
		//general settings
		out=response.getWriter();
		response.setContentType("text/html");
		
		//read form1 data
		name=request.getParameter("name");
		fname=request.getParameter("fname");
		ms=request.getParameter("ms");
		
		//set to session attributes
		session=request.getSession(true);
		session.setAttribute("name", name);
		session.setAttribute("fname", fname);
		session.setAttribute("ms", ms);
		
		out.println("<h1 style='color:red; font-size:18; text-align:center;'>Fill up second form</h1>");
		out.println("<form action="+response.encodeURL("surl")+" method='post'>");
		out.println("<table align='center'>");
		
		out.println("<tr>");
		out.println("<td>Income</td>");
		out.println("<td><input type='text' name='income'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Tax</td>");
		out.println("<td><input type='text' name='tax'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td></td>");
		out.println("<td><input type='submit' value='Sumit'></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</form>");
		
		out.println("Session ID :: "+session.getId());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}