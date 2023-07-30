<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/homePage.css">
    <link rel="stylesheet" href="/css/bookInfo.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <title>Book Depository</title>
</head>
<body class="p-0 m-0 border-0 bd-example">

<!-- NAV BAR -->
<nav class="p-4 navbar navbar-expand-lg navbar-light align-content-center" style="background-color: rgb(76 57 77); box-shadow: -1px 4px 5px black; font-family: 'Helvetica', 'Arial', sans-serif; !important;">
    <div class="container-fluid">
        <img src="/assets/logo.png" alt="logo" style="margin: 0; width: 60px;">
        <a class="navbar-brand text-white" href="/homeG" style="line-height: 20px;">Book<br>Depository</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse flex-box" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/profile">${currentUser.userName}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-white" aria-current="page" href="/homeG">Home</a>
                </li>
                <c:if test="${currentUser.id == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="/databaseForms" style="color: rgb(200 75 127);">Database</a></a>
                    </li>
                </c:if>
            </ul>
            <form class="d-flex" role="search" action="/search" method="get" style="margin-right: 6%; width: 50%;">
                <input class="form-control me-2" type="search" name="keyword" placeholder="Search For Titles" aria-label="Search Books" style="border-radius: 3px;">
                <button class="btn btn" type="submit" style="color: white; background-color: #10bdd7; border-radius: 3px;">Search</button>
            </form>
            <ul>
                <div style="display: flex; justify-content: space-evenly; align-items: center; gap: 80px;">
                    <li>
                        <img src="/assets/shipping.png" alt="shipping" style="width: 150px; box-shadow: 3px 3px 3px black; padding: 10px; border: transparent; border-radius: 10px;">
                    </li>
                    <div style="display: flex; justify-content: space-evenly; align-items: center; gap: 40px;">
                        <li class="nav-item">
                            <a class="nav-link" href="/aboutUsG">About</a>
                        </li>
                        <c:if test="${currentUser != null}">
                            <li class="nav-item">
                                <a class="btn btn-group-vertical" style="background-color: #10bdd7; color: white;" href="/logout">Logout</a>
                            </li>
                        </c:if>
                        <c:if test="${currentUser == null}">
                            <li class="nav-item">
                                <a class="btn btn-outline-success" href="/">Login</a>
                            </li>
                        </c:if>
                    </div>

                </div>
            </ul>
        </div>
    </div>
</nav>
<!-- NAV BAR -->
<%-- CONTENT --%>
<br><br><br>
<section>
    <div class="containerInfo">
        <div class="container__content">
            <div class="content__profile"><img src="${book.cover}" alt="${book.name}">
                <div class="profile">
                    <h1>By <a href="/author/${book.author.id}" style="text-decoration: none; color: #fafafa;"><c:out value="${book.author.name}"/></a></h1>
                    <div class="content__border"></div>
                    <p style="color: #bd4b7d; font-size: xxx-large;"><span>$</span><c:out value="${book.price}"/></p>
                    <p><c:forEach var="genre" items="${book.genres}"><c:out value="${genre.name}"/></c:forEach> </p>
                    <p><a href="/" class="btn btn-primary">Follow Author</a></p>
                </div>
            </div>
            <div class="content__bio">
                <h2><c:out value="${book.name}"/></h2>
                <hr>
                <p><c:out value="${book.description}"/></p>
                <ul style="display: flex; gap: 20px;">
                    <li>
                        <p><b>Publisher: </b> <br><a href="/publisher/${book.publisher.id}"><c:out value="${book.publisher.name}"/></a></p>
                    </li>
                    <li>
                        <p><b>Dimensions:</b><br> <c:out value="${book.dimensions}"/></p>
                    </li>
                    <li>
                        <p><b>Language:</b><br> <c:out value="${book.language}"/></p>
                    </li>
                    <li>
                        <p><b>Released:</b><br> <fmt:formatDate value="${book.publicationDate}" type="date" pattern="dd-MMM-yyyy"/></p>
                    </li>
                    <li>
                        <p><b>Pages:</b><br> <c:out value="${book.pages}"/></p>
                    </li>
                </ul>
                <a href="/" class="btn btn-info" style="width: 150px; font-size: larger; color: white;">Buy</a>
            </div>
        </div>
    </div>
