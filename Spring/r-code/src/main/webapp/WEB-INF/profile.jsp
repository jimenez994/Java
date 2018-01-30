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
            <a href="index.html" class="navbar-brand">R-Code</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a href="/dashboard" class="nav-link">Home</a>
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
                        <a href="/user/${cUser.id}" class="nav-link">${cUser.username}</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>



<header id="profile-home-section"  >
    <div  class="profile-dark-overlay">
        <div class="home-inner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 d-none d-lg-block">
                        <h1 class="display-4">Build
                            <strong> social profiles </strong>and gain revenue and
                            <strong>profits</strong>
                        </h1>
                        <div class="d-flex flex-row">
                            <div class="p-4 align-self-start">
                                <i class="fa fa-check"></i>
                            </div>
                            <div class="p-4 align-self-end">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Odio nam tempore, nulla. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Quia harum praesentium sint nemo. Repellendus?
                            </div>
                        </div>
                        
                       
                    </div>
                    <div class="col-lg-4">
                        <div class="card bg-primary text-center card-form">
                            <div class="card-body">
                                <h3>sign Up today</h3>
                                <p>Please fill out this form to register</p>
                                <form>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-lg" placeholder="Username">
                                    </div>
                                   
                                    <input type="submit" class="btn btn-outline-light btn-block">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>







    <div  class="container" >
        <div class="row">
           
            <div class="col-lg-9 ">
                
                   <div class="card" id="profile-container">
                            <div class="row text-center">
                                <div >
                                    <div class="card">
                                        <div  class="card-body">
                                            <img id="pImg" src="/images/dragonBall.jpg" alt="" class="img-fluid rounded-circle mb-3">
                                            <h3>first name lastname</h3>
                                            <h5 class="text-muted">CEO and owner of R-Code</h5>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae molestiae alias expedita quae
                                                esse ut.</p>
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
                                </div>
      
                        </div>
                    </div>
                
            </div>
            <div class="col-lg-3 d-none d-lg-block">
                <div class="card text-center" id="profile-rigth-container">
                    <div class="card-header ">
                        <button class="btn btn-info" data-toggle="modal" data-target="#edit-profileModal"> <i class="fa fa-edit"></i> Update Profile</button>
                    </div>
                    <div class="modal" id="edit-profileModal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">  
                                    <h5 class="text-secondary">Profile Info</h5>
                                </div>
                                <div class="modal-body text-left">
                                    <form:form method="post" action="/user/update/profile" enctype="multipart/form-data" modelAttribute="updateUserInfo">
                                        <!-- profile image may go here  -->
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col">
                                                    <label for="" class="text-secondary">First Name:</label>
                                                    <form:input path="firstName" class="form-control"></form:input>
                                                </div>
                                                <div class="col">
                                                    <label for="" class="text-secondary">Last Name:</label>
                                                    <form:input path="lastName" class="form-control"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="text-secondary">Headline:</label>
                                            <form:textarea path="headline" class="form-control" rows="3"></form:textarea>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="text-secondary">Current Position:</label>
                                            <input  class="form-control" ></input>
                                        </div>
                                        <div class="form-group">
                                            <label class="text-secondary">Education:</label>
                                            <input class="form-control"></input>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col">
                                                    <label for="" class="text-secondary">Country:</label>
                                                    <form:input path="country" class="form-control"></form:input>
                                                </div>
                                                <div class="col">
                                                    <label for="" class="text-secondary">ZIP Code:</label>
                                                    <form:input path="zipCode" class="form-control"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col">
                                                    <label for="" class="text-secondary">State:</label>
                                                    <form:input path="state" class="form-control"></form:input>
                                                </div>
                                                <div class="col">
                                                    <label for="" class="text-secondary">City:</label>
                                                    <form:input path="city" class="form-control"></form:input>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="text-secondary">Summary:</label>
                                            <form:textarea path="summary" class="form-control" rows="3"></form:textarea>
                                        </div>

                                        <div class="form-group">
                                            <label for="file" class="text-secondary">Profile Image</label>
                                            <input type="file" name="profileImge" class="form-control">
                                        </div>
                                        <div class="modal-footer">
                                            <button class="btn btn-secondary" modal-dismiss="modal">Close</button>
                                            <input type="submit" class="btn btn-primary" value="Update Profile" />
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
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