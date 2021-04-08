package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int j = 1;
		for(int i = 1; i <= pagecnt; i++) {
			result += "<a href='boardlist?page=" + j + "'>" + i + "</a>&nbsp";
			j+=5;
		}
		
		result += "<br><button id='write'> 글쓰기 </button>";
		result += "<script>document.getElementById('write').onclick = function(){"
				+ " location.href='boardwrite.html'"
				+ "}</script>";
		out.println(result);
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
