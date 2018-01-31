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
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="/js/main.js"></script>
	</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-sm bg-dark  navbar-dark ">
        <div class="container">
            <a href="index.html" class="navbar-brand">R-Code</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a href="/dashboard" class="nav-link">Questions</a>
                    </li>
                    <li class="nav-item">
                        <a href="/home" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="#create-head-section" class="nav-link">Create</a>
                    </li>
                    <li class="nav-item">
                        <a href="/logout" class="nav-link">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a href="/user/${cUser.id}" class="nav-link">${cUser.username}</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container ">
        <div class="row">
            <div class="col-lg-2 d-none d-lg-block">
                some other stuff may go here
            </div>
            <div class="col-sm-9 col-m-9 col-lg-7  ">
                <div class="card">
                    <div class="card-body" id="headingS1">
                        <h5 class="mb-0">
                            <div href="#collapse1" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" class="">
                                <i class="fa fa-pencil-square-o"></i> Share an image or idea
                            </div>
                        </h5>
                    </div>
                    <form:form method="post" action="/home/post" enctype="multipart/form-data" modelAttribute="newPost">
	                    <div id="collapse1" class="collapse">
	                        <div class="card-body">
	                            <div class="form-group">
                                     <form:textarea path="message" class="form-control" rows="4" placeholder="Write something here"></form:textarea>
                                 </div>
                                 
                            </div>
                           
                        </div>
                        <div class="card">
                            <img class="card-img" id="preview" >
                        </div>
	                    <div class="card  bg-light">
                            <div>
                                <input id="files" style="visibility:hidden;" name="file" type="file">
                            </div>
                            <div class="d-flex  row-hl ">
                                <label for="files" class="btn item-hl ml-3 mb-3 btn-info"> <i class="fa fa-camera"></i> Image </label> 
                                <input type="submit" class="btn ml-auto mr-3 mb-3 item-hl btn-secondary " value="Post" />
                            </div>
                      	</div>
                    </form:form>
                </div>
                <div class="card">
                    some cards
                </div>
            </div>
            <div class="col-sm-3 d-none d-sm-block">
                <p>other stuff goes here</p>
            </div>
        </div>
    </div>















    <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
    <script src="/src/js/jquery.min.js"></script>
    <script src="/src/js/popper.min.js"></script>
    <script type="text/javascript" src="/src/js/myMain.js"></script>
    <script src="/src/js/bootstrap.min.js"></script>
</body>
</html>