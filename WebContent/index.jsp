<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
	border-radius: 50%;
}

.center {
	border-radius: 10px;
	background: #D8BFD8;
	padding: 20px;
	width: 400px;
	height: 400px;
	margin-top: 150px;
	margin-bottom: 250px;
	margin-right: 150px;
	margin-left: 620px;
}

.field {
	font-size: 22px;
	width: 200px;
	height: 22px;
}
</style>
</head>
<body style="background-color:">


	<form action="" method="get">

		<div class="center">
			<pre>                 <img src="images/login_logo.png" alt="Avatar"
					style="width: 150px"> </pre>

			<div class="field">

				<pre> <b>  user id  : <input type="text" name="user_name">  <br>
 
   password : <input type="password" name="user_password"> 
   
               <button type="submit" formaction="/MetroProjectExample/user_form"
							value="login">login</button> 
				</pre>

				<pre> <a href="user_register.jsp" target="_blank">create account</a>  <a
						style="margin-left: 2" href="forgot_pass.jsp" target="_blank">forgot password</a>
				</pre>

			</div>
		</div>


	</form>
</body>
</html>

 