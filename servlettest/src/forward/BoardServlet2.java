package forward;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDTO;


@WebServlet("/board2")
public class BoardServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardDTO> list = null;
		String result =  "";
		
		if(request.getAttribute("boardlist") == null) {
			result += "<h1>게시물이 없습니다. board1?page=번호를 요청하세요.</h1>";
		}
		else {
			list = (ArrayList<BoardDTO>)request.getAttribute("boardlist");
			
			result +="<table border = 3>";
			
			for(BoardDTO dto : list) {
				result += "<tr><td>" + dto.getSeq() + "</td><td><a href='detailboard?seq=" + dto.getSeq()+ "'>" + dto.getTitle() 
				+ "</a></td><td>" + dto.getWriter() + "</td><td>" + dto.getViewcount() + "</td><tr>";
			}
			
			result += "</table>";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
