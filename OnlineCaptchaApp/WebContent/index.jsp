<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Captcha Application</title>
</head>
<body>
	<%@ page import="net.tanesha.recaptcha.ReCaptcha, net.tanesha.recaptcha.ReCaptchaFactory"%>
    <form action="process.jsp" method="post">
        <%
          //ReCaptcha c = ReCaptchaFactory.newReCaptcha("your_public_key", "your_private_key", false);
          ReCaptcha captcha = ReCaptchaFactory.newReCaptcha("6LdInAkUAAAAAMBwPQUJjLAxzWVUmP5mSijN29ni", "6LdInAkUAAAAAFzRLVEUFe5EAvPzWCHLRD8Jc7lc", false);
          out.print(captcha.createRecaptchaHtml(null, null));
        %>
        <input type="submit" value="submit" />
    </form>
</body>
</html>