<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<h1>카테고리 이름</h1>
<div>
	<c:if test="${sessionScope.loginUser != null}">
		<a href="/board/write?category=${param.category}">
			<button>글쓰기</button>
		</a>
	</c:if>
	
	글 갯수:
	<select id="selRowCnt">
		<option value="5">5개</option>
		<option value="10">10개</option>
		<option value="15">15개</option>
	</select>
	
	<!-- 검색기능 -->
	<select id="selSearchType">
		<option value="1">제목</option>
		<option value="2">내용</option>
		<option value="3">제목+내용</option>
		<option value="4">작성자</option>
	</select>
	
	<input type="search" id="txtSearchText">
	<input type="button" value="검색" onclick="search()">
	
</div>

<div id="listContent" data-category="${param.category}">

</div>

	
<div>
	
</div>

<div id="pagingContent">

</div>

<!-- 
	<c:choose>
		<c:when test="${fn:length(requestScope.list) == 0}">
			<div>글이 없습니다.	</div>
		</c:when>
		<c:otherwise>
			<table class="basic-table">
				<tr>
					<td>글 번호</td>
					<td>제목</td>
					<td>조회수</td>
					<td>작성일자</td>
					<td>작성자</td>
				</tr>
			<c:forEach items="${requestScope.list}" var="item">	
				<tr class="recode" onclick="goToDetail(${item.boardPk})">
					<td>${pageScope.item.boardPk}</td>
					<td><c:out value="${pageScope.item.title}"/></td>
					<td>${pageScope.item.hits}</td>
					<td>${pageScope.item.regDt}</td>
					<td><c:out value="${pageScope.item.writerNm}"/></td>
				</tr>
			</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
 -->
	
<script src="/res/js/board/list.js"></script>



