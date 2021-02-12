<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>

<!-- header부분 template Start-->
<div>
	<jsp:include page="/temp/header">
		<jsp:param name="param1" value="value1"/>
	</jsp:include>
</div>
<!-- header부분 template End -->

<body>
	<h1>로그인 페이지입니다.</h1>
	<form id="frm">
		<div><input type="text" name="userId" placeholder="ID"></div>
		<div><input type="password" name="userPw" placeholder="PASSWORD"></div>
		<div><input type="button" value="Login" id="loginBtn"></div>
	</form>
	<div id="errMsg"></div>
	<a href="/user/join">Join</a>
	
	<script src="/resources/js/user/user.js"></script>
</body>
</html>