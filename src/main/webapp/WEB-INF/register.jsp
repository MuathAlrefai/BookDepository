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
    <%--<div class="right-container-box">
      <h2 class="right-container__h2">Nice to see you!</h2>
      <p class="right-container__p">Enter your email and password to sign in</p>
    </div>--%>
    <form:form action="/register" method="post" modelAttribute="newUser">
      <div class="input-container">
        <form:label path="userName" class="right-container__label">Name:</form:label>
        <form:input path="userName" class="right-container__input" placeholder="Your Name"/>
        <form:errors path="userName" style="color:red;"/>

        <form:label path="email" class="right-container__label">Email:</form:label>
        <form:input path="email" class="right-container__input" placeholder="Your email address"/>
        <form:errors path="email" style="color:red;"/>

        <form:label path="password" class="right-container__label">Password:</form:label>
        <form:input path="password" type="password" class="right-container__input" placeholder="Your password"/>
        <form:errors path="password" style="color:red;"/>

        <form:input path="avatar" type="hidden"/>

        <form:label path="confirm" class="right-container__label">Confirm PW:</form:label>
        <form:input type="password" path="confirm" class="right-container__input" placeholder="Confirm Password"/>
        <form:errors path="confirm" style="color:red;"/>
      </div>
      <div class="toggle-container">
        <input type="checkbox" class="toggle-box" name="checkbox">
        <label for="checkbox">Remember me</label>
      </div>
      <button type="submit" class="btn">REGISTER</button>
    </form:form>
    <p class="right-container__bottom-text">Already have an account? <a href="/"><strong>Sign in</strong></a></p>
  </div>
</div>
<!-- partial -->

</body>
</html>
