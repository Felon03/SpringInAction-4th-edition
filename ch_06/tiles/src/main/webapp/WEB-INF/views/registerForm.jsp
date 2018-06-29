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
<h1>Register</h1>

<sf:form method="POST" commandName="spitter" >
    <sf:errors path="*" element="div" cssClass="errors" />
    <sf:label path="firstName"
              cssErrorClass="error">First Name</sf:label>:
    <sf:input path="firstName" cssErrorClass="error" /><br/>
    <sf:label path="lastName"
              cssErrorClass="error">Last Name</sf:label>:
    <sf:input path="lastName" cssErrorClass="error" /><br/>
    <sf:label path="email"
              cssErrorClass="error">Email</sf:label>:
    <sf:input path="email" cssErrorClass="error" /><br/>
    <sf:label path="username"
              cssErrorClass="error">Username</sf:label>:
    <sf:input path="username" cssErrorClass="error" /><br/>
    <sf:label path="password"
              cssErrorClass="error">Password</sf:label>:
    <sf:password path="password" cssErrorClass="error" /><br/>
    <input type="submit" value="Register" />
</sf:form>
