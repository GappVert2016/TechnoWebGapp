<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
</head>
<body>
<form action="j_spring_security_check" method="post">
	<table>
		<tr>
			<td>Login</td>
			<td><input type="text" name="j_username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="j_password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="login"></td>
		</tr>
	</table>
</form>


</body>
</html>