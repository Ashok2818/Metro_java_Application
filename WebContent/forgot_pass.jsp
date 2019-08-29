<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.add {
	border-radius: 5px;
	background: #E9967A;
	padding: 20px;
	width: 450px;
	height: 400px;
	margin-top: 150px;
	margin-bottom: 250px;
	margin-right: 150px;
	margin-left: 520px;
}

.mono {
	font-size: 20px;
	width: 200px;
	height: 22px;
	margin-left: 50px;
	font-family: Times New Roman, Times, serif;
}

</style>
</head>

<body style="background-color:">
	<form action="/action.page.php" method="post" autocomplete="off">

		<div class="add">

			<span class="mono">

				<center>

					<br>
					<br>
					<br>
					<br>
					<p>enter your email which is used in login potal</p>
					<br> Email: <input type="email" name="email"><br>
					<br>



					<button type="submit">send</button>

				</center>

			</span>
		</div>
	</form>
</body>
</html>
