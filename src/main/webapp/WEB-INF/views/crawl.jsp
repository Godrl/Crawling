<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News</title>
</head>
<body>
	<div class="left_cont">
	<h2>News List</h2>
	<section class="news_box">
		<div class="newsPost">
			<div class="assetText">
	        	<c:forEach items="${newsList }" var="news">
	            	<a href="https://zdnet.co.kr/${news.link }">
	                	<h3>${news.title }</h3>
	                   	<p>${news.body }</p>
					</a>
				</c:forEach>
			</div>
		</div>
	</section>
	</div>
	
</body>
</html>