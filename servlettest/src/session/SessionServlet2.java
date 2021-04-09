package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session2")
public class SessionServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//브라우저 열고 요청1 - 요청2 - 브라우저 종료 - 세션정보 삭제
		//세션정보 서버측 저장, 세션정보 사용가능식별자 클라이언트측 저장(=세션id 쿠키 저장-JSESSIONID)
		String id = "", pw = "";
		HttpSession session = request.getSession();

		id = (String)session.getAttribute("id");
		pw = (String)session.getAttribute("pw");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("세션정보확인= " + id + ":" + pw + "<br>");
	}

}
