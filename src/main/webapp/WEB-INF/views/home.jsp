<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<input type="button" id="submit" name="crawl" value="Crawling"></input>
</body>

<script>
	$(document).ready(function() {

		$("#submit").on("click", function() {
			location.href = "crawl";
		});				
		
	});
</script>

</html>
