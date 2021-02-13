<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>

<!-- header부분 template Start-->
<div>
	<jsp:include page="/temp/header">
		<jsp:param name="param1" value="value1"/>
	</jsp:include>
</div>
<!-- header부분 template End -->

<body>
	<h1>카테고리 이름 어떻게 가져오지?</h1>

	<div>
		<c:if test="${sessionScope.loginUser != null}">
			<a href="/board/write?category=${param.category}">
				<button>글쓰기</button>
			</a>
		</c:if>
	</div>
	
	<div>
		<c:choose>
			<c:when test="${fn:length(requestScope.list) == 0}">
				<div>글이 없습니다.</div>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>글 번호</td>
						<td>제목</td>
						<td>조회수</td>
						<td>작성일자</td>
						<td>작성자</td>
					</tr>
				<c:forEach items="${requestScope.list}" var="item">
					<tr onclick="goToDetail(${item.boardPk})">
						<td>${pageScope.item.seq}</td>
						<td><c:out value="${pageScope.item.title}"/></td>
						<td>${pageScope.item.hits}</td>
						<td>${pageScope.item.regDt}</td>
						<td>${pageScope.item.writerNm}</td>
					</tr>
				</c:forEach>	
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div>
		페이징
	</div>

	<script src="/resources/js/board/list.js"></script>
</body>
</html>