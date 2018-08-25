package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadurl")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw=null;
       
    public FileDownload() {
       
      
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		pw=res.getWriter();
		res.setHeader("content-disposition", "attachment;fileName=file.doc");
		res.setContentType("application/ms-word");
		pw.println("<img src=''/>");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