</section>
    <section>
        <div class="container mt-5 mb-5">
            <div class="row height d-flex justify-content-center align-items-center">
                <div class="col-md-7">
                    <div class="card">
                        <div class="p-3">
                            <h6 style="text-align: center;">Reviews</h6>
                        </div>
                        <div class="mt-3 d-flex flex-row align-items-center p-3 form-color">
                            <img src="${currentUser.avatar}" width="50" class="rounded-circle mr-2">
                            <form action="/" method="get">
                                <label>Write Your Review</label> <br>
                                <textarea name="review" cols="60" rows="2" style="border-radius: 10px;"></textarea>
                                <input type="hidden" name="user" value="${currentUser.id}"/>
                                <input type="hidden" name="book" value="${book.id}"/> <br>
                                <input type="submit" class="btn btn-dark" value="Submit Review as ${currentUser.userName}" style="text-align: end;">
                            </form>
                        </div>
                        <c:forEach var="review" items="${reviews}">
                            <c:if test="${review.book.id == book.id}">
                            <div class="mt-2">
                                <div class="d-flex flex-row p-3"> <img src="${review.user.avatar}" width="40" height="40" class="rounded-circle mr-3">&nbsp;&nbsp;&nbsp;
                                    <div class="w-100">
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="d-flex flex-row align-items-center"> <span class="mr-2">${review.user.userName}</span></div> <small style="font-size: small;"><fmt:formatDate value="${review.createdAt}" type="date" pattern="dd-MMM-yyyy"/></small>
                                        </div>
                                        <p class="text-justify comment-text mb-0"><c:out value="${review.review}"/></p>
                                        <div class="d-flex flex-row user-feed"><c:if test="${currentUser.id == review.user.id}"><span class="ml-3"><i class="fa fa-comments-o mr-2"></i>
                                    <a href="/review/delete/${review.id}" style="color: tomato;">delete</a>
                                    </span></c:if></div>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%-- CONTENT --%>
<%--FOOTER--%>
<footer class="main-footer">
    <div class="container">
        <div class="footer-content">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12 footer-column">
                    <div class="logo-widget footer-widget">
                        <div style="display: flex; justify-content: start; align-items: center;">
                            <img src="/assets/logo.png" alt="logo" style="margin-left: -20px; width: 20%;">
                            <figure class="logo-box"><a class="navbar-brand text-white" href="/homeG" style="line-height: 20px;">Book<br>Depository</a></figure>
                        </div>
                        <div class="text">
                            <p>At Book Depository, we pride ourselves on offering an extensive range of books that cater to diverse interests and preferences. From bestselling novels and literary classics to non-fiction titles covering topics like science, history, self-help, and more – there's a book waiting just for you.</p>
                        </div>
                        <ul class="footer-social">
                            <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                            <li><a href="https://github.com/MuathAlrefai/BookDepository"><i class="fab fa-whatsapp"></i></a></li>
                            <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 offset-lg-4 footer-column">
                    <div class="service-widget footer-widget">
                        <div class="footer-title">Contacts</div>
                        <ul class="list">
                            <li><a href="#">If you have any questions or inquiries, feel free to reach out to us.</a></li>
                            <li><a href="#">Book Depository</a></li>
                            <li><a href="#">+970(599) 99-9999</a></li>
                            <li><a href="#">java@bookdepository.com</a></li>
                            <li><a href="#">Ramallah - Al-Bireh</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<%--FOOTER--%>


<!-- SECOND FOOTER -->
<div class="footer-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 column">
                <div class="copyright"><a href="#">Book Depository</a> &copy; 2023 All Right Reserved</div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-12 column">
                <ul class="footer-nav">
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- SECOND FOOTER -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src="/js/bookLoop.js"></script>
<!-- SLIDER -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/alpinejs/3.10.2/cdn.js'></script>
<script  src="./script.js"></script>
</body>
</html>