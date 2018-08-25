package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String searchContent=null;
		String site=null;
		String url=null;
		PrintWriter pw=null;
		//read parameters
		searchContent=request.getParameter("tsearch");
		site=request.getParameter("site");
		
		
		//prepare url
		if(site.equals("google"))
			url="https://www.google.co.in/search?q=";
		else if(site.equals("yahoo"))
			url="https://in.search.yahoo.com/search?p=";
		else
			url="https://www.bing.com/search?q=";
		
		response.sendRedirect(url+searchContent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
