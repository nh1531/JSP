<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어 - errorPage, isErrorPage 속성</title>
</head>
<body>
<!-- http://localhost:8080/MustHaveJSP1/01DirectiveScript/Error500.jsp?age=15&name=홍길동  -->
<%
int myAge = Integer.parseInt(request.getParameter("age")) + 10;
out.println("10년 후 당신의 나이는 " + myAge + "입니다.");

String myName = request.getParameter("name");
out.println("당신의 이름은 " + myName + "입니다.");
%>

</body>
</html>