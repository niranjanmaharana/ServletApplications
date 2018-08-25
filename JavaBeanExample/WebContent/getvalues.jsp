<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Values</title>
</head>
<body>
	<jsp:useBean id="st" class="com.nt.beans.StudentBean" scope="session" />
	Student No: <jsp:getProperty property="sno" name="st"/><br>
	Student Name: <jsp:getProperty property="sname" name="st"/><br>
	Address: <jsp:getProperty property="sadd" name="st"/><br>
</body>
</html>