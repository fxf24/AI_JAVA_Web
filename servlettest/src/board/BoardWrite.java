package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardwrite")
public class BoardWrite extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("id");
		String password = request.getParameter("pw");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		//writer가 member 존재 id이면 writer를 세션에 저장 글쓰기 진행
		boolean memberresult = dao.getMember(writer);
		//writer를 세션에 저장
		HttpSession session = request.getSession();
		//1번쨰 요청 - 세션 생성 | 2번~ - 세션 재사용
		if(session.getAttribute("writer") == null) {
			
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result = "";
		
		if(memberresult) {
			session.setAttribute("writer", writer);
			
			dto.setTitle(title);
			dto.setContents(content);
			dto.setWriter(writer);
			dto.setPassword(Integer.parseInt(password));
			dao.insertBoard(dto);
			
			session.setAttribute("board", dto);
			result += "<h3>저장되었습니다.</h3>";
			result += "<a href='boardlist'>보드로 이동</a>";
		}
		else {
			result += "<h3>저장에 실패했습니다. 작성자를 다시 확인해주세요</h3>";
			result += "<a href='boardlist'>보드로 이동</a>";
		}
		

		out.println(result);
		
	}

}
