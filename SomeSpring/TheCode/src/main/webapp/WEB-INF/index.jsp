<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter the code</h1>
<h3>${error}</h3>
<form method="POST" action="/submit">
	<label>What's the code?: <input type="text" name="input"></label>
	<button>Submit</button>
</form>
</body>
</html>