<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Martynka
  Date: 2017-12-15
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recent Spittles</title>
</head>
<body>

<h2> Recent Spittles </h2>

<c:forEach items="${spittleList}" var="spittle" >
    <li id="spittle_<c:out value="spittle.id" />">
        <div class="spittleMessage">
            <c:out value="${spittle.message}" />
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}" /> </span>
            <span class="spittleLocation">
            (<c:out value="spittle.latitude" />,
                <c:out value="spittle.longtitude" />)
            </span>
        </div>
    </br>
    </li>

</c:forEach>

</body>
</html>
