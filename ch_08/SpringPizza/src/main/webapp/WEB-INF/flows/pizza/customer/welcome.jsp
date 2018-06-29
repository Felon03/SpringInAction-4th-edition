<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Freed
  Date: 2018/6/25
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 欢迎用户并询问他们的电话号码 --%>
<html>
<head>
    <title>Spring Pizza</title>
</head>
<body>
    <h2>Welcome to Spring Pizza!!!</h2>

    <form:form>
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
        <input type="text" name="phoneNumber" /><br/>
        <input type="submit" name="_eventId_phoneEntered" value="Lookup Customer" />
    </form:form>
</body>
</html>
