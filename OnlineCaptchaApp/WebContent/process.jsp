<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse"%>
 
<html>
<body>
    <%
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LfwU-kSAAAAAGiis8gP7kS42ty9Wt_1euOGzj3J");
 
        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
 
        if (reCaptchaResponse.isValid()) 
        {
            out.print("Answer was entered correctly!");
        } else
        {
            out.print("Answer is wrong");
        }
    %>
</body>
</html>