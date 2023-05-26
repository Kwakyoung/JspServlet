package mapping;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// mapping은 주소를 통해서 들어온 요청을 정확하게
// 구분하기 위한것이기 때문에 중복 x
@WebServlet("*.test1")
public class Test2 extends HttpServlet {
	
	 @Override
	 protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 	System.out.println(req.getParameter("key1"));
	 		resp.getWriter().print("kyg");
	 }
}
