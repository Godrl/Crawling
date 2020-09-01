<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News</title>
</head>
<body>
	<h2>News List</h2>
	<section class="news_box">
		<c:forEach items="${newsList }" var="news">
			<div class="assetText">
				<h3>${news.title }</h3>
				<p>${news.body }</p>
			</div>			
		</c:forEach>
	</section>
	
</body>
</html>