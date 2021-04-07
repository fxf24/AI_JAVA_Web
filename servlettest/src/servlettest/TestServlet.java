package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:9090/servlettest/servlet/servlettest.TestServlet
// 1.정의(상속 오버라이딩)
// 2. web.xml 서블릿클래스-서블릿이름으로 등록 
// 3. url 서블릿이름 호출
public class TestServlet extends HttpServlet {
	//doGet /doPost
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		String msg = "Hello Servlet";
		out.println("<html><head><title>제목</title></head><body><h1>" + msg + "</h1></body></html>");
	}
}
