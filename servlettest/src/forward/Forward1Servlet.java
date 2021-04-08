package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDTO;


@WebServlet("/forward1")
public class Forward1Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<h1>(forward1)로그인아이디=" + id + "</h1>");
		
		//get/setparameter-String(객체전달x)
		//get/setAttribute - String + 객체전달 o
		//현재 서블릿이 forward2 서블릿 객체 전달
		BoardDTO dto = new BoardDTO();
		dto.setTitle("제목");
		dto.setContents("내용");
		
		request.setAttribute("board", dto);
		//request.getAttribute("board")
		
		RequestDispatcher d = request.getRequestDispatcher("forward2");
		d.forward(request, response);
		//forward시에는 이전 응답 출력 저장 삭제 - 이동
	}

}
