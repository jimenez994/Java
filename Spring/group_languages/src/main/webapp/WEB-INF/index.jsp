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
  <form:form moethd="POST" action="/language/new" modelAttribute="language">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label><br>

    <form:label path="creator">Creator
    <form:errors path="creator"/>
    <form:input path="creator"/></form:label><br>

    <form:label path="currentVersion">Current Version
    <form:errors path="currentVersion"/>
    <form:input path="currentVersion"/></form:label><br>
    <input type="submit" value="Submit"/>
  </form:form>
  <div class="table">
    <table>
      <c:forEach items="${languages}" var="language" varStatus="loop">
        <tr>
          <td> <a href="/language/${language.id}"> <c:out value="${language.name}"/></a></td>
          <td><c:out value="${language.creator}"/></td>
          <td><c:out value="${language.currentVersion}"/></td>
          <td> <a href="/language/delete/${language.id}">delete</a> </td>
          <td> <a href="/language/edit/${language.id}">edit</a> </td>
        </tr>
      </c:forEach>
    </table>

  </div>

</body>
</html>
