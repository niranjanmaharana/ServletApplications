package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService 
{
	private int total;
	private double avg;
	private String result;
	
	
	public String registerStudent(StudentDTO dto)throws Exception
	{
		//develop blogic
		total=dto.getMath()+dto.getPhysics()+dto.getChemistry();
		avg=total/3.0f;
		if(avg<35)
			result="Pass";
		else
			result="Fail";
		//prepare BO class obj having both ip and op
		StudentBO bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO class
		StudentDAO dao=new StudentDAO();
		
		return dao.insertData(bo);
	}
}
