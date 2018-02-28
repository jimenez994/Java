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
                        <a href="/profile" class="nav-link">${cUser.username}</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


<!-- question info -->
    <div class="container mb-5">
        <div class="row">
            <div class="col-lg-9" >
                <div class="card border-primary">
                    <div class="card-body">  
                        <h4 class="card-title ">${question.title}</h4>                    
                        <p class="card-text">${question.description}</p>
                        <c:if test="${question.code.length() != 0}">
                            <div class="bg-light">
                                <pre class="prettyprint p-3">
                                    <!-- <xmp> -->
                                        ${question.code}
                                    <!-- </xmp>  -->
                                </pre>
                            </div>
                        </c:if>
                        
                    </div>
                    <c:if test="${question.picture != null}">
                        <img class="card-img-bottom card-img-top img-fluid" src="/images/${question.picture}" alt="${question.picture}">
                    </c:if>
                    
                    <blockquote class="blockquote mr-3 text-right">
                        <c:if test="${question.getUser().getId() == cUser.id}">
                            <p class="card-text "> <a  href="/user/${question.getUser().getId()}"> <small>${question.getUser().getUsername()}</small> </a></p>
                        </c:if>
                        <c:if test="${question.getUser().getId() != cUser.id}">
                            <p class="card-text "> <a  href="/profile/${question.getUser().getId()}"> <small>${question.getUser().getUsername()}</small> </a></p>
                        </c:if>
                    </blockquote>
                  
                     
                    <div class="card-footer text-right text-muted">
                        <p class="card-text"><small class="text-muted">Post ${pTime.format(question.getCreatedAt())} </small></p>
                     </div>
                </div><br>

                <!-- answers cards -->
                <c:forEach items="${answers}" var="answer">
                    <div class="card">
                        <div class="card-body">
                            <p class="card-text">${answer.answer}</p>
                            <c:if test="${answer.getCode().length() != 0}">
                                <div class="bg-light">
                                    <pre class="prettyprint p-3">
                                        ${answer.code.trim()}
                                    </pre>
                                </div>
                            </c:if>
                            <c:if test="${answer.picture != null}">
                                <img class="card-img-bottom card-img-top img-fluid" src="/images/${answer.picture}" alt="${answer.picture}">
                            </c:if>
                        </div>
                        <blockquote class="blockquote text-right">
                            <c:if test="${answer.getUser().getId() == cUser.id}">
                                <p class="card-text mr-4" > <a  href="/user/${answer.getUser().getId()}"> <small>${answer.getUser().getUsername()}</small> </a></p>
                            </c:if>
                            <c:if test="${answer.getUser().getId() != cUser.id}">
                                <p class="card-text mr-4" > <a  href="/profile/${answer.getUser().getId()}"> <small>${answer.getUser().getUsername()}</small> </a></p>
                            </c:if>
                             
                        </blockquote>
                        <div class="card-footer text-right text-muted">
                             <p class="card-text"> <small> Answered ${pTime.format(answer.getCreatedAt())}</small> </p>   
                        </div>
                    </div><br>
                </c:forEach>
            <!-- accordion answer form -->
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
                                <form:form method="post" action="/question/${question.id}" enctype="multipart/form-data" modelAttribute="newAnswer">
                                    <div class="form-group">
                                        <label class="text-secondary">Answer:</label>
                                        <form:textarea path="answer" name="description" class="form-control" rows="3" placeholder="Description goes here"></form:textarea>
                                    </div>
                                    <div class="form-group">
                                        <label class="text-secondary">Code:</label>
                                        <form:textarea path="code" name="description" class="form-control" rows="3" placeholder="Code goes here"></form:textarea>
                                    </div>
                                
                                    <div class="form-group">
                                        <label for="file" class="text-secondary">Only image:(Optional)</label>
                                        <input type="file" name="file" class="form-control">
                                    </div>
                                    <div class="modal-footer">
                                        <input type="submit" class="btn btn-primary" value="Post Your Answer" />
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
            
            <div class="col-lg-3 d-none d-lg-block ">
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