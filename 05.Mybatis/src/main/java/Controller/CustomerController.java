package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerVO;

@WebServlet("*.cu") // 하나의 요청씩처리 /list.cu
					// 특정 규칙을 가진 구분자의 모든 처리 (cu) : '/' 쓰지말고 *.cu로 쓰면 됨
					// Servlet파일 추가시 리스타트 꼭 해주기
					// 페이지의 요청 : RequestDispatcher <-
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mapping = req.getServletPath();
		System.out.println(mapping);
		// detail.cu로 요청이 오면 detail.jsp로 페이지 요청을 해보기.
		CustomerDAO dao = new CustomerDAO(); 
		
		if(mapping.equals("/list.cu")) {
			new CustomerDAO().listSelect();
			List<CustomerVO> list = new CustomerDAO().listSelect();
			req.setAttribute("list",list );
			
			System.out.println("열어줌");
			rd = req.getRequestDispatcher("customer/list.jsp");
		}else if(mapping.equals("/detail.cu")){
			System.out.println("여기");
			
			// ulr 또는 get post 방식으로 servlet 으로 오는 모든 데이터는 parameter(String)
			// req ( 요청 ) , response ( 응답 )
			// req객체의 set&getAttribute , getParamter
			// getParameter : jsp 또는 html 페이지에서 servlet(back)요청 ( a태그 form url )
			// setAttribute , get : servlet 동작을 하고 데이터를 전송 =>
			int id = Integer.parseInt(  req.getParameter("id")  );
			CustomerVO vo = dao.test1(id);
			req.setAttribute("vo", vo);
			
			rd = req.getRequestDispatcher("customer/detail.jsp");
	    }else if(mapping.equals("/update.cu")) {
	    	String id = req.getParameter("id");
	    	String email = req.getParameter("email");
	    	String phone = req.getParameter("phone");
	    	dao.update(id, email, phone);
	    	
		}else if(mapping.equals("/insert.cu")) {
			System.out.println("여기");
			rd = req.getRequestDispatcher("customer/insert.jsp");
		
		}else if(mapping.equals("/new.cu")){
			System.out.println(req.getParameter("id"));
			CustomerVO vo = new CustomerVO();
			vo.setId(Integer.parseInt(req.getParameter("id")));
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setPhone(req.getParameter("phone"));
			
			dao.insert(vo);
			
		}else {
		
			System.out.println("잘못된 요청 처리임");
		}
		rd.forward(req, resp); // 실제로 페이지 요청 처리.
//		rd = req.getRequestDispatcher("customer/list.jsp");
//		rd.forward(req, resp); // 실제로 페이지 요청 처리.
		
	}
}
