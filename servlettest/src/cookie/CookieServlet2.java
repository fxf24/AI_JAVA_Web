package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie2")
public class CookieServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		
		//현재 서버가 만들어서 전송한 쿠키들
		Cookie[] coos = request.getCookies();

		for(Cookie c : coos) {
			if(c.getName().equals("id")) {
				o.println(c.getName() + "=" + c.getValue() + "<br>");
			}
		}
		o.println("서버로부터 전달받은 쿠키는 위와 같습니다.");
	}

}
