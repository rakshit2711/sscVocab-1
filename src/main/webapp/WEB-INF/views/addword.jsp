<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vocab.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<form action="/vocab/addword" method="post">
			<label for="word">Word</label>
			<input type="text" id="word" name="word" placeholder="Word"> 
			<label for="meaning">Meaning</label> 
			<input type="text" id="meaning" name="meaning" placeholder="Meaning">
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>