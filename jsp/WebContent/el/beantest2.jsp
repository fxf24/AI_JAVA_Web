<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dto" class="board.BoardDTO" scope="session"/>
제목 확인2: <jsp:getProperty property="title" name="dto"/><br>
내용 확인2: <jsp:getProperty property="contents" name="dto"/><br>
작성자 확인2: <jsp:getProperty property="writer" name="dto"/><br>
암호 확인2: <jsp:getProperty property="password" name="dto"/><br>
</body>
</html>