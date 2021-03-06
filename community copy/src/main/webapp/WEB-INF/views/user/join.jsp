<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
</head>

<!-- header부분 template Start-->
<div>
	<jsp:include page="/temp/header">
		<jsp:param name="param1" value="value1"/>
	</jsp:include>
</div>
<!-- header부분 template End -->

<body>
	<h1>회원가입 페이지입니다.</h1>
		
		<form id="frm">
			<div>
				<input type="text" name="userId" placeholder="ID"> 
				<input type="button" value="중복체크" id="chkIdBtn">
			</div>
			<div id="idChkMsg" class="errMsg"></div>
			<div>
				<input type="password" name="userPw" placeholder="PASSWORD">
			</div>
			<div>
				<input type="password" name="userPwRe" placeholder="COMFIRM PASSWORD">
			</div>
			<div>
				<input type="text" name="nm" placeholder="NAME">
			</div>
			<div>
				<input type="button" value="Join" id="joinBtn">
			</div>
		</form>
		
		<a href="/user/login">Login</a>


	<script src="/resources/js/user/user.js"></script>
</body>
</html>