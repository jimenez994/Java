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
  <a href="/dashboard">Dashboard</a>
  <form:form method="POST" action="/song/new" modelAttribute="songs">
	<form:label path="title">Title:<br>
	<form:errors path="title"/><br>
	<form:input path="title"/></form:label><br>

	<form:label path="artist">Artist:<br>
	<form:errors path="artist"/><br>
	<form:input path="artist"/></form:label><br>

	<form:label path="rating">Rating(1-10):<br>
	<form:errors path="rating"/><br>
	<form:input type="number" path="rating"/></form:label><br>
	<input type="submit" value="Add Song"/>
  </form:form>

</body>
</html>
