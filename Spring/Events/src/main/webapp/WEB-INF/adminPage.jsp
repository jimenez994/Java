<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
    <h1>Welcome to the Admin Page <c:out value="${currentUser.email}"></c:out></h1>
    
    <div>
	    	<table>
	    		<tr>
	    			<th>Name</th>
	    			<th>Email</th>
	    			<th>Action</th>
	    		</tr>
	    		<c:forEach items="${users}" var="user">
	    			<tr>
	    				<td>${user.firstName} ${user.lastName}</td>
	    				<td>${user.email}</td>
	    				 <c:if test="${user.getRoles().get(0).getName().equals('ROLE_ADMIN')}">
	    					<td>Admin</td>
	    				</c:if>
	    				<c:if test="${user.getRoles().get(0).getName().equals('ROLE_USER')}">
	    					<td> <a href="/delete/${user.id}">Delete</a> <a href="/upgrade/${user.id}">make-admin</a> </td>
	    				</c:if>
	    			</tr>
	    		</c:forEach>
	    	</table>
    </div>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>