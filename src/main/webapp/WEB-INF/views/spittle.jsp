<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Martynka
  Date: 2017-12-27
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Single Spittle</title>
</head>
<body>
<div class="spittleView">
    <div class="spittleMessage">
        <c:out value="${spittle.message}" />
    </div>
    <div>
        <span class="spittleTime"><c:out value="${spittle.time}" /></span>
    </div>
</div>

</body>
</html>
