<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web - ${page}</title>
</head>
<body>
	<div id="wrap">
		<header>
			<h1>Template test</h1>
		</header>
		
	<main>
		<jsp:include page="../${page}.jsp"/>
	</main>
	
	</div>
</body>
</html>