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
 * Servlet implementation class SecondServlet
 */
@WebServlet("/surl")
public class SecondServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=null;
		HttpSession session=null;
		String income=null, tax=null;
		
		/*String name=null, fname=null, ms=null;*/
		
		//general settings
		out=response.getWriter();
		response.setContentType("text/html");
		
		//read form1 data
		/*name=request.getParameter("name");
		fname=request.getParameter("fname");
		ms=request.getParameter("ms");*/
		
		//read form2 data
		income=request.getParameter("income");
		tax=request.getParameter("tax");
		
		//locate session obj
		session=request.getSession(false);
		//set to session attributes
		session.setAttribute("income", income);
		session.setAttribute("tax", tax);
		
		out.println("<h1 style='color:red; font-size:18; text-align:center;'>Fill up third form</h1>");
		out.println("<form action="+response.encodeURL("turl")+" method='post'>");
		out.println("<table align='center'>");
		
		out.println("<tr>");
		out.println("<td>Holiday Destination</td>");
		out.println("<td><input type='text' name='hd'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Honeymoon Place</td>");
		out.println("<td><input type='text' name='hp'></td>");
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
