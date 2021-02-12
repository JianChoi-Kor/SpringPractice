<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- header부분 template Start-->
<div>
	<jsp:include page="/temp/header">
		<jsp:param name="param1" value="value1"/>
	</jsp:include>
</div>
<!-- header부분 template End -->

<body>
	<h1>글쓰기 페이지입니다.</h1>
	<form action="/board/write" method="post">
		<input type="hidden" name="category" value="${param.category}">
		<input type="hidden" name="boardPk" value="0">
		<div><input type="text" name="title" placeholder="제목" required></div>
		<div><textarea name="ctnt" placeholder="내용" required></textarea></div>
		<div><input type="submit" value="등록"></div>
	</form>
</body>
</html>