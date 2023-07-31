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

    <title>Book Depository</title>
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
                            <a class="nav-link" href="/aboutUs">About</a>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src="/js/bookLoop.js"></script>
<!-- SLIDER -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/alpinejs/3.10.2/cdn.js'></script>
<script  src="./script.js"></script>
</body>
</html>