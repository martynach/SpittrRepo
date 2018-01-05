<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Martynka
  Date: 2017-12-11
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel=stylesheet" type="text/css" href="<c:url value="/resources/style.css" /> " >


</head>
<body>
<h1 class="myHeader">Welcome to Spittr!</h1>

<c:url value="/resources/style.css" />

<a href="<c:url value="/spittr/spittles" /> ">Spittles</a>
<a href="<c:url value="/spittr/spitter/register"/>">Register </a>


</body>
</html>
