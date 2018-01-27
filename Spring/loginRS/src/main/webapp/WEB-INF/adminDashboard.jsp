<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*,java.time.*,java.time.format.DateTimeFormatter,java.text.SimpleDateFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Admin Dashboard</h2>
	<a href="/logout">Logout!</a>
	
	<h4>Customers</h4>
	<table>
		<tr>
			<th>Name</th>
			<th>Next Due Date</th>
			<th>Amount Due</th>
			<th>Packge Type</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<input type="hidden" name="due" value="${user.getDueDate().getDue()}"/>
			<c:if test="${user.id != id }">
				<tr>
					<td>${user.firstName}</td>
					
					<td>${user.getDueDate().getMonth()}</td> 
					
					<td>$${user.getPack().getCost()}</td>
					<td>${user.getPack().getName()}</td>
				</tr>
			</c:if>
		</c:forEach>
		
	</table>
	
	<h4>Packages</h4>
	<table>
		<tr>
			<th>Package Name</th>
			<th>Package Cost</th>
			<th>Available</th>
			<th>Users</th>
			<th>Actions</th>
		</tr>
		
		<c:forEach items="${packs}" var="pack">
			<tr>
				<td>${pack.name}</td>
				<td>${pack.cost}</td>
				<c:if test="${pack.activation == false}">
					<td>unavailable</td>
				</c:if>
				<c:if test="${pack.activation == true}">
					<td>available</td>
				</c:if>	
				<td>${pack.getUsers().size()}</td>
				<c:choose>
					<c:when test="${pack.getUsers().size() == 0 && pack.isActivation() == false}">
						<td> <a href="/activate/${pack.id}">Activate</a>/ <a href="/delete/${pack.id}">Delete</a> </td>
					</c:when>
					<c:when test="${pack.getUsers().size() == 0 && pack.isActivation() == true}">
						<td> <a href="/deactivate/${pack.id}">Deactivate</a>/ <a href="/delete/${pack.id}">Delete</a> </td>
					</c:when>
					<c:when test="${pack.getUsers().size() > 0 && pack.isActivation() == true}">
						<td> <a href="/deactivate/${pack.id}">Deactivate</a> </td>
					</c:when>
					<c:when test="${pack.getUsers().size() > 0 && pack.isActivation() == false}">
						<td> <a href="/activate/${pack.id}">Activate</a> </td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
		
	</table>
	
	<form:form method="post" action="/create/package" modelAttribute="newPackage">
		<p>
			<form:label path="name">Package Name:
				<form:errors path="name"></form:errors><br>
				<form:input path="name"></form:input>
			</form:label>
		</p>
		<p>
			<form:label path="cost">Cost:
				<form:errors path="cost"></form:errors><br>
				<form:input path="cost"></form:input>
			</form:label>
			<form:hidden path="user" value="${id}"/>
		</p>
		<input type="submit" value="Create"/>
	</form:form>
	
	
</body>
</html>