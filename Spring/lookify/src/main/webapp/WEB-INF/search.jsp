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
  <a href="/dashboard">Dashboard</a>
  <h4>Songs by artist: ${artists.get(0).getArtist()}</h4>
  <div class="table">
    <table>
      <tr>
        <th>Title</th>
        <th>Rating</th>
        <th>actions</th>
      </tr>
      <c:forEach items="${artists}" var="artist">
        <tr>
        <td> <a href="/song/${artist.id}">${artist.title}</a></td>
        <td> ${artist.rating}</td>
        <td> <a href="/song/delete/${artist.id}">delete</a> </td>
      </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>
