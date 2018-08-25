package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext sc;
	private String path;
	private File file;
	private PrintWriter pw;
	private String mimeType;
	private InputStream is;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			//get ServletContext obj
			sc=getServletContext();
			//get real path of the file "Koala.jpg"
			path=sc.getRealPath("/Koala.jpg");
			
			//get MIME type of the file
			mimeType=sc.getMimeType("/Koala.jpg");
			//set MIME type of the response
			response.setContentType(mimeType);
			
			//set as downloadable file
			response.setHeader("content-disposition", "attachment;fileName=jitu.jpg");
			
			//create an InputStream pointing to that file
			is=new FileInputStream(path);
			//create OutputStream pointing to response obj
			ServletOutputStream sos=response.getOutputStream();
			
			//create a buffer for file copy operation
			byte[] buffer=new byte[4096];
			//create an int variable to keep track of how much bytes are copied
			int bytesRead=0;
			
			//start file copy operation
			while((bytesRead=is.read(buffer))!=-1)
			{
				sos.write(buffer,0,bytesRead);
			}
			
			//close stream objs
			is.close();
			sos.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
}
