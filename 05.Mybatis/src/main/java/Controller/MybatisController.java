package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kyg.KygDAO;


@WebServlet("*.bat")
public class MybatisController extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		System.out.println("아무글자");
		
		KygDAO dao = new KygDAO();
		dao.test();
	}
   
	

}
