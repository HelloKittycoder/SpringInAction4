<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
        type="text/css"
        href="<c:url value="/resources/style.css" />"/>
</head>
<body>
    <%--<h1>Welcome to Spitter</h1>--%>
    <h1><s:message code="spittr.welcome" text="Welcome"/></h1>

    <div><s:url value="/spitter/register" var="registerUrl"/></div>
    <div>引用一个变量registerUrl====${registerUrl}</div>
    <div>构建一个url====
        <s:url value="/spittles" var="spittlesUrl">
            <s:param name="max" value="60"/>
            <s:param name="count" value="20"/>
        </s:url>${spittlesUrl}
    </div>
    <div>
        <s:url value="/spittles" htmlEscape="true">
            <s:param name="max" value="60"/>
            <s:param name="count" value="20"/>
        </s:url>
    </div>
    <div>
        <s:url value="/spittles" javaScriptEscape="true">
            <s:param name="max" value="60"/>
            <s:param name="count" value="20"/>
        </s:url>
    </div>
    <div>
        <s:escapeBody htmlEscape="true">
            <h1>Hello</h1>
        </s:escapeBody>
    </div>
    <div>
        <s:escapeBody javaScriptEscape="true">
            <h1>Hello</h1>
        </s:escapeBody>
    </div>

    <a href="<c:url value="/spittles"/>">Spittles</a>
    <a href="<c:url value="/spitter/register"/>">Register</a>
</body>
</html>
