<%--
  Created by IntelliJ IDEA.
  User: Reg
  Date: 7/24/2023
  Time: 9:44 PM
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
  <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
  <link rel="stylesheet" href="/css/style.css">
  <title>Book Depository</title>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="p-3 m-0 border-0 bd-example">

<!-- Example Code -->

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgb(73, 54, 72); padding: 20px; margin: -16px; box-shadow: -1px 4px 5px black;">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="#">Book Depository</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-white" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled text-white">Disabled</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search Books" style="border-radius: 5px;">
        <button class="btn btn-outline-success" type="submit" style="color: black; border: none; background-color: white; border-radius: 5px;">Search</button>
      </form>
    </div>
  </div>
</nav>
<br><br><br>
<h2><a href="/bookForm">Add Book</a></h2>
<h2><a href="/authorForm">Add Author</a></h2>
<h2><a href="/publisherForm">Add Publisher</a></h2>
<h2><a href="/genreForm">Add Genre</a></h2>
<br><br>
<h2>Add an Author</h2>
<form:form action="/addAuthor" method="post" modelAttribute="author">
  <form:label path="name">Name:</form:label>
  <form:input path="name" type="text"/>
  <form:errors path="name"/> <br> <br>

  <input type="submit" class="create" value="Add">
</form:form>

<br>
<h3>Available Authors (<label>${authors.size()}</label>):</h3>

<c:forEach var="author" items="${authors}">
  <input type="checkbox" value="${author.id}">
  <label>${author.name}</label>
</c:forEach>

<br>

</body>
</html>