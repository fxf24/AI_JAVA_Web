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

@WebServlet("/session5")
public class SessionServlet5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member") != null) {
			session.invalidate();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인= " + dto + "<br>");	
	}

}
