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
			<div class="newsPost">
				<c:forEach items="${newsList }" var="news">
					<span class="newsThumb">
						<a href="https://zdnet.co.kr/${news.link }" title="">
							<figure class="img">
								<img src="${news.img }" data-src="${news.img }" class="lazyload" width="170" height="122" alt="">
							</figure>
						</a>
					</span>
					<span class="newsText">
	               		<a href="https://zdnet.co.kr/${news.link }">
	                		<h3>${news.title }</h3>
	                   		<p>${news.content }</p>
						</a>
					</span>
				</c:forEach>
			</div>
		</div>
	</section>
	</div>
	
</body>
</html>