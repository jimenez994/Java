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
  <h2>${category.name}</h2>
  <h3>Products:</h3>
  		<p><strong>Products:</strong></p>
		<ul>
			<c:forEach items="${category.products}" var="product">
			<li>${product.name}</li>
			</c:forEach>
		</ul>
		

  <form action="/category/${id}" method="post">
    <label>Add products:
      <select name="product">
        <c:forEach items="${products}" var="product">
          <option value="${product.id}">${product.name}</option>
        </c:forEach>
      </select>
    </label><br>
    <input type="submit" value="Add">
  </form>
</body>
</html>