<%--
  Created by IntelliJ IDEA.
  User: Reg
  Date: 7/26/2023
  Time: 12:00 PM
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
  <meta charset="UTF-8">
  <title>Login and Registration</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<!-- partial:index.partial.html -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
<div class="left-container">
</div>
<div class="right-container">
  <div class="right-container__box">
    <div class="right-container-box">
      <h2 class="right-container__h2">ًWelcome to Book Depository!</h2>
      <p class="right-container__p">Enter your email and password to sign in</p>
    </div>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <div class="input-container">
      <form:label path="email" class="right-container__label">Email:</form:label>
      <form:input path="email" class="right-container__input" placeholder="Your email address"/>
      <form:errors path="email" style="color:red;"/> <br>

      <form:label path="password" class="right-container__label">Password:</form:label>
      <form:input path="password" type="password" class="right-container__input" placeholder="Your password"/>
      <form:errors path="password" style="color:red;"/>
    </div>
    <div class="toggle-container">
      <input type="checkbox" class="toggle-box" name="checkbox">
      <label for="checkbox">Remember me</label>
    </div>
    <button type="submit" class="btn">SIGN IN</button>
  </form:form>
    <p class="right-container__bottom-text">Don't have an account? <a href="/registerForm"><strong>Sign Up</strong></a></p>
  </div>
</div>
<!-- partial -->

</body>
</html>
