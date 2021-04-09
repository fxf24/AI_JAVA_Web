package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDTO;

@WebServlet("/session3")
public class SessionServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		
		HttpSession session = request.getSession();
		if(session.isNew()) {//클라이언트 요청속에 세션 없다 =  서버 남긴 정보가 없다 = 최초 요청
			dto.setId("jdbc");
			dto.setPassword(1111);
			dto.setName("박입문");
			session.setAttribute("member", dto);
		}
		else {
			dto = (MemberDTO)session.getAttribute("member");
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인= " + dto + "<br>");
	}

}
