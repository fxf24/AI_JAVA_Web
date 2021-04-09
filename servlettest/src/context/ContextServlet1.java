package context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/context1")
public class ContextServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		Integer count = null;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(context.getAttribute("cnt")==null) {
			count = new Integer(10);
			context.setAttribute("cnt", count);
			out.println("<h3>cnt속성을공유했습니다</h3>");
		}
		else {
			count = (Integer)context.getAttribute("cnt");
			out.println("<h3>cnt속성을공유받았습니다" + count+ "</h3>");
		}
			
		
		
	}

}
