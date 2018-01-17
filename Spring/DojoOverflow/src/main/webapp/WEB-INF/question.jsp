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
	<h1>${quest.question}</h1>
	<h3>Tags: 
	<c:forEach items="${tags}" var="tag">
		<button>${tag}</button>
	</c:forEach>
	</h3>
	<div>
		<table>
			<tr>
				<th>Answers</th>
			</tr>
			<c:forEach items="${answers}" var="answer">
				<tr>
					<td>${answer.answer} </td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<div>
		<form:form method="post" action="/questions/${id}" modelAttribute="newAnswer">
			<form:label path="answer">Answer:<br>
			<p>${error}</p>
			<form:textarea path="answer"/>
			</form:label><br>
			<input type="submit" value="Answer it"/>
		</form:form>
	</div><br>
	
	<a href="/questions">Back</a>
	

</body>
</html>