<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>WEB Calculator</title>
	</head>
	<body>
		<h3>This is a Web Calculator. Please enter two numbers:</h3><br>	
		<form action="./WebCalculatorController" method="POST">			
			Argument 1: <input type="text" name="arg0"/><br><br>
			Argument 2: <input type="text" name="arg1"/><br><br>			
			<input type="submit" value="Submit"/>
		</form>
	</body>
</html>