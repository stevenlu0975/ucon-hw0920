<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/style/mycss.css" rel="stylesheet"></link>
<title>result</title>
</head>
<body>
<h2>result List</h2>
	<table class="myTable">
		<tbody>
			<% ArrayList<Integer>[] resultList =(ArrayList<Integer>[]) session.getAttribute("resultList"); %>
			<%for(int i=0;i<resultList.length;i++){ %>
				<tr>
					<td>第<%=i+1 %>組</td>
					<%for(Integer number:resultList[i]){%>
						<td><%=" "+ number%></td>
					<%} %>
					
				</tr>
			<%} %>
		</tbody>
	</table>
<h3><a href="<%= request.getContextPath() %>/">GO HOME</a></h3>
</body>
</html>