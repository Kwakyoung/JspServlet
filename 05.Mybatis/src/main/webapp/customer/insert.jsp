<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>추가하기</h1>
	<form action="new.cu">
	<table>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>폰</td>
		</tr>
		<tr>
			<td><input type="text" name = "id" placeholder="아이디"></td>		
			<td><input type="text" name = "name" placeholder="이름"></td>	
			<td><input type="text" name = "email" placeholder="이메일"></td>
			<td><input type="text" name = "phone" placeholder="핸드폰"></td>
		</tr>
		</table>
			<input type="submit">
	</form>
</body>
</html>