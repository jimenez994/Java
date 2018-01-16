<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h3><strong>${product.name}</strong></h3>
		<p>Description: ${product.description}</p>
		<p>Price: $${product.price}</p>
		<hr>
		<p><strong>Categories:</strong></p>
		<ul>
			<c:forEach items="${product.categories}" var="category">
			<li>${category.name}</li>
			</c:forEach>
		</ul>

  <form action="/product/${id}" method="post">
    <label>Add Category:
      <select name="category">
        <c:forEach items="${categories}" var="category">
          <option value="${category.id}">${category.name}</option>
        </c:forEach>
      </select>
    </label><br>
    <input type="submit" value="Add">
  </form>
</body>
</html>
