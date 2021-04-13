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
pageContext.setAttribute("share1", "1");
request.setAttribute("share2", "10");
session.setAttribute("share3", "100");
application.setAttribute("share4", "1000");
%>

<h1>jsp내장객체로 확인합니다</h1>
<h3><%=pageContext.getAttribute("share1")%></h3>
<h3><%=request.getAttribute("share2")%></h3>
<h3><%=session.getAttribute("share3")%></h3>
<h3><%=application.getAttribute("share4")%></h3>

<h1>el내장객체로 확인합니다</h1>
<h3>${pageScope.share1 }</h3>
<h3>${requestScope.share2 }</h3>
<h3>${sessionScope.share3 }</h3>
<h3>${applicationScope.share4 }</h3>

<h1>el내장객체로 확인합니다</h1>
<h3>${share1 }</h3>
<h3>${share2 }</h3>
<h3>${share3 }</h3>
<h3>${share4 }</h3>
<%-- <jsp:forward page="share2.jsp"></jsp:forward> --%>
</body>
</html>