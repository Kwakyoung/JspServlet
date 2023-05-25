<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${vo.name}의 상세정보</h1>
	<h3>수정정보</h3>
	<!-- email , phone 정보를 CustomerController로 다시 전송해보기.
		 콘솔창에 찍기 -->
	<form action="update.cu">
	<input type ="hidden" name="id" value="${vo.id}">
	<input type ="text" name="email" value="${vo.email}">
	<input type ="text" name="phone" value="${vo.phone}">
	<input type="submit">
	</form>
</body>
</html>