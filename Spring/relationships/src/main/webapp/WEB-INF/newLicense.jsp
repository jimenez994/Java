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
${people}

	<form:form action="/license/new" method="post" modelAttribute="license">
		<form:label path="person">Person:
			<form:select path="person">
				<c:forEach items="${people}" var="person">
					<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
				</c:forEach>
			</form:select>
		</form:label>

		<form:label path="state">State:
			<form:input path="state"></form:input>
			<form:errors path="state"></form:errors>
		</form:label>
		
		<form:input type="date" path="expiration_date"></form:input>
		
		<input type="submit" value="Create"></input>
	</form:form>

</body>
</html>