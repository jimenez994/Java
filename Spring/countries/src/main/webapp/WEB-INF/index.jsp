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
	<h2>task 1</h2>
	<table>
		<tr>
			<th>Country</th>
			<th>language</th>
			<th>language percentage</th>
		</tr>
	
		<c:forEach items="${task1}" var="tsk">
			<tr>
			<td>${tsk[0]}</td>
			<td>${tsk[1]}</td>
			<td>${tsk[2]}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>task 2</h2>
	<table>
		<tr>
			<th>Country</th>
			<th>number of cities</th>
		</tr>
	
		<c:forEach items="${task2}" var="tsk">
			<tr>
			<td>${tsk[0]}</td>
			<td>${tsk[1]}</td>
			
			</tr>
		</c:forEach>
	</table>
	
	<h2>task 3</h2>
	<h3>Mexico</h3>
	<table>
		<tr>
			<th>City</th>
			<th>Population</th>
		</tr>
	
		<c:forEach items="${task3}" var="tsk">
			<tr>
			<td>${tsk[0]}</td>
			<td>${tsk[1]}</td>
			
			</tr>
		</c:forEach>
	</table>
	
	<h2>task 4</h2>

	<table>
		<tr>
			<th>Country</th>
			<th>Percentage</th>
		</tr>
	
		<c:forEach items="${task4}" var="tsk">
			<tr>
			<td>${tsk[0]}</td>
			<td>${tsk[1]}</td>
			
			</tr>
		</c:forEach>
	</table>
	
	<h2>task 5</h2>

	<table>
		<tr>
			<th>Country</th>
			<th>Surface Area</th>
			<th>Population</th>
		</tr>
	
		<c:forEach items="${task5}" var="tsk">
			<tr>
			<td>${tsk[0]}</td>
			<td>${tsk[1]}</td>
			<td>${tsk[2]}</td>
			
			</tr>
		</c:forEach>
	</table>
	<h2>task 6</h2>

	<table>
		<tr>
			<th>Country</th>
			<th>goverment form</th>
			<th>Capital</th>
			<th>Life Expectancy</th>
		</tr>
	
		<c:forEach items="${task6}" var="tsk">
			<tr>
			<td>${tsk[0]}</td>
			<td>${tsk[1]}</td>
			<td>${tsk[2]}</td>
			<td>${tsk[3]}</td>
			
			</tr>
		</c:forEach>
	</table>
		<h2>task 8</h2>

	<table>
		<tr>
			<th>Region</th>
			<th>Count</th>
			
		</tr>
	
		<c:forEach items="${task8}" var="tsk">
			<tr>
			<td>${tsk[0]}</td>
			<td>${tsk[1]}</td>
	
			
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>