<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Martynka
  Date: 2017-12-28
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
</head>
<body>

<h2>Your profile</h2>
<c:out value="${spitter.username}" /> </br>
<c:out value="${spitter.firstname}" />
<c:out value="${spitter.lastname}" />


</body>
</html>
