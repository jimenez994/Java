<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="x-ua-compatible" content="ie=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="/src/css/font-awesome.min.css">
        <link rel="stylesheet" href="/src/css/bootstrap.css">
        <link rel="stylesheet" href="/src/css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="/js/main.js"></script>
	</head>
	<body>
    <nav class="navbar navbar-expand-sm bg-dark  navbar-dark ">
    <div class="container">
      <a href="index.html" class="navbar-brand">R-code</a>
      <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a href="#home-section" class="nav-link">Home</a>
          </li>
          <li class="nav-item">
            <a href="#explore-head-section" class="nav-link">Explore</a>
          </li>
          <li class="nav-item">
            <a href="#create-head-section" class="nav-link">Create</a>
          </li>
          <li class="nav-item">
            <a href="#share-head-section" class="nav-link">Share</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>



		<a href="/logout">Logout!</a>
		<h1>Welcome, ${cUser.firstName}</h1>
		<form method="post" action="create/quetion" enctype="multipart/form-data">
			<p>
				<label>Question:</label>
				<input name="question"/>
				File to upload: <input type="file" name="file">
				<input type="submit" value="Post"/>
			</p>
		</form>



		<div>
			<button>Ask question</button>
		</div>

		<div>
			<hr>
			<c:forEach items="${users}" var="user">
				<c:set var="recive" value="false"/>
						<c:forEach items="${cUser.getRecieveRequests()}" var="Request">
							<c:if test="${Request.id == user.id}">
								<c:set var="recive" value="true"/>
								<c:set var="requestId" value="${ sendRequest.id }" />
							</c:if>
						</c:forEach>
				<c:if test="${user.id != cUser.id }">
					<c:choose>
						<c:when test="${recive == true}">
							<form method="post" action="/accept/${user.id}">
									<p>${user.firstName}</p>
									<input type="submit" value="accept"/>
									<hr>
								</form>
						</c:when>
						<c:otherwise>
							<c:set var="check" value="false"/>
							<c:forEach items="${cUser.getSendRequests()}" var="sendRequest">
								<c:if test="${sendRequest.id == user.id}">
									<c:set var="check" value="true"/>
									<c:set var="requestId" value="${ sendRequest.id }" />
								</c:if>
							</c:forEach>
							<c:if test="${check.equals('true')}">
								<form method="post" action="/cancel/${user.id}">
									<p>${user.firstName}</p>
									<input type="submit" value="cancel"/>
									<hr>
								</form>
							</c:if>
							<c:if test="${check.equals('false')}">
								<form method="post" action="/request/${user.id}">
									<p>${user.firstName}</p>
									<input type="submit" value="Request"/>
									<hr>
								</form>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:if>

			</c:forEach>
		</div>


		<c:forEach items="${questions}" var="question">
			<h3>${question.question}</h3>
			<pre class="prettyprint">${question.question}</pre>
			<c:if test="${question.picture != null }">
				<img src="/images/${question.picture}" alt="${question.picture}">
			</c:if>
			<p>${question.getUser().getFirstName()}</p>
			<hr>
		</c:forEach>


		<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
		<script src="/src/js/jquery.min.js"></script>
        <script src="/src/js/popper.min.js"></script>
        <script src="/src/js/bootstrap.min.js"></script>
	</body>
</html>
