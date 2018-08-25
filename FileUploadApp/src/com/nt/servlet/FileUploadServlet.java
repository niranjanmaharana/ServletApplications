package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw;
	MultipartFormDataRequest mreq;
	UploadBean ub;
	Enumeration<UploadFile> e;
	UploadFile file;
	Hashtable ht=null;
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		pw=res.getWriter();
		res.setContentType("text/html");
		try
		{
			
			mreq=new MultipartFormDataRequest(req);
			ub=new UploadBean();
			ub.setFolderstore("F:/UploadFile");
			ub.setOverwrite(false);
			ub.setFilesizelimit(8000000);
			ub.store(mreq);
			pw.println("FileUploaded<br>");
			
			ht=mreq.getFiles();
			e=ht.elements();
			pw.println("<table align='center' border='1'><tr><th>File Name</th><th>File Size</th></tr>");
			while(e.hasMoreElements())
			{
				pw.println("<tr>");
				 file=e.nextElement();
				pw.println("<td>"+file.getFileName()+"</td>");
				pw.println("<td>"+file.getFileSize()/1000+" KB"+"</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
		}
		catch (UploadException e)
		{
			e.printStackTrace();
			pw.println("File not uploaded !");
		}	
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		doGet(req, res);
	}
}
