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
<h1>Welcome to Spittr!</h1>

<a href="<c:url value="/spittles" />">Spittles</a> |
<a href="<c:url value="/spitter/register" />">Register</a>
