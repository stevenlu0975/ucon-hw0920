<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/style/mycss.css" rel="stylesheet"/>
<title>lottery</title>
</head>
<body>
	<h1>Lottery</h1>
	<table class="myTable"  style=" width: 500px; height: 200px;">
		<tbody>
			<form action="lotteryController.do" method="post">
				<tr>
					<td>產生號碼組數 <br/>(介於1~100)</td>
					<td><input type="number" name="set" size="20" min="1" max="100"></td>
				</tr>
				<tr>
					<td>排除數字<br/>(請以 空白建分隔數字) </td>
					<td><input type="text" name="excludeNumbers" size="30" ></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="送號"> 
						<input type="reset" value="重製">
					</td>
				</tr>

			</form>
		</tbody>	
	</table>
	<%session.invalidate(); %>
	<h3><a href="<%= request.getContextPath() %>/">GO HOME</a></h3>
</body>
</html>