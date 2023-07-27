<%--
  Created by IntelliJ IDEA.
  User: Reg
  Date: 7/27/2023
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Book Depository</title>
</head>
<body>
<form action="/updateUser" method="post">
  <input type="hidden" name="_method" value="patch">
  <label> user name:</label>
  <input name="userName" value="${currentUser.userName}" type="text"/>

  <label> Email:</label>
  <input name="email" value="${currentUser.email}" type="text"/>

    <label> Password:</label>
    <input name="password" type="text" value="${currentUser.password}"/>
  <input type="hidden" name="confirm" value="${currentUser.password}">


    <input type="submit" value="update">
</form>
</body>
</html>
