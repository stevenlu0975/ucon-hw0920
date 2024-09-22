<%@page import="com.systex.service.GuessGame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/style/mycss.css" rel="stylesheet"></link>
<title>YouLose</title>
</head>
<body>
<h2>YOU LOSE</h2>
<%int answer =((int)request.getAttribute("answer")); %>
<h3>THE CORRECT ANSWER IS <%=answer %></h3>
<%session.invalidate(); %>
<h3><a href="<%= request.getContextPath() %>/">GO HOME</a></h3>
<h3><a href="<%= request.getContextPath() %>/game/gameController.do">TRY AGAIN</a></h3>
</body>
</html>