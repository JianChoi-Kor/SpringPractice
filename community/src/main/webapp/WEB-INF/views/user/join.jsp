<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<!-- /를 앞에 주고 안 주고의 차이 안 주면 끝에 주소값만 바뀌고 /를 주면 맨 앞에 주소부터 다 바뀐다. -->
	<div><a href="/user/login">Go to Login</a></div>

	<form id="frm">
		<div>
			<input type="text" name="userId" placeholder="ID">
			<input type ="button" value="중복체크" id="chkIdBtn">
		</div>
		<div id="idChkMsg" class="errMsg"></div>
		<div><input type="password" name="userPw" placeholder="PASSWORD"></div>
		<div><input type="password" name="userPwRe" placeholder="COMFIRM PASSWORD"></div>
		<div><input type="text" name="nm" placeholder="NAME"></div>
		<div>Gender : 
			<label>Woman<input type="radio" name="gender" value="0" checked></label>
			<label>Man<input type="radio" name="gender" value="1"></label>
		</div>
		<div><input type="button" value="Join" id="joinBtn"></div>
	</form>
</div>