<%@page import="model1.board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO dao = new BoardDAO(application); // dao class 가져오기, 데이터 읽어오기
	List<BoardDTO> aList = dao.selectList(null);
	
	request.setAttribute("aList", aList); // aList에 데이터 저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 08, 09 Board 내용 받아와서 출력하기 -->
</head>
<body>
<table border="1">
<% for (int i = 0 ; i < aList.size() ; i++) { 
		pageContext.setAttribute("i", i); %> <!-- pageContext에 정보를 넣음 -->
		<tr>
			<td>${ aList[i].num }</td>
			<td>${ aList[i].title }</td>
			<td>${ aList[i].content }</td>
			<td>${ aList[i].postdate }</td>
			<td>${ aList[i].id }</td>
			<td>${ aList[i].visitcount }</td>
		</tr>
<%	}%>
</table>
</body>
</html>