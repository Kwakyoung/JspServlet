<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hi</h1>
	<p> ${selectOne }</p>
	
	<c:forEach items="${strList}" var="List">
		<p>상세정보 : ${List} </p>
	</c:forEach>
	
	<%-- <%
	ArrayList<String> strList = (ArrayList<String>) request.getAttribute("strList");
	for(String str : strList){%>
	<%= str%>
	<%} %> --%>
</body>
</html>