package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		dto.setTitle(title);
		dto.setContents(content);
		dto.setWriter(writer);
		dto.setPassword(Integer.parseInt(password));
		
		int flag = dao.insertBoard(dto);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result = "";
		
		if(flag >=1) {
//			result += title + content + writer + password;
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
