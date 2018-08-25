package com.jit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckPasswordServlet extends HttpServlet 
{
	PrintWriter out=null;
	String pwd=null;
	boolean isSpecialChar=false;
	int length=0;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//general settings
		response.setContentType("text/html");
		out=response.getWriter();
		//read request params
		pwd=request.getParameter("pwd");
		length=pwd.length();
		//check password length
		if(length<=5)
		{
			out.println("<span style='color:red; font-size:16;'>Weak password !</span>");
		}
		else
		{
			for(int i=0;i<length;i++)
			{
				char temp=pwd.charAt(i);
				if(!((Character.isUpperCase(temp)) || (Character.isLowerCase(temp))))
				{
					isSpecialChar=true;
					break;
				}
			}
			if(isSpecialChar==true)
			{
				out.println("<span style='color:green; font-size:16;'>Strong password !</span>");
			}
			else
			{
				out.println("<span style='color:red; font-size:16;'>Weak password !</span>");
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//call doGet(-,-) mthod
		doGet(request,response);
	}
}