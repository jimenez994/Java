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
<a href="/">Dashbard</a>
<h2>${language.name}</h2>
<h4>${language.creator}</h4>
<p>${language.currentVersion}</p>
<a href="/language/edit/${id}">edit</a>
<a href="/language/delete/${id}">Delete</a>
</body>
</html>
