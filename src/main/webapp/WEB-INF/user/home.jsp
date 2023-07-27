<%--
  Created by IntelliJ IDEA.
  User: Reg
  Date: 7/21/2023
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
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
  <title>Book Depository</title>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="p-0 m-0 border-0 bd-example">

<!-- Example Code -->

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgb(73, 54, 72); padding: 30px; box-shadow: -1px 4px 5px black;">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="/adminHome">Book Depository</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse flex-box" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-white" aria-current="page" href="/adminHome">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/profile">${currentUser.userName}</a>
        </li>
      </ul>
      <form class="d-flex" role="search" style="margin-right: 30%; width: 50%;">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search Books" style="border-radius: 5px;">
        <button class="btn btn-outline-success" type="submit" style="color: black; border: none; background-color: white; border-radius: 5px;">Search</button>
      </form>
      <ul>
        <c:if test="${currentUser != null}">
          <li class="nav-item">
            <a class="btn btn-outline-danger" href="/logout">Logout</a>
          </li>
        </c:if>
        <c:if test="${currentUser == null}">

          <li class="nav-item">
            <a class="btn btn-outline-success" href="/">Login</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
<%--SLIDER--%>
<!-- partial:index.partial.html -->
<h1 class="title">Alpine slider</h1>
<div class="slider" x-data="{start: true, end: false}">
  <div class="slider__content" x-ref="slider" x-on:scroll.debounce="$refs.slider.scrollLeft == 0 ? start = true : start = false; Math.abs(($refs.slider.scrollWidth - $refs.slider.offsetWidth) - $refs.slider.scrollLeft) < 5 ? end = true : end = false;">
    <c:forEach var="book" items="${books}">
      <div class="slider__item">
        <img class="slider__image" src="${book.cover}" alt="Image">
        <div class="slider__info">
          <h2>${book.name}</h2>
        </div>
      </div>
    </c:forEach>
  </div>
  <div class="slider__nav">
    <button class="slider__nav__button" x-on:click="$refs.slider.scrollBy({left: $refs.slider.offsetWidth * -1, behavior: 'smooth'});" x-bind:class="start ? '' : 'slider__nav__button--active'">Previous</button>
    <button class="slider__nav__button" x-on:click="$refs.slider.scrollBy({left: $refs.slider.offsetWidth, behavior: 'smooth'});" x-bind:class="end ? '' : 'slider__nav__button--active'">Next</button>
  </div>
</div>



<h2><a href="/databaseForms">Add to Database</a></h2>
<article class="video-sec-wrap">
  <div class="video-sec">
    <ul class="video-sec-middle" id="vid-grid">
      <c:forEach var="book" items="${books}">
        <li class="thumb-wrap"><a href="">
          <img class="thumb" src="${book.cover}" alt="${book.name}" style="width: 150px; height: auto;">
          <div class="thumb-info">
            <a class="thumb-title" href="/books/${book.id}"><p class="thumb-title">${book.name}</p></a>
            <p class="thumb-user">By ${book.author.name}</p>
            <p class="thumb-text"><span>$</span>${book.price}</p>
          </div>
        </a></li>
      </c:forEach>
    </ul>
  </div>
</article>
<!-- partial -->
<a href="/logout">logout</a>

<p style="color: white;">im the admin</p>

<a href="/profile/${currentUser.id}">go to your profile</a>

<%--FOOTER--%>


<!-- partial:index.partial.html -->
<footer class="main-footer">
  <div class="container">
    <div class="footer-content">
      <div class="row">
        <div class="col-lg-4 col-md-6 col-sm-12 footer-column">
          <div class="logo-widget footer-widget">
            <figure class="logo-box"><a href="#"><img src="https://i.ibb.co/QDy827D/ak-logo.png" alt=""></a></figure>
            <div class="text">
              <p>Lorem ipsum dolor amet consectetur adi pisicing elit sed eiusm tempor incididunt ut labore dolore magna aliqua enim ad minim veniam quis.nostrud exercita.laboris nisi ut aliquip ea commodo conse quatuis aute irure.</p>
            </div>
            <ul class="footer-social">
              <li><a href="#"><i></i></a></li>
              <li><a href="#"><i class="fab fa-twitter"></i></a></li>
              <li><a href="#"><i class="fab fa-vimeo-v"></i></a></li>
              <li><a href="#"><i class="fab fa-google-plus-g"></i></a></li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 offset-lg-2 footer-column">
          <div class="service-widget footer-widget">
            <div class="footer-title">Services</div>
            <ul class="list">
              <li><a href="#">Water Surve</a></li>
              <li><a href="#">Education for all</a></li>
              <li><a href="#">Food Serving</a></li>
              <li><a href="#">Animal Saves</a></li>
              <li><a href="#">Help Orphan</a></li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-12 footer-widget">
          <div class="contact-widget footer-widget">
            <div class="footer-title">Contacts</div>
            <div class="text">
              <p>Lorem Ipsum, simply dummy text, printing, Chandigarh</p>
              <p>+2(784) 1223323</p>
              <p>info@example.com</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- main-footer end -->
<div class="footer-bottom">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 col-md-6 col-sm-12 column">
        <div class="copyright"><a href="#">Anup</a> &copy; 2019 All Right Reserved</div>
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
<!-- partial -->

<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src="/js/bookLoop.js"></script>
<!-- SLIDER -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/alpinejs/3.10.2/cdn.js'></script><script  src="./script.js"></script>
</body>
</html>