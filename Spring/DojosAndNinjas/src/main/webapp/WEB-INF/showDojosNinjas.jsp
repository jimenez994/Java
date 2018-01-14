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
  <h2>Welcome to ${dojo.name}</h2>
  <table>
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
    </tr>
    <tr>

    <c:forEach items="${ninjas}" var="ninja">
      <td>${ninja.firstName}</td>
      <td>${ninja.lastName}</td>
      <td>${ninja.age}</td>

    </c:forEach>
  </tr>
  </table>
<a href="/">Dashboard</a>

</body>
</html>
