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
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/turl")
public class ThirdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=null;
		HttpSession session=null;
		String name=null, fname=null, ms=null, income=null, tax=null,hd=null, hp=null;
		
		//general settings
		out=response.getWriter();
		response.setContentType("text/html");
		
		//read form3 data
		hd=request.getParameter("hd");
		hp=request.getParameter("hp");
		
		//locate session obj
		session=request.getSession(false);
		
		//read form1 and form2 data session obj
		name=(String)session.getAttribute("name");
		fname=(String)session.getAttribute("fname");
		ms=(String)session.getAttribute("ms");
		income=(String)session.getAttribute("income");
		tax=(String)session.getAttribute("tax");
		
		out.println("<h1 style='color:red; font-size:18;'>Reading values from HttpSession object</h1>");
		out.println("<form method='post'>");
		out.println("<table align='center'>");
		
		out.println("<tr>");
		out.println("<td>Name:</td>");
		out.println("<td>"+name+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Father Name</td>");
		out.println("<td>"+fname+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Maritial Status</td>");
		out.println("<td>"+ms+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Income</td>");
		out.println("<td>"+income+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Tax</td>");
		out.println("<td>"+tax+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Holiday Destination</td>");
		out.println("<td>"+hd+"</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Honeymoon Place</td>");
		out.println("<td>"+hp+"</td>");
		out.println("</tr>");

		out.println("</tr>");
		out.println("<td></td>");
		out.println("<td></td>");
		out.println("<td><a href='index.html'>Go to Home</a></td>");
		out.println("<td></td>");
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
