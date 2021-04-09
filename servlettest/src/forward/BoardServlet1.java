package forward;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;


@WebServlet("/board1")
public class BoardServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagenum = Integer.parseInt(request.getParameter("page"));
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.getBoardList(pagenum, 5);
		
		request.setAttribute("boardlist", list);
		//forward했다면 브라우저 응답출력을 무시
		RequestDispatcher rd = request.getRequestDispatcher("board2");
		rd.forward(request, response);
		
		//출력1 - table 태그 - forward.BoardServlet2.java (board2 url)
		//board2 서블릿 호출 list 전달
		//전달받은 list 를 table 출력
		
		
		//출력2 - ul ol li 태그 - forward.BoardServlet3.java (board3 url)
	}

}
