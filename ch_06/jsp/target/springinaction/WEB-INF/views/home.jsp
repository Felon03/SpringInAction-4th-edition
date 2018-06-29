<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--使用Spring通用标签库--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Freed
  Date: 2018/6/12
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet"
    type="text/css"
    href="<c:url value="/resources/style.css" />">
</head>
<body>
    <%--<h1>Welcome to Spitter</h1>--%>
    <%--如果希望<s:message>能够正常完成任务的话，需要配置一个key为spittr.welcome的信息源--%>
    <%--可以通过ResourceBundleMessageSource或者ReloadableResourceBundleMessageSource配置--%>
    <h1><s:message code="spittr.welcome" /></h1>
    <s:url value="/spittles" var="spittlesUrl" htmlEscape="false" />
    <s:url value="/spitter/register" var="registerUrl" htmlEscape="false" />
    
    <%--<a href="<c:url value="/spittles" />">Spittles</a> |--%>
    <%--<a href="<c:url value="/spitter/register" />">Register</a>--%>
    <a href="${spittlesUrl}"><s:message code="spittr.spittles" /></a> |
    <a href="${registerUrl}"><s:message code="spittr.register" /></a>
    <%--<a href="<s:url value="/spittles" />">Spittles</a> |--%>
    <%--<a href="${registerUrl}">Register</a>--%>

</body>
</html>
