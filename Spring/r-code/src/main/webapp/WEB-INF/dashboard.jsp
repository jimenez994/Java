<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>
	<body>
		<a href="/logout">Logout!</a>
		<h1>Welcome, ${cUser.firstName}</h1>
		<form:form methos="post" action="create/quetion" modelAttribute="newQuestion">
			<p>
				<form:label path="question">Question:</form:label>
				<form:input path="question"/>
			</p>
				<form:hidden path="user" value="${cUser.id}"/>
				<input type="submit" value="Post"/>
		</form:form>
		
		<form method="POST" action="/uploadFile" enctype="multipart/form-data">
			File to upload: <input type="file" name="file">
			<input type="submit" value="Upload"> Press here to upload the file!
		</form>	
		
		
		<div>
			<button>Ask question</button>
		</div>
		
		<div>
			<hr>
			<c:forEach items="${users}" var="user">
				<c:set var="recive" value="false"/>
						<c:forEach items="${cUser.getRecieveRequests()}" var="Request">
							<c:if test="${Request.id == user.id}">
								<c:set var="recive" value="true"/>
								<c:set var="requestId" value="${ sendRequest.id }" />
							</c:if>
						</c:forEach>
				<c:if test="${user.id != cUser.id }">
					<c:choose>
						<c:when test="${recive == true}">
							<form method="post" action="/accept/${user.id}">
									<p>${user.firstName}</p>
									<input type="submit" value="accept"/>
									<hr>
								</form>
						</c:when>
						<c:otherwise>
							<c:set var="check" value="false"/>
							<c:forEach items="${cUser.getSendRequests()}" var="sendRequest">
								<c:if test="${sendRequest.id == user.id}">
									<c:set var="check" value="true"/>
									<c:set var="requestId" value="${ sendRequest.id }" />
								</c:if>
							</c:forEach>
							<c:if test="${check.equals('true')}">
								<form method="post" action="/cancel/${user.id}">
									<p>${user.firstName}</p>
									<input type="submit" value="cancel"/>
									<hr>
								</form>
							</c:if>
							<c:if test="${check.equals('false')}">
								<form method="post" action="/request/${user.id}">
									<p>${user.firstName}</p>
									<input type="submit" value="Request"/>
									<hr>
								</form>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:if>
				
			</c:forEach>
		</div>
		
		
		<c:forEach items="${questions}" var="question">
			<h3>${question.question}</h3>
			<p>${question.getUser().getFirstName()}</p>
			<hr>
		</c:forEach>
		
	</body>
</html>