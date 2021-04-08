package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detailboard")
public class DetailBoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* 1. seq 파라미터 읽어서
		 * 2. BoardDao 메소드 추가
		 *    2-0. 메소드파라미터(int seq)
		 *    2-1. update board set viewcount = viewcount + 1 where seq=? 실행
		 *    2-1. select * from board where seq=? 실행
		 *    2-2. BoardDTO 타입 리턴
		 * 3. 적당 html 태그들 BoardDTO 내용 출력 응답
		 * 
		 * */
		String seq = request.getParameter("seq");
		int seqnum = Integer.parseInt(seq);
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getDetailBoardList(seqnum);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String result = "";
		result +="<table border = 3>";
		
		result += "<tr><td>번호</td><td>" + dto.getSeq()+ "</td></tr>" 
				+ "<tr><td>제목</td><td>" + dto.getTitle()+ "</td></tr>"
				+ "<tr><td>내용</td><td>" + dto.getContents()+ "</td></tr>"
				+ "<tr><td>비밀번호</td><td>" + dto.getPassword()+ "</td></tr>"
				+ "<tr><td>작성자</td><td>" + dto.getWriter()+ "</td></tr>"
				+ "<tr><td>조회수</td><td>" + dto.getViewcount()+ "</td></tr>";
			
		result += "</table>";
		
		
		out.println(result);
		
	}


}
