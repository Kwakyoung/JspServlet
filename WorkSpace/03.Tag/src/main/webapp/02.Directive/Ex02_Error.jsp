<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>현재 알수없는 오류가 발생했습니다.</h1>
	<h2>개발자가 수정중이오니 양해 바랍니다. 최대한 빠르게 대응하려고 노력하겠습니다.</h2>
	<!-- Exception 내장객체를 활용해서 에러 종류를 출력 : 현재 오류처리를 위한 페이지 인지를 알려줘야함. 
		 디렉티브태그의 속성 isErrorPage <-
	-->
	
	<h2>오류 종류를 표시해보기</h2>
	<%=exception.getMessage()%>
	
</body>
</html>