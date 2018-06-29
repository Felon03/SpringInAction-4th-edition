<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Freed
  Date: 2018/6/13
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <!--启用EL表达式-->
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
    <div class="spittleView">
        <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}" /></span>
        </div>

    </div>
</body>
</html>
