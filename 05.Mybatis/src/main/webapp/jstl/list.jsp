<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기까지 왔는지? LIST.JSP (JSTL)</h1>
	<h1> JSTL 사용 ( EL 문법 사용 (Express Language 자바 표현문법 )</h1>
	<p> JSP 개발을 좀 더 편하고 단순화하기 위한 태그 라이브러리 (JSTL) </p>
	<p> JSTL : Jsp Standard Tag Library </p>
	<h3> CORE (jstl/core) </h3>
	<p> jstl은 용도에 따라서 uri(기능)이 나눠져있고 해당하는 기능을 jsp페이지에서 어떤 구분자로 쓸지 prefix로 지정 </p>
	<p> jsp ==> jstl , html ==> 타임리프(추후 배움. 구조가 비슷함) </p>
	<% int num = 100; %><!-- 자바코드를 이용해서 변수를 선언 -->
	<c:set var="num1" value="200"/> <!-- jstl태그 이용해서 변수 선언 prefix="c" < 여서 c. 하면 나옴 -->
	<p>변수 num : <%=num %></p>
	
	<h4> EL문법 </h4>
	<p>자바코드로 변수를 만들거나 코드처리x</p>
	<p>변수 num : ${num}</p>
	<p>변수 num1 : ${num1}</p>
	<c:set var="num2" value="300"/>
	<p>변수의 합 : ${num1+num2}</p>
	<p>el : ${key}</p>
	<p>el : ${kyg}</p>
	<p>el : ${ksb} ${kyg}</p>
	
	<%-- <%if(num==0) %> --%>
	<c:if test="${num2 == 300 }">
		<p>300과 같습니다 core if</p>
	</c:if>
	
	<!-- 구구단의 결과값만 p태그로 출력해보기 -->
	<c:forEach var="i" begin="2" end="9">    
		<c:forEach var="j" begin="1" end="9">
			<p>${i*j}</p>
		</c:forEach>
	</c:forEach>
	
	<!-- 페이지 전환을 Controller를 하고싶음.
		 listdetail.js 요청을 하면 해당하는 맵핑을 판독하여 jstl폴더 하위에 listdetail.jsp파일로 응답을 하고싶다.
		 url이 바뀜.=> a태그 , form 태그
	 -->
	
	<a href="listdetail.js?q_bbsCode_1013"/>JstlController .js로 맵핑요청 </a>
	<form action="listdetail.js" method="post">
		<input type="hidden" name="q_bbsCode" >
		<input type="submit">
	</form>
	
	
	
</body>
</html>