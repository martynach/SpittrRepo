<%--
  Created by IntelliJ IDEA.
  User: Martynka
  Date: 2017-12-27
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/registerForm_style.css" />" />
</head>
<body>

<h2>Register</h2>

<sf:form method="post" commandName="spitter" class="registerForm">
    <sf:label path="firstname" cssErrorClass="labelError">First name: </sf:label>
    <sf:input cssErrorClass="inputError" path="firstname"/>
    <sf:errors path="firstname" cssClass="spanError"/> </br>

    <sf:label path="lastname" cssErrorClass="labelError">Last name: </sf:label>
    <sf:input cssErrorClass="inputError" path="lastname" />
    <sf:errors path="lastname" cssClass="spanError"/> </br>

    <sf:label path="username" cssErrorClass="labelError">Username: </sf:label>
    <sf:input cssErrorClass="inputError" path="username" />
    <sf:errors path="username" cssClass="spanError"/> </br>

    <sf:label path="password" cssErrorClass="labelError">Password:  </sf:label>
    <sf:password cssErrorClass="inputError" path="password" />
    <sf:errors path="password" cssClass="spanError"/> </br>

    <input type="submit" value="Register" />

</sf:form>




<!--
<form method="post">
    First name: <input type="text" name="firstname"/> </br>
    Last name: <input type="text"  name="lastname"/> </br>
    Username: <input type="text" name="username" /> </br>
    Password: <input type="password" name="password"/> </br>
    <input type="submit" value="Register" />
</form>

-->


</body>
</html>
