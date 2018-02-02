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
    <div class="container " id="homeid">
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
                            <div class="d-flex row-hl ">
                                <div>
                                    <label for="files" class="btn item-hl ml-3 mb-3 btn-info"> <i class="fa fa-camera"></i> Image </label> 

                                </div>
                                <input type="submit" class="btn ml-auto mr-3 mb-3 item-hl btn-secondary " value="Post" />
                            </div>
                      	</div>
                    </form:form>
                </div>
                <c:forEach items="${posts}" var="post">
                    <div class="card mb-2 text-top" >
                        <div class="d-flex row-hl">
                            <img id="smallUserImgHome" src="/images/${post.getUser().getUserInfo().getProfileImg()}" alt="${cUser.getUserInfo().getProfileImg()}" class="img-fluid item-hl mt-1 rounded-circle mt-2 ml-2">                        
                            <div class="item-hl ml-2 mt-1">
                                <c:if test="${post.getUser().getId() == cUser.id}">
                                    <p id="postSmallText"><a class="text-dark" href="/user/${post.getUser().getId()}"> ${post.getUser().getUserInfo().getFirstName()} </a> </p>
                                    <p id="postSmallname"> <small> <a class="text-secondary" href="/user/${post.getUser().getId()}"> ${post.getUser().getUserInfo().getHeadline()}</a> </small> </p>                                </c:if>
                                <c:if test="${post.getUser().getId() != cUser.id}">
                                    <p id="postSmallText"><a class="text-dark" href="/profile/${post.getUser().getId()}"> ${post.getUser().getUserInfo().getFirstName()} </a> </p>
                                    <p id="postSmallname"> <small> <a class="text-secondary" href="/profile/${post.getUser().getId()}"> ${post.getUser().getUserInfo().getHeadline()}</a> </small> </p>
                                </c:if>

                                
                                <p > <small class="text-secondary">${pTime.format(post.getCreatedAt())}  </small> </p>
                            </div>
                            
                        </div>
                        <p class="card-text mr-3 ml-3 mb-3">${post.getMessage()}</p>
                        <c:if test="${post.getPicture() != null}">
                            <img class="card-img-bottom card-img-top img-fluid" src="/images/${post.getPicture()}" alt="${post.getPicture()}">
                        </c:if>
                        <div class="card-footer text-muted">
                            <small class="mr-2"><a href="#" class="text-secondary" ><i class="fa fa-thumbs-o-up"></i> like </a></small>
                            <small class="mr-2"> <a href="#collapseComment${post.getId()}" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" class="text-secondary"> <i class="fa fa-comment-o"></i> comment </a></small>
                            <small><a href="#" class="text-secondary"> <i class="fa fa-share"></i> share </a></small>  
                        </div>
                      
                        <div id="collapseComment${post.getId()}" class="collapse">
                            
                            <div class=" mr-2 ml-2">
                                
                                <form:form action="/home/addComment/${post.getId()}" method="post" enctype="multipart/form-data" modelAttribute="newComment">

                                    <form:input path="comment" type="text" id="name" class="form-control form-control-sm" placeholder="Add a comment..."></form:input>

                                    <div class="d-flex flex-row justify-content-between row-hl mt-2 ">
                                        <label for="filesC" class="btn text-info"> <i class="fa fa-camera"></i> </label> 
                                        <input id="filesC" style="visibility:hidden;" name="file2" type="file">
                                        <small><input id="smallCommentBtn" class="text-rigth btn btn-info" type="submit" value="Post"></small> 
                                    </div>

                                    <div class="card">
                                        <img class="card-img" id="prev">
                                    </div>
                                </form:form>
                            </div>
                                 
                            
                           
                        </div>
                    </div>
                </c:forEach>
                
            </div>
            <div class="col-sm-3 d-none d-sm-block">
                <p>other stuff goes here</p>
            </div>
        </div>
    </div>















    <script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
    <script src="/src/js/jquery.min.js"></script>
    <script src="/src/js/popper.min.js"></script>
    <script type="text/javascript" src="/src/js/commentPreImg.js"></script>

    <script type="text/javascript" src="/src/js/myMain.js"></script>
    <script src="/src/js/bootstrap.min.js"></script>
</body>
</html>