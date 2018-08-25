//DBServlet.java

package com.nt.servlet;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DBServlet extends HttpServlet
{
	PrintWriter out;
	Connection connection;
	PreparedStatement pStatement;
	ResultSet resultSet;
	private static final String sqlQuery="SELECT SNO, SNAME, DOB FROM STUDENTLIST WHERE SNO=?";
	int sno;
	String str="Niranjan";

	public void init()
	{
		try
		{
			System.out.println(str.contentEquals(str));
			//register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement obj having select sql query
			pStatement=connection.prepareStatement(sqlQuery);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		//set response content type
		response.setContentType("text/html");
		//get PrintWriter obj
		out=response.getWriter();
		//design
		out.println("<div style='margin:0px auto; text-align:center;'><span style='font-size:18px; color:red'>Student Details</span><br/><br/><br/>");
		//read request param
		sno=Integer.parseInt(request.getParameter("tsno"));
		try
		{
			//set values to query param
			pStatement.setInt(1,sno);
			//send and execute query
			resultSet=pStatement.executeQuery();
			//process the result
			out.println("<table><tr><th>STUDENT NO.</th><th>STUDENT NAME</th><th>Date of Birth</th></tr>");
			if(resultSet.next())
			{
				//print details
				out.println("<tr>");
					out.println("<td>");
						out.println(resultSet.getInt(1));
					out.println("</td>");
					out.println("<td>");
						out.println(resultSet.getString(2));
					out.println("</td>");
					out.println("<td>");
						out.println(resultSet.getDate(3));
					out.println("</td>");
				out.println("</tr>");
			}
			else
				out.println("Record not found !");
			out.println("</table></div>");
			resultSet.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//close stream
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		doGet(request,response);
	}

	public void destroy()
	{
		try
		{
			if(pStatement!=null)
			{
				pStatement.close();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(connection!=null)
			{
				connection.close();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}