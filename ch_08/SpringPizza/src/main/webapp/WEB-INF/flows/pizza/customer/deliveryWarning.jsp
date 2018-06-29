<%--
  Created by IntelliJ IDEA.
  User: Freed
  Date: 2018/6/25
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 告知顾客不能将披萨配送到他们的地址 --%>
<html>
<head>
    <title>Spring Pizza</title>
</head>
<body>
    <h2>Delivery Unavailable</h2>

    <p>The address is outsize of our delivery area. The order may still be taken for carry-out</p>

    <a href="${flowExecutionUrl}&_eventId=accept">Accept</a>
    <a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>
</body>
</html>
