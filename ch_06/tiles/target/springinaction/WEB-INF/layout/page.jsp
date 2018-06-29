<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Freed
  Date: 2018/6/20
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" %>
    <%--主布局模板： 引用其他模板来创建视图--%>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" href="<s:url value="/resources/style.css" />">
</head>
<body background="<s:url value="/resources" />/images/spitter_background.gif">
    <%--insert header--%>
    <div id="header" style="text-align: center;">
        <t:insertAttribute name="header" />
    </div>

    <%--insert body--%>
    <div id="content" style="text-align: center;">
        <t:insertAttribute name="body" />
    </div>

    <%--insert footer--%>
    <div id="footer" style="text-align: center">
        <t:insertAttribute name="footer" />
    </div>
</body>
</html>
