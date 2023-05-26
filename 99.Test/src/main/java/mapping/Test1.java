package mapping;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// customer => *.cu (고객관련 처리는 여기 컨트롤러)
@WebServlet("*.test") // " " <- url을 통해서 들어온 값 ( 구분자 . ) 
public class Test1 extends HttpServlet {
	
	// 요청 (req) , 응답 (res) 
	// url을 통해서 요청 => Servlet(Controller)
	// 				  => Servlet자체에 응답을 처리할때 : resp
	//				  => Servlet자체에서 처리가 아니라 그다음 페이지에서 처리를 할때
	
	
      @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  System.out.println("여까지 옴");
//    	  resp.getWriter().print("data");
    	  // 사용자가 어떤 요청을 하고있을대 필요한 정보가 있다면 url로 파라메터를 넘겨줌.
    	  // GET : mapping?name=value
    	  // key1에 kyg (이니셜)
    	  // key2에 숫자 아무거나. 파라메터로 입력 받아서 .test가 실행되게 만들기 ( URL )
    	  req.setAttribute("info", "kyg");
    	  
    	  RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    	  
    	  rd.forward(req, resp);
    }

}
