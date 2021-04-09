package context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/context3")
public class ContextServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//web.xml <context-param 메뉴 입력
		ServletContext context = request.getServletContext();
		Integer cnt = (Integer)context.getAttribute("cnt");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>cnt속성을공유받았습니다. " +cnt + "</h3>");
		context.setAttribute("cnt", cnt+10);
	}

}
