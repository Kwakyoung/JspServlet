package pack.url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@Override , @~~ 기계가 인식(해석)하는 주석으로 Annotation은 해당하는 클래스나 메소드의 기능을 함축시켜 표현함.
@WebServlet("/Ex01_Servlet")  // Controller 
public class Ex01_Servlet extends HttpServlet {

// Form ( 폼 태그 내부에 있는 내용을 변수형태로 바꿔서 URL로 요청하는 처리를 한다. ( 제출, 전송 )
// Form 태그의 Get Method를 의미함. 
// GET  : 요청받은 파라메터(FORM태그 내부요소)의 값을 URL에 노출시킨다. 
// POST : 요청받은 파라메터를 안보여주고 요청함.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 사용자가 URL을 통해서 요청이 오면 여기 메소드가 실행됨 ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
