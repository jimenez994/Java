<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>Dashboard</h3>
  <a href="/dojo/new">Create a New Dojo</a><br>
  <a href="/ninja/new">Create a New Ninja</a>

  <h2>Dojos Created</h2>
  <c:forEach items="${dojos}" var="dojo">
    <a href="/dojo/${dojo.id}">${dojo.name}</a><br>
  </c:forEach>
  
  
</body>
</html>
