<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="b.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String num = request.getParameter("num");//null
int num2 = Integer.parseInt(num);
//NullPointerException, NumberFormatException
out.println("<h1>" + 10/num2 + "</h1>");//ArithmeticException
%>
</body>
</html>