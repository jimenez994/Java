<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>What is your question?</h2>
	<form:form method="post" action="/questions/new" modelAttribute="newQuestion">
		<form:label path="question">Question:<br>
		<form:errors path="question"/><br>
		<form:textarea path="question"/>
		</form:label>
		
		<p>Tags:</p>
		<input type="text" name="hags"/>
		<p>Max of 3 tags separeted by a comma and lowercased</p>
		<input type="submit" value="submit"/>
	</form:form>
	

</body>
</html>