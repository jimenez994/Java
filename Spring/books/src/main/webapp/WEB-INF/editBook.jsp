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
<%-- <form class="" action="/books/update/${id}" method="POST" modelAttribute="book">
  <label for="">Title: </label>
  <input type="text" name="" value="${book.title}"><br>
  <label for="">Description: </label><br>
  <textarea name="decs" rows="8" cols="80">${book.description}</textarea><br>
  <label for="">Language: </label>
  <input type="text" name="" value="${book.language}"><br>
  <label for="">Number of pages: </label>
  <input type="number" path="numberOfPages" value="${book.numberOfPages}"><br>
  <input type="submit" name="" value="Update">
</form> --%>
<form:form method="POST" action="/books/update/${id}" modelAttribute="book">
    <form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label><br>
    
    <form:label path="description">Description<br>
    <form:errors path="description"/>
    <form:textarea path="description"/>
    </form:label><br>
    
    <form:label path="language">language
    <form:errors path="language"/>
    <form:input path="language"/></form:label><br>
    
    <form:label path="numberOfPages">Pages
    <form:errors path="numberOfPages"/>     
    <form:input type="number" path="numberOfPages"/></form:label><br>
    
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
