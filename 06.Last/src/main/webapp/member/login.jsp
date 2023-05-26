<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%-- <jsp:include page="/include/head.jsp"/> --%>
	<%@ include file = "/include/head.jsp" %>
<body id="page-top">
	<%@include file="/include/header.jsp" %>
	<section class="page-section" id="contact">
	<div class="container">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">로그인</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><svg class="svg-inline--fa fa-star" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" data-fa-i2svg=""><path fill="currentColor" d="M316.9 18C311.6 7 300.4 0 288.1 0s-23.4 7-28.8 18L195 150.3 51.4 171.5c-12 1.8-22 10.2-25.7 21.7s-.7 24.2 7.9 32.7L137.8 329 113.2 474.7c-2 12 3 24.2 12.9 31.3s23 8 33.8 2.3l128.3-68.5 128.3 68.5c10.8 5.7 23.9 4.9 33.8-2.3s14.9-19.3 12.9-31.3L438.5 329 542.7 225.9c8.6-8.5 11.7-21.2 7.9-32.7s-13.7-19.9-25.7-21.7L381.2 150.3 316.9 18z"></path></svg><!-- <i class="fas fa-star"></i> Font Awesome fontawesome.com --></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <!-- * * * * * * * * * * * * * * *-->
                        <!-- * * SB Forms Contact Form * *-->
                        <!-- * * * * * * * * * * * * * * *-->
                        <!-- This form is pre-integrated with SB Forms.-->
                        <!-- To make this form functional, sign up at-->
                        <!-- https://startbootstrap.com/solution/contact-forms-->
                        <!-- to get an API token!-->
                        <form id="contactForm" data-sb-form-api-token="API_TOKEN">
                            <!-- ID input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" name="id" id="id" type="text" placeholder="ID를 입력하세요" data-sb-validations="required" data-sb-can-submit="no">
                                <label for="name">아이디</label>
                                <div class="invalid-feedback" data-sb-feedback="name:required">아이디 필수입력</div>
                            </div>
                            <!-- PW input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" name="pw" id="pw" type="password" placeholder="PW를 입력하세요" data-sb-validations="required" data-sb-can-submit="no">
                                <label for="email">패스워드</label>
                                <div class="invalid-feedback" data-sb-feedback="pw:required">패스워드 필수입력</div>
                            </div>
                            <a class ="btn btn-primary btn-xl" onclick="login()">로그인</a>
                        </form>
                    </div>
                </div>
            </div>
           </section>
    <%@include file="/include/footer.jsp"%>
    
    <script type="text/javascript">
    	
    	function login() {
    	/* 	alert('눌림');   -> 창 듸움
    		alert($('#id').val());  // selector -> id 값은 # */  
			console.log($('#id').val());
			console.log($('#pw').val());
			if($('#id').val()==''){
				alert('아이디를 입력해주세요!');
				$('#id').focus();
				return;
			}else if($('#pw').val()==''){
				alert('비밀번호를 입력해주세요!');
				$('#pw').focus();
				return;
		}   
		/* 여기까지 도착함 콛 ㅡ스택이. => 아이디 비밀번호가 입력이 된 상태 */
		// get방식으로 ajax비동기 통신을 통해서 servlet으로 데이터 전송.(url) : 페이지 새로고침 없이 데이터만 요청.
		$.ajax({
			type : 'post',		// 요청 방식
			url : 'login.mem',  // 요청 URL
			data : {id:$('#id').val() , pw:$('#pw').val() },   // 요청시보낼 파라메터설정
			success : function ( response ) { // 성공시 실행할 함수
				alert('성공'+ response);
			},
			error : function ( req , text ) { // 실패시 실행할 함수
				alert(text+ ':'  + req.status);	
			}
			
		});
		
    }
    </script>
    
</body>
</html>