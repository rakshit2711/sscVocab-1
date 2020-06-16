<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>VocabQuestion</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/questions.css">
<script src="${pageContext.request.contextPath}/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/questions.js"></script>
</head>
<body>

<h3>Vocab Quiz</h3>

<div>
  <form  id="form">
  
    
  </form>
  <div class="outer" >
    <input class="inner" type="button" id="btn-first" value="Check Answer" onclick="checkAns()">
    <input class="inner" type="button" id="btn-second" value="Next Question" onclick="nextQues()">
  </div>
  <div class="outer">
    <p class="inner">Score</p>
    <p class="inner" id="curscore">0</p>
  </div>
  
</div>

</body>
</html>
