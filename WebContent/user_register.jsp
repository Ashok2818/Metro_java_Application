<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.create {
	border-radius: 10px;
	background: #F8F8FF;
	padding: 20px;
	width: 800px;
	height: 800px;
	margin-top: 150px;
	margin-bottom: 250px;
	margin-right: 150px;
	margin-left: 420px;
}

.fieldset {
	font-size: 20px;
	width: 200px;
	height: 22px;
	margin-left: 50px;
	font-family: Times New Roman, Times, serif;
}

.background {
	background-image: url(reg_background.png);
	background-repeat: </head>
}
</style>
<body calss="background">

	<form action="" method="get">

		<div class="create">

			<h3>
				<i> Note : please fill below registeration form </i>
				<h3>

					<span class="fieldset">

						<center>

							<i> Full Name : <input type="text" name="First_Name"
								maxlength="30" pattern="[A-Za-z]{1,30}"
								title="use only alphabets" required><br>
							<br>
							<br> Mobile number : <input type="tel" name="usertel"
								maxlength="10" pattern="[0-9]{10}"
								title="should contain 10 numbers" required><br>
							<br>
							<br> Store name : <input type="text" name="store_name"
								maxlength="20" pattern="[A-Za-z\s]{1,30}" required> <br>
							<br>
							<br> country : <input type="text" name="store_country"
								maxlength="20" pattern="[A-Za-z\s]{1,30}" required> <br>
							<br>
							<br> city : <input type="text" name="store_city"
								maxlength="20" pattern="[A-Za-z\s]{1,30}" required> <br>
							<br>
							<br> Area : <input type="text" name="store_area"
								maxlength="20" pattern="[A-Za-z\s]{1,30}" required> <br>
							<br>
							<br> email : <input type="email" name="email" required><br>
							<br>
							<br> create user name : <input type="text" name="user_name"
								maxlength="20" pattern="[A-Za-z0-9\s]{1,10}" required> <br>
							<br>
							<br> create password : <input type="text" name="passcode"
								maxlength="20" pattern="[A-Za-z0-9\s]{1,10}" required> <br>
							<br>
							<br> employee id : <input type="number" name="someid"
								required><br>
							<br>
							<br>

							</i> <button type="submit" formaction="/MetroProjectExample/register">submit</button>
							</button>

						</center>

					</span>
		</div>

	</form>
</body>
</html>