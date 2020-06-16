<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VocabQuestion</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/result.css">
<script src="${pageContext.request.contextPath}/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/result.js"></script>
</head>
<body>
<h1>Result</h1>
<table id="resultPage">
    <tr>
      <th>S.No</th>  
      <th>Question</th>
      <th>Correct Option</th>
      <th>Your Option</th>
    </tr>
  </table>
<form method="get" action="/vocab/addword">
    <button type="button" onclick="goVocab()">Retake Quiz</button>
</form>
</body>
</html>