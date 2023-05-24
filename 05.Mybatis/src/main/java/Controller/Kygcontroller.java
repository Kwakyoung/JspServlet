package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kyg.KygVO;
import oracle.jdbc.driver.OracleDriver;

@WebServlet("*.kyg")
public class Kygcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		if(req.getServletPath().equals("/list.kyg")) {
			rd = req.getRequestDispatcher("kyg/list.jsp");
			ArrayList<KygVO> list = new ArrayList<>();
			// <> <- Object를 상속받은 Class 타입만 넣을수있음.
			for(int i=0; i<10; i++) {
//			KygVO vo = new KygVO();
//			vo.setField1("필드1"+i);
//			vo.setField2(10+i);
//			list.add(vo);
			}
			req.setAttribute("list", list);
			
			
		}else {
			System.out.println("잘못된요청");
		}
		rd.forward(req, resp);  // 이거있어야 정보를 받아서 보여줌
	}
	
	
}
