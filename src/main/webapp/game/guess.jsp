<%@page import="java.util.LinkedList"%>
<%@page import="com.systex.service.GuessGame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/style/mycss.css" rel="stylesheet"/>
<title>Guess</title>
</head>
<body>
	<h2>Guess Game</h2>
	<!-- error report -->
<%GuessGame guessgame =(GuessGame)session.getAttribute("GuessGame"); %>




	<table class="myTable"  style=" width: 300px; height: 100px;">
		<tbody>
			<form action="gameController.do" method="post">
				<tr><td>GUESS NUMBER FORM 1 TO 10</td></tr>
				<%if(guessgame!=null){ %>
				<%if(guessgame.getRemains()!=3){ %>
				<tr><td style="color: red">WRONG NUMBER</td></tr>
				<%} %>
				<tr><td>REMAINING LIVES<%=" "+guessgame.getRemains() %></td></tr>
				<%} %>
				<%LinkedList<String> errorList = (LinkedList<String>)request.getAttribute("errors"); %>
				<%if(errorList!=null){ 
					for(String error:errorList){%>
						<tr><td style="color: red"><%=error %></td></tr>
					<%} %>
				<%} %>
				<tr>
					<td>
					<input type="number" name="number" size="30" placeholder="1~10" min="1" max="10">
					<input type="submit" value="GUESS">
					</td>
				</tr>

			</form>
		</tbody>	
	</table>
	

<h3><a href="<%= request.getContextPath() %>/">GO HOME</a></h3>
</body>
</html>