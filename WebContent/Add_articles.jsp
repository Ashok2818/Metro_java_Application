<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.add {
	border-radius: 5px;
	background: #E9967A;
	padding: 20px;
	width: 350px;
	height: 250px;
}

.size {
	font-size: 20px;
	margin-top: 50px;
	margin-bottom: 550px;
	margin-right: 250px;
	margin-left: 250px;
}
</style>
</head>
<body>
	<form method="get" autocomplete="off">
	<% HttpSession sess =request.getSession(false); 
  String user =(String) sess.getAttribute("user");
  sess.setAttribute("user", user);%>

		<div class="add">
			<span class="size">
				<center>
					Article id : <input type="text" name="Article_id" required><br>
					<br> Article Name : <input type="text" name="Article_Name" required><br>
					<br> Store Name : <input type="text" name="Store_Name" required><br>
					<br> Color : <input type="text" name="color"><br>
					<br>  <button type="submit" formaction="/MetroProjectExample/Add_articles"
							value="login">submit</button> 
			</span>
		</div>


		</center>
	</form>
</body>
</html>