<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<div>
	<h1>login page</h1>

	<form action="/user/login" method="post">
		<div><input type="text" name="uid" placeholder="ID"></div>
		<div><input type="password" name="upw" placeholder="PASSWORD"></div>
		<div><input type="submit" value="Login"></div>
	</form>
	
	<a href="/user/join">Join</a>
</div>
</body>
</html>