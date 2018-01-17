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
 <h2>Questions Dashboard</h2>
	<table>
		<tr>
			<th>Questions</th>
			<th>Tags</th>
		</tr>
		
		<c:forEach items="${questions}" var="quest">
		<tr>
			<td><a href="/questions/${quest.getId()}">${quest.question} </a> </td>
			<td>${quest.getTags().get(0).getSubject()}</td>
		</tr>
		</c:forEach>	
	</table><br><br>
 
 	<a href="/questions/new">New Question</a>
 
 
 
 
</body>
</html>