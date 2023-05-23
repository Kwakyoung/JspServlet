package Controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어떤글자.js <-로 끝나는 모든것들을 요청받게. => *.js
@WebServlet("*.js")
public class JstlController extends HttpServlet {
	// 기존에 doGet , doPost <= Spring에서는 default로 두가지가 합쳐진 버전의 메소드를 활용한다.
	// service ( get , post 의 모든 요청을 받는 메소드 )
	RequestDispatcher rd; // < 전역변수로 선언해줌
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		// RequestDispatcher <= req객체가 요청을 받고나서 다시 새로운 페이지로 요청을 넘겨야 할때. (Forward) 
		// 페이지를 보여줄지말지를 요청은 Mapping 기준으로 분기 => list.js
		if(req.getServletPath().equals("/list.js")) {
			req.setAttribute("key", "값"); // Forward로 요청을 넘길때는 setAttribute를 통해 데이터 전달.
			req.setAttribute("kyg", "곽영균");
			req.setAttribute("ksb", "김수봉");
			rd = req.getRequestDispatcher("jstl/list.jsp");	 // "" 안에는 다시 전환될 페이지 jsp , html 페이지 경로써주기
			
			// Model(MVC M ) : DAO DTO를 다음페이지로 넘겨주고 요청을 맡긴다.
		}else if(req.getServletPath().equals("/listdetail.js")){   // a태그를 이용해서 새로운 페이지로 이동
			// form태그와 url로 넘어온 파라메터 => req.getParameter ( set은 없음 )
			// Controller에서 => jsp페이지로 넘어갈때 => req.getAttribute 
			// 게시판에서 글을 클릭 => Model로직에 필요한 정보를 Controller로 받는다
			// parameter로 q_bbsCode라는 이름으로 값 1013이 필요함
			// listdetail.js는 글의 상세목록을 보여줄 예정이기 때문. 이때 어떻게 해야할까?
			System.out.println("리퀘스트로부터 요청받은 파라메터 1013");
			System.out.println("조회를 할때, list.jsp=>listdetail로 갈때");
			System.out.println("게시글 번호 => select를 하기 위해서");
			req.setAttribute("selectOne","상세정보"+req.getParameter("q_bbsCode"));
			
			// 문자열을 저장할수있는 ArrayList를 만들고 데이터를 10건 넣어보기.
			ArrayList<String> str = new ArrayList<>();
			for(int i =0; i<10; i++) {
				str.add("A"+i);
			}
			req.setAttribute("strlist", str);
			
			
			rd = req.getRequestDispatcher("jstl/listdetail.jsp");
		}else {
		
			rd = req.getRequestDispatcher("error/list.jsp"); // 나중에 추가예정 KYG(20230523) -> 20230526 까지 만들겠다고 협업시 주석으로 남겨주기
		}
		
		
		rd.forward(req, resp); // jsp페이지로 모든 정보를 넘기고 처리를 떠맡긴다.
	}
	
}
