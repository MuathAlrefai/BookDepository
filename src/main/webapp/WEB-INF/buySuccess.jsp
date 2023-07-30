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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Lato:300,400|Montserrat:700' rel='stylesheet' type='text/css'><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css'><link rel="stylesheet" href="./style.css">
    <link rel="stylesheet" href="/css/thankYou.css">
    <title>Thank You for Your Purchase</title>
</head>
<body class="p-0 m-0 border-0 bd-example">

<!-- NAV BAR -->
<nav class="p-4 navbar navbar-expand-lg navbar-light align-content-center" style="background-color: rgb(76 57 77); box-shadow: -1px 4px 5px black;">
    <div class="container-fluid">
        <img src="/assets/logo.png" alt="logo" style="margin: 0; width: 60px;">
        <a class="navbar-brand text-white" href="/home" style="line-height: 20px;">Book<br>Depository</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse flex-box" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/profile">${currentUser.userName}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-white" aria-current="page" href="/home">Home</a>
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

<!-- partial:index.partial.html -->
<div id="wrapper" class="animated zoomIn">
    <!-- We make a wrap around all of the content so that we can simply animate all of the content at the same time. I wanted a zoomIn effect and instead of placing the same class on all tags, I wrapped them into one div! -->
    <h1>
        <!-- The <h1> tag is the reason why the text is big! -->
        <underline>Thank You for Your Purchase!</underline>
        <br><br><br>
        <hr>
        <!-- The underline makes a border on the top and on the bottom of the text -->
    </h1>
    <h3>
        You will be redirected to Book Depository in 4 seconds...
    </h3><br><br><br>
</div>
<!-- partial -->
<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="/js/thankYou.js"></script>
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
                            <figure class="logo-box"><a class="navbar-brand text-white" href="/home" style="line-height: 20px;">Book<br>Depository</a></figure>
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
<script type="text/javascript">
    // Redirect the user after a delay of 3 seconds
    setTimeout(function() {
        window.location.href = "http://localhost:8080/home";
    }, 4000);
</script>
</body>
</html>