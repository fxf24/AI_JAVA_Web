<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
id, pw, location 파라미터 폼으로부터 post방식으로 전송
id = jsp/ pw = jsp 이면 정상 로그인되었으면 location출력
id = jsp/ pw = jsp 아니면 비정상 로그인되었으면 loginform.jsp리턴
 -->
 <%
 if(request.getMethod().equals("POST")){
	 request.setCharacterEncoding("utf-8");
 }
 
String id = request.getParameter("id");
String pw = request.getParameter("pw");
if(id.equals("jsp") && pw.equals("jsp")){
	out.println("<h1>정상 로그인 되었습니다.</h1>");
	String[] locs = request.getParameterValues("location");
	for(String loc : locs){
		out.println("<h3>"+ loc + "</h3>");
	}
}
else{
	out.println("<a href='loginform.jsp'>로그인폼으로 이동</a>");

/* 	RequestDispatcher rd = request.getRequestDispatcher("loginform.jsp");
	rd.forward(request, response); */
}
//response.addCookie(new Cookie("c1","jsp"));
//response.sendRedirect("http://www.daum.net");
 %>
 <jsp:forward page="loginform.jsp">
 	<jsp:param value="아이디 인증받지 못했습니다" name="message"/>
 </jsp:forward>
</body>
</html>