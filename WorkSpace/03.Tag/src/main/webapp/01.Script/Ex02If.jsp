<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int sVar = 0; %>
	<% sVar ++; %>
	
	<%if(sVar%2 == 0) {%>
		<p>짝수</p>
	<%}else{%>
		<p>홀수</p>
	<%}%>
</body>
</html>