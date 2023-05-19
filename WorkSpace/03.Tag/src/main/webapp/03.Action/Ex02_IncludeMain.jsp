<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<p> 디렉티브 태그를 이용해서 인클루드를 진행했음 ( Ex03_IncloudMain) </p>
		<p> 액션태그의 include 태그가 열려있으면 어떤 인자값(파라메터)를 보내준다고 인식함.</p>
		<p> 디렉티브 태그와 액션태그의 include차이는 파라메터의 전달여부임</p>
		
		
		<h1>액션을 통한 인클루드</h1>
		<jsp:include page="Ex02Header.jsp">
			<jsp:param value="LogoKyg" name="logoname"/>
		</jsp:include>
		
		<h2> 액션태그 페이지 컨텐츠 </h2>
		
		<jsp:include page="Ex02Footer.jsp">
			<jsp:param value="FooterContent" name="footer"/>
		</jsp:include>
		
		
</body>
</html>