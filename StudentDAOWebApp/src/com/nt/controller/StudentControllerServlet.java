package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

@WebServlet("/controller")
public class StudentControllerServlet extends HttpServlet 
{
	PrintWriter pw;
	String output;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			//general settings
			pw=response.getWriter();
			response.setContentType("text/html");
			
			//create VO obj
			StudentVO vo=new StudentVO();
			
			//read form data and set to VO class obj
			vo.setSno(request.getParameter("sno"));
			vo.setSname(request.getParameter("sname"));
			vo.setMath(request.getParameter("math"));
			vo.setPhysics(request.getParameter("physics"));
			vo.setChemistry(request.getParameter("chemistry"));
			
			//convert to dto class obj
			StudentDTO dto=new StudentDTO();
			dto.setSno(Integer.parseInt(vo.getSno()));
			dto.setSname(vo.getSname());
			dto.setMath(Integer.parseInt(vo.getMath()));
			dto.setPhysics(Integer.parseInt(vo.getPhysics()));
			dto.setChemistry(Integer.parseInt(vo.getChemistry()));
			
			//call service class method for registration
			StudentService service=new StudentService();
			output=service.registerStudent(dto);
			pw.println(output);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
