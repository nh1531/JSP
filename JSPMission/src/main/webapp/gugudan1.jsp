<!-- url에서 ?dan=2 입력받아서 구구단 실행  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String stringDan = request.getParameter("dan");
	int dan = Integer.parseInt(stringDan); // String -> int
%>
<html>
<head>
<title>구구단 1</title>
</head>
<body>
	<h2>
		<%= dan %>단을 출력합니다.
	</h2>
	
<% for(int i=2; i<10; i++){ %>
		<%= dan %> * <%= i %> = <%= dan * i %> <br/>
<% }%>

</body>
</html>