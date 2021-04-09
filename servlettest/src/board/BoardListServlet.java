package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardlist")
public class BoardListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = null;
		if(page == null||page.equals("")) {
			list = dao.getBoardList();
		}
		else {
			int pagenum = Integer.parseInt(page);
			list = dao.getBoardList(pagenum, 5);
		}
		
		//페이지번호 없으면 전체 board리스트 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result = "";
		result +="<table border = 3>";
		
		for(BoardDTO dto : list) {
			result += "<tr><td>" + dto.getSeq() + "</td><td><a href='detailboard?seq=" + dto.getSeq()+ "'>" + dto.getTitle() 
			+ "</a></td><td>" + dto.getWriter() + "</td><td>" + dto.getViewcount() + "</td><tr>";
		}
		
		result += "</table>";
		
		result += "<h1>페이지번호</h1>";
		
		int totalcnt = dao.getBoardCount();
		int pagecnt = totalcnt / 5;
		if(totalcnt % 5 != 0) {pagecnt = pagecnt +1;}
		for(int i = 1; i <= pagecnt; i++) {
			result += "<a href='boardlist?page=" + i + "'>" + i + "</a>&nbsp";
		}
		
		result += "<br><button id='write'> 글쓰기 </button>";
		result += "<script>document.getElementById('write').onclick = function(){"
				+ " location.href='boardwrite.html'"
				+ "}</script><br>";
		
		//작성자 xxx(세션에서 가져와서) 글쓰기를 완료했습니다 출력
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("writer");
		BoardDTO dto = (BoardDTO)session.getAttribute("board");
		if(id!= null && dto != null) {
			result += "<h3>작성자" + id + "글쓰기를 완료했습니다</h3>";
			result += "<h3>글 쓴 내용은 다음과 같습니다.</h3>";
			result += dto.toString();
		}
		out.println(result);
		session.invalidate();
	}

}

/* 1. wbcontent\boardwrite.html 작성
 * 제목 input text
 * 내용 textarea
 * 작성자 input text
 * 암호 input password
 * ==> 입력받아 작성 버튼 클릭하면 post방식으로 boardwirte 전송
 * 
 * 2. boardwrite -- board.BoardWriteServlet.java 작성
 * doPost -- BoardDAO - insertBoard(BoardDTO) DB 저장
 * 
 * */
