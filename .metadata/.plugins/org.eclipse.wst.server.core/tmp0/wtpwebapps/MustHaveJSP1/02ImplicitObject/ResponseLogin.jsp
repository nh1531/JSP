<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>내장 객체 - Response</title>
</head>
<body>
<%
String id = request.getParameter("user_id");
String pwd = request.getParameter("user_pwd");
if(id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")){
	response.sendRedirect("ResponseWelcome.jsp"); // sendRedirect 새로 호출 
}
else{
	request.getRequestDispatcher("ResponseMain.jsp?LoginErr=1")
		.forward(request, response); // forward 브라우저->서버->다른 페이지 바로 호출. 위의 url 바뀌지 않음
}
%>

</body>
</html>