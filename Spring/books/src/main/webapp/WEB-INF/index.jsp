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
	${ books1 }

<table class="table">
<c:forEach items="${books}" var="book" varStatus="loop">

    <tr>  
     
    <td><c:out value="${book.title}"/></td>
    <td><c:out value="${book.description}"/></td>
    <td><c:out value="${book.language}"/></td>
    <td><c:out value="${book.numberOfPages}"/></td>
    <td><a href="/books/delete/${book.id}">Delete</a></td>
    <td><a href="/books/edit/${book.id}">edit</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>