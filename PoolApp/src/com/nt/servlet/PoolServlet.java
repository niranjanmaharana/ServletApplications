package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/poolurl")
public class PoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter pw;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	private int colCount;
	private String tname;
	private String qry;
	
	public void makeConnection()
	{
		try
		{
			//get Connection obj
			//create InitialContext obj
			InitialContext ic=new InitialContext();
			//use lookup method to search data source obj
			DataSource ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
			//get one Connection obj from JNDI registry
			con=ds.getConnection();
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//general settings
		pw=response.getWriter();
		response.setContentType("text/html");
		//read request param
		tname=request.getParameter("table");
		//prepare sql query
		qry="SELECT * FROM "+tname;
		System.out.println(tname);
		System.out.println(qry);
		//get Connection obj
		makeConnection();
		if(con==null)
			pw.println("Null Connection");
		try
		{
			//create Statement obj
			st=con.createStatement();
			//send and execute
			rs=st.executeQuery(qry);
			//create ResultSetMetaData obj
			rsmd=rs.getMetaData();
			//get column count
			colCount=rsmd.getColumnCount();
			//create table
			pw.println("<table BORDER='1'>");
			pw.println("<tr>");
			//print column names
			for(int i=1;i<=colCount;i++)
			{
				pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
			}
			pw.println("</tr>");
			//print column values
			while(rs.next())
			{
				//create row
				pw.println("<tr>");
				for(int i=1;i<=colCount;i++)
				{
					pw.println("<td>"+rs.getString(i)+"</td>");
				}
				//close row
				pw.println("</tr>");
			}
			pw.println("</table>");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			pw.println("<br>Table does not exist !<br>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//create hyper link
		pw.println("<a href='index.html'>Back</a>");
		//close stream
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
