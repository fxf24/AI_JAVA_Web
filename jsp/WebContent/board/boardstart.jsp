<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");

%>
<table border="3">
<%
	for(BoardDTO dto : list){
%>
<tr>
<td><% out.print(dto.getSeq());%></td>
<td><% out.print(dto.getTitle());%></td>
<td><% out.print(dto.getWriter());%></td>
<td><% out.print(dto.getPassword());%></td>
</tr>
<% 
	}
%>
</table>

</body>
</html>