<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offline Captcha Application</title>
</head>
<body>
	<img src="stickyImage" alt="Sticky Image"><br>
	<form action="process.jsp">
	<input type="text" name="answer"><br>
	<input type="submit" name="submit" value="Submit"/>
	</form>
</body>
</html>