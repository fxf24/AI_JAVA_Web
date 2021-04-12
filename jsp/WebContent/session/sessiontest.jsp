<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String session_id="";
if(session.getAttribute("session_id") != null){
	session_id = (String)session.getAttribute("session_id");
}
else{
	out.println("로그아웃했거나 아직 로그인전입니다.");
}
%>
<h1><%=session_id %> 회원님 로그인하셨습니다.</h1>
<h3><a href="sessiontest2.jsp"> 내 후기 보러 가기</a></h3>
<h3><a href="sessiontest3.jsp"> 내 정보 보러 가기</a></h3>
<h3><a href="sessiontest4.jsp"> 로그아웃하러가기</a></h3>
<h3><a href="/jsp/sessiontest"> 로그인 하러가기</a></h3>
</body>
</html>