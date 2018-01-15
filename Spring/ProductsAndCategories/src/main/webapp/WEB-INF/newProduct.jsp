<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
  <h1>New Product</h1>
  <form:form method="post" action="/product/new" modelAttribute="product">
    <form:label path="name">Name:<br>
    <form:input path="name"/></form:label><br>

    <form:label path="description">Description:<br>
    <form:input path="description"/></form:label><br>

    <form:label path="price">Price:<br>
    <form:input type="float" path="price"/></form:label><br>
    <input type="submit" value="Create">
  </form:form>

</body>
</html>
