<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Setting Values</title>
</head>
<body>
	<jsp:useBean id="st" class="com.nt.beans.StudentBean" scope="session" /><!-- StudentBean st=new StudentBean(); -->
	<jsp:setProperty property="sno" name="st" value="101"/><!-- st.setSno(101); -->
	<jsp:setProperty property="sname" name="st" value="Niranjan"/><!-- st.setSname("Niranjan"); -->
	<jsp:setProperty property="sadd" name="st" value="Berhampur"/><!-- st.setSadd("Berhampur"); -->
	values are set.
</body>
</html>