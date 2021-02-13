<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

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
	<div>
		<a href="/board/list?category=${requestScope.data.category}">리스트로 돌아가기</a>
	</div>
	<c:if test="${requestScope.data.userPk == sessionScope.loginUser.userPk}">
		<div>
			<a href="/board/update?category=${requestScope.data.category}&boardPk=${requestScope.data.boardPk}">
				<button>수정</button>
			</a>
			<button id="btnDel">삭제</button>
		</div>
	</c:if>
	
	<div id="data" data-loginuserpk="${sessionScope.loginUser.userPk}" data-pk="${requestScope.data.boardPk}" data-category="${requestScope.data.category}">
		<div>번호 : ${requestScope.data.seq}</div>
		<div>조회수 : ${requestScope.data.hits}</div>
		<div>제목 : <c:out value="${requestScope.data.title}"/></div>
		<div>작성일시 :<c:out value="${requestScope.data.regDt}"/></div>
		<div>작성자 : <c:out value="${requestScope.data.writerNm}"/></div>
		<div><c:out value="${requestScope.data.ctnt}"/></div>
	</div>
	
	<script src="/resources/js/board/detail.js"></script>
</body>
</html>