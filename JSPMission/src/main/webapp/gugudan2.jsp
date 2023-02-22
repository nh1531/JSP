<!-- 입력 : /gugudan2.jsp?col=3
	출력 : 2*1=2 	 3*1=3	 4*1=4 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String strCol = request.getParameter("col");
	int col = Integer.parseInt(strCol);
%>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 2</title>
</head>
<body>

<% for(int i=2; i<10; i+=col){  
	 for(int j=1; j<=9; j++) { 
		for(int k=0; k<col; k++) { 		
			 if(10 <= i+k) { 
				out.print("\n");
				break;
			 } 
			 out.print("%d*%d=%2d"); %>
			<%= (i+k) %> * <%= j %> = <%= (i+k)*j %> <br/>	
		<% } %>
	<% } %>
<% } %>


</body>
</html>