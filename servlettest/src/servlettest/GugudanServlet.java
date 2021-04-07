package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gugu")
public class GugudanServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gugudan(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		gugudan(request, response);
	}

	private void gugudan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String d = request.getParameter("dan");
		String result = "";
		result += "<form action='gugu' method='post'>";
		result += "출력하고싶은 단을 입력해주세요: <input type=text name='dan'>";
		result += "<input type=submit value='출력'>";
		result += "</form>";
		
		result += "<table border=3>";
		if(d.equals("")) {
			for(int i = 1; i<=9; i++) {
				result += "<tr><td>"+ "2 * "+ i + " = " + 2*i + "</td></tr>";
			}
		}else{
			int dan = Integer.parseInt(d);
			
			if(dan>=2 && dan <=9) {
				for(int i = 1; i<=9; i++) {
					result += "<tr><td>"+dan + " * "+ i + " = " + dan*i + "</td></tr>";
				}
			}
			else {
				for(int i = 1; i<=9; i++) {
					result +="<tr>";
					for(int j = 2; j<=9; j++) {
						result += "<td>"+j + " * "+ i + " = " + j*i + "</td>";
					}
					result +="</tr>";
				}
			}
		}
		
		result += "</table>";
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);//클라이언트 브라우저
	}
}
