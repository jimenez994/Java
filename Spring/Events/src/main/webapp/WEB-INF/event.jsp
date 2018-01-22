<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">

<title>Insert title here</title>
</head>
<body>
	${currentUser.id}
	<h1>${event.title}</h1>
	<h4>Host: ${event.getUser().getFirstName()} ${event.getUser().getLastName()}</h4>
	<h4>Date: ${event.dDate}</h4>
	<h4>Date: ${event.location}, ${event.state}</h4>
	<h4>People who are attending this event ${event.getJoinUE().size()}</h4>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Location</th>
		</tr>
		<tr>
			<td>john</td>
			<td>Chicago</td>
		</tr>
	</table>
	<div>
		<h2>Message Wall</h2>
		<div class="messages">
			<c:if test="${errors != null}">
		    		 <c:forEach items="${errors}" var="error">
		    		 	<p>${error.defaultMessage}</p>
		    		 
		    		 </c:forEach>
		    </c:if>
			<c:forEach items="${messages}" var="message">
				<p>${message.getUser().firstName}: ${message.message}</p>
				<hr>
			</c:forEach>
		</div>
		<form:form mothod="post" action="/event/${event.id}/post/message" modelAttribute="newMessage">
			<p>
				<form:label path="message">Add Comment:</form:label><br>
				<form:textarea path="message"/>
			</p>
			<form:hidden path="user" value="${uId}"/>
			<form:hidden path="event" value="${event.id}"/>
			<input type="submit" value="Submit"/>
		
		</form:form>
		${uId }
	</div>
	
	
	
	<a href="/home">back</a>
</body>
</html>