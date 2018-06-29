<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--使用spring的表单绑定库，将前缀指定为sf(springform)--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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

    <%--<form method="POST">--%>
        <%--First Name: <input type="text" name="firstName" /><br/>--%>
        <%--Last Name: <input type="text" name="lastName" /><br/>--%>
        <%--Email: <input type="email" name="email" /><br/>--%>
        <%--Username: <input type="text" name="username" /><br/>--%>
        <%--Password: <input type="password" name="password" /><br/>--%>
        <%--<input type="submit" value="Register" />--%>
    <%--</form>--%>

    <%--渲染一个HTML<form>标签，同个commandName属性构建针对某个模型的上下文信息--%>
    <%--因此需要修改spitterController，以确保模型中存在以spitter为key的Spitter对象--%>
    <%--<sf:errors>展现错误--%>
    <%--<sf:form method="POST" commandName="spitter">--%>
        <%--First Name: <sf:input path="firstName" /><sf:errors path="firstName" cssClass="error" /><br/>--%>
        <%--Last Name: <sf:input path="lastName" /><sf:errors path="lastName" cssClass="error" /><br/>--%>
        <%--Email: <sf:input path="email" /><sf:errors path="email" cssClass="error" /><br/>--%>
        <%--&lt;%&ndash;Email: <sf:input path="email" type="email" /><sf:errors path="email" cssClass="error" /><br/>&ndash;%&gt;--%>
        <%--Username: <sf:input path="username" /><sf:errors path="username" cssClass="error" /><br/>--%>
        <%--Password: <sf:password path="password" /><sf:errors path="password" cssClass="error" /><br/>--%>
        <%--<input type="submit" value="Register">--%>
    <%--</sf:form>--%>
    <sf:form method="POST" commandName="spitter">
        <sf:errors path="*" element="div" cssClass="errors" />
        <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>:
            <sf:input path="firstName" cssErrorClass="error" /><br/>
        <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>:
            <sf:input path="lastName" cssErrorClass="error" /><br/>
        <sf:label path="email" cssErrorClass="error">Email</sf:label>:
            <sf:input path="email" cssErrorClass="error" /><br/>
        <sf:label path="username" cssErrorClass="error">Username</sf:label>:
            <sf:input path="username" cssErrorClass="error" /><br/>
        <sf:label path="password" cssErrorClass="error">Password</sf:label>:
            <sf:password path="password" cssErrorClass="error" /><br/>
        <input type="submit" value="Register">
    </sf:form>
</body>
</html>
