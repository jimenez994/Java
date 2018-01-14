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
  <h1>New Ninja</h1>
  <form:form action="/ninja/new" method="post" modelAttribute="ninja">
    <form:label path="dojo">Dojo:<br>
    <form:select path="dojo">
      <c:forEach items="${dojo}" var="dojo">
        <form:option value="${dojo.id}">${dojo.name}</form:option>
      </c:forEach>
    </form:select>
  </form:label><br>
    <form:label path="firstName">First Name:<br>
      <form:input path="firstName"></form:input><bt>
    </form:label><br>
    <form:label path="lastName">Last Name:<br>
      <form:input path="lastName"></form:input><bt>
    </form:label><br>

  <form:label path="age">Age:<br>
    <form:input tpye="number" path="age"></form:input><bt>
  </form:label><br>
  <input type="submit" value="Create"></input>
  </form:form>

</body>
</html>
