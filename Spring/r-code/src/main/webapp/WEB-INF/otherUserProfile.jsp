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
	</head>
<body>
    <nav class="navbar navbar-expand-sm bg-dark  navbar-dark fixed-top">
        <div class="container">
            <a href="/dashboard" class="navbar-brand">R-Code</a>
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
<!-- headline and backgroud Image -->
<header id="profile-home-section">
    <div class="profile-dark-overlay">
        <div class="home-inner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8  d-lg-block">
                        <h1 class="display-4 mt-5">
                            ${user.getUserInfo().getHeadline()}
                        </h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>



<div  class="container " id="middle-container-p">
        <div class="row">
           
            <div class="col-lg-9 mb-5">
                
                <div class="card" id="profile-container">
                    <div class="row text-center">
                        <div  class="card-body">
                            <img id="pImg" src="/images/${user.getUserInfo().getProfileImg()}" alt="${user.getUserInfo().getProfileImg()}" class="img-fluid rounded-circle mb-3">
                            <h3>${user.getUserInfo().getFirstName()} ${user.getUserInfo().getLastName()}</h3>
                            <h5 class="text-muted">${user.getUserInfo().getHeadline()}</h5>
                            <p>${user.getUserInfo().getCity()},${user.getUserInfo().getState()}</p>
                            <div class="d-flex flex-row justify-content-center">
                                <div class="p-4">
                                    <a href="#">
                                        <i class="fa fa-facebook"></i>
                                    </a>
                                </div>
                                <div class="p-4">
                                    <a href="#">
                                        <i class="fa fa-twitter"></i>
                                    </a>
                                </div>
                                <div class="p-4">
                                    <a href="#">
                                        <i class="fa fa-instagram"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card ">
                        <div class="card-header" id="headingS1">
                            <h5 class="mb-0">
                                <div href="#collapse1" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" class="">
                                    <i class="fa fa-plus-circle"></i> Summary
                                </div>
                            </h5>
                        </div>
                        <div id="collapse1" class="collapse " >
                            <div class="card-body">
                                    ${user.getUserInfo().getSummary()}
                            </div>
                        </div>
                    </div>
                    

                </div><br>

                <!-- tabs -->
                <div class="card" role="tab-list">
                    <ul class="nav nav-tabs text-dark" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active text-dark" data-toggle="tab" href="#home">Question</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" data-toggle="tab" href="#menu1">Posts</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" data-toggle="tab" href="#menu2">Jobs</a>
                        </li>
                    </ul>
                    
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div id="home" class="container tab-pane active">
                            <br>
                            <c:forEach items="${questions}" var="question">
                                <div class="card border-sencondary md-3">
                                    <div class="card-header">tags</div>
                                    <div class="card-body">
                                        <h5 class="card-title ">
                                            <c:if test="${question.getPicture() != null}">
                                                <i class="fa fa-photo"></i>
                                            </c:if>
                                            <c:if test="${question.getCode().length() != 0}">
                                                <i class="fa fa-code"></i>
                                            </c:if>
                                            <a class="text-dark" href="/question/${question.id}">${question.title}</a>
                                        </h5>
                            
                                        <small class="text-muted">Posted ${pTime.format(question.getCreatedAt())}</small>
                                    </div>
                                </div>
                                <br>
                            </c:forEach>
                            
                        </div>
                        <div id="menu1" class="container tab-pane fade">
                            <br>
                            <h3>Menu 1</h3>
                            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                        </div>
                        <div id="menu2" class="container tab-pane fade">
                            <br>
                            <h3>Menu 2</h3>
                            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                        </div>
                    </div>
                </div>

            </div>
             
            <div class="col-lg-3 d-none d-lg-block">
                <div class="card text-center" id="profile-rigth-container">
                    <div class="card-header ">
                        <h4>some cool stuff may go here</h4>
                    </div>
                   


                    



                </div>

               
            </div>
        </div>
    </div>













<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
<script src="/src/js/jquery.min.js"></script>
<script src="/src/js/popper.min.js"></script>
<script src="/src/js/bootstrap.min.js"></script>
</body>
</html>