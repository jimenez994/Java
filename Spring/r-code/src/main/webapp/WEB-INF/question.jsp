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
    <link rel="stylesheet" href="/src/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/src/css/bootstrap.css">
    <link rel="stylesheet" href="/src/css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Q</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="/js/main.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-sm bg-dark  navbar-dark ">
        <div class="container">
            <a href="/dashboard" class="navbar-brand">R-Code</a>
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
                        <a href="/logout" class="nav-link">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a href="/profile" class="nav-link">${cUser.username}</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


<!-- question info -->
    <div class="container">
        <div class="row">
            <div class="col-lg-9" >
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${question.title}</h4>
                        
                        <p class="card-text">${question.description}</p>
                        <div class="bg-light">
                            <pre class="prettyprint p-3">${question.code}</pre>
                        </div>
                    </div>
                    <c:if test="${question.picture != null}">
                        <img class="card-img-bottom card-img-top img-fluid" src="/images/${question.picture}" alt="${question.picture}">
                    </c:if>
                    <div class="card-body">
                        <blockquote class="blockquote text-right">
                             <p class="card-text "> <a  href="/profile/${question.getUser().getId()}"> ${question.getUser().getUsername()}</a></p>
                        </blockquote>
                       
                    </div>
                     
                    <div class="card-footer text-muted">
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                     </div>
                </div>
                    <div id="accordion" role="tablist">
                        <div class="card">
                            <div class="card-header" role="tab" id="heading">
                                <h5 class="mb-0">
                                    <a href="#collapse1" data-parent="#accordion" data-toggle="collapse">
                                        Answer this question
                                    </a>
                                </h5>
                            </div>
                    <!-- answer form -->
                            <div id="collapse1" class="collapse">
                                <div class="card-body">
                                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis ea iste a doloremque, cumque, debitis eum vel ipsum architecto
                                    aut, recusandae totam ullam aperiam. Nesciunt expedita officiis animi quam corporis optio inventore facilis
                                    sint et nulla in, repellat debitis dolor at nisi quo, unde temporibus. Quos nisi nostrum officia, illo.
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
           
            
            <div class="col-lg-3 d-none d-lg-block">
                Auto Layout
            </div>


        </div>
    </div>















<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
<script src="/src/js/jquery.min.js"></script>
<script src="/src/js/popper.min.js"></script>
<script src="/src/js/bootstrap.min.js"></script>
</body>
</html>