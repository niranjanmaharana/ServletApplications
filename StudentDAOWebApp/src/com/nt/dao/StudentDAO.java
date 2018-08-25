package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAO 
{
	private Connection con;
	private PreparedStatement ps;
	private InitialContext ic;
	private DataSource ds;
	private static final String INSERT_STUDENT_DATA="INSERT INTO STUDENT_DAO VALUES(?,?,?,?,?)";
	private int recordCount=0;
	
	public void getConnectionObj()throws Exception
	{
		//create InitialContext obj
		ic=new InitialContext();
		//get datasource
		ds=(DataSource)ic.lookup("DsJndi");
		//get conn obj
		con=ds.getConnection();
		if(con==null)
		{
			System.out.println("Null Connection");
		}
	}
	
	public String insertData(StudentBO bo)throws Exception
	{
		//get connection
		getConnectionObj();
		ps=con.prepareStatement(INSERT_STUDENT_DATA);
		
		ps.setInt(1,bo.getSno());
		ps.setString(2,bo.getSname());
		ps.setInt(3,bo.getTotal());
		ps.setDouble(4,bo.getAvg());
		ps.setString(5,bo.getResult());
		
		recordCount=ps.executeUpdate();
		
		if(recordCount==0)
			return "STUDENT NOT REGISTERED !";
		else
			return "STUDENT REGISTERED SUCCESSFULLY.";
	}
}