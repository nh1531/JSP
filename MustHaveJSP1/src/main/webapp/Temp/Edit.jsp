<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원제 게시판 - 수정하기(Edit)</h2>
<form name = "writeFrm" method="post" action="EditProcess.jsp" onsubmit="return validateForm(this);">
	<input type="hidden" name="num" value="<%= dto.getNum() %>" />
	<input type="text" name="title" style="width : 90%" value="<%= dto.getTitle() %>" />
	<input type="text" name="test" style="width : 90%" value="testval" />
	<textarea name="content" style="width : 90%; height : 100px;">
		<%= dto.getContent() %>
	</textarea>
	<button type="submit">작성 완료</button>
</form>

</body>
</html>