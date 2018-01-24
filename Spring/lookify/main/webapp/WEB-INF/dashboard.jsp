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
  <a href="/song/new">Add New</a>
  <a href="/songs/top10">Top Songs</a>

  <form method="post" action="/search">
    <input type="text" name="artist"/>
    <input type="submit" value="Search Artist"/>
  </form>

  <div class="table">
    <table>
      <tr>
        <th>Title</th>
        <th>Rating</th>
        <th>actions</th>
      </tr>
      <c:forEach items="${songs}" var="song">
        <tr>
        <td> <a href="/song/${song.id}">${song.title}</a></td>
        <td> ${song.rating}</td>
        <td> <a href="/song/delete/${song.id}">delete</a> </td>
      </tr>
      </c:forEach>
    </table>
  </div>

</body>
</html>
