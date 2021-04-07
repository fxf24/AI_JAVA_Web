package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		login(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		login(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//브라우저에서 한글 입력시 인코딩

			Enumeration<String> names = request.getParameterNames();
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				System.out.println(name);
			}
			
			//요청 정보 추출 id, pw전송 - 입력
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String[] location = request.getParameterValues("location");//모든 선택
			
			//로그인 처리-id=user pw=1234
			String result = "";
			if(id.equals("user") && pw.equals("1234")) {
				result = "<h3 style=color:green>정상 로그인되었습니다.</h3>";
			}
			else {
				result = "<h3 style=color:red>비정상 로그인되었습니다.</h3>";
				result += "<a href='loginform.html'>로그인창으로 이동</a>";
			}
			
			//서블릿이 응답 결과 브라우저 출력 text/html-mime type
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(result);//클라이언트 브라우저
			System.out.println(result);//서버 콘솔
			
			out.println("<h3>선택한 장소는 다음과 같습니다</h3>");
			for(String loc : location) {
				out.println(loc+"<br>");
			}
	}
}
