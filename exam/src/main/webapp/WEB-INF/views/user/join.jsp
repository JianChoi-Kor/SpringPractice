<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>
<body>
	<div>
	<h1>join page</h1>
	
	<div><a href="/user/login">Login</a></div>

	<form action="/user/join" method="post">
		<div><label>아이디 : <input type="text" name="uid" placeholder="ID"></label></div>
		<div><label>비밀번호 : <input type="password" name="upw" placeholder="PASSWORD"></label></div>
		<div><label>이름 : <input type="text" name="nm" placeholder="NAME"></label></div>
		<div><input type="submit" value="Join"></div>
	</form>
</div>
</body>
</html>