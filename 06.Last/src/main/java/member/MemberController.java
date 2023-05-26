package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		
		if(req.getServletPath().equals("/member/loginpage.mem")) {
			rd = req.getRequestDispatcher("login.jsp");
		}else if(req.getServletPath().equals("/member/login.mem")){
			System.out.println(req.getParameter("id"));
			System.out.println(req.getParameter("pw"));
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			if(id.equals("kyg") && pw.equals("0000")) {
				resp.getWriter().print("A"); // 응답객체를 이용해서 요청을 처리함. req를 통해서 페이지를 요청하는 처리로 마무리를 하거나.(요청에 대한 응답을)
				 							 // 응답객체를 이용해서 요청을 처리하면 그다음 코드에는 다시 요청에 대한 응답처리가 오면 안됨.
			}else {
				resp.getWriter().print("B");
			}
			
			return;
		}else { // 에러페이지 넣기.
		}
			
		
		rd.forward(req, resp);
	}
}
