<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Freed
  Date: 2018/6/13
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%--渲染注册表单的JSP--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
    <h1>Register</h1>

    <form method="POST">
        First Name: <input type="text" name="firstName" /><br/>
        Last Name: <input type="text" name="lastName" /><br/>
        Email: <input type="email" name="email" /><br/>
        Username: <input type="text" name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        <input type="submit" value="Register" />
    </form>
</body>
</html>
