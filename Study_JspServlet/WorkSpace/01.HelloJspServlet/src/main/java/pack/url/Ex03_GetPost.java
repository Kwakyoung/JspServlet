package pack.url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03_GetPost")
public class Ex03_GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
//											  요청 							응답
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqTxt = request.getParameter("txt1");
		System.out.println(reqTxt);
		response.getWriter().append(" GET KYG ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(" POST KYG ").append(request.getContextPath());
	}

}
