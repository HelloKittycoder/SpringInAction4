<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page session="false" %>
<html>
    <head>
        <title>Spitter</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/style.css" />" >
        <style>
            div.errors {
                background-color: #ffcccc;
                border: 2px solid red;
            }
            span.error {
                color: red;
            }
            label.error {
                color: red;
            }
            input.error {
                background-color: #ffcccc;
            }
        </style>
    </head>
    <body>
        <h1>Register</h1>

        <sf:form method="POST" commandName="spitter">
            <sf:errors path="*" element="div" cssClass="errors"/>
            <sf:label cssErrorClass="error" path="firstName">First Name</sf:label>: <sf:input path="firstName" cssErrorClass="error"/><br/>
            <sf:label cssErrorClass="error" path="lastName">Last Name</sf:label>: <sf:input path="lastName" cssErrorClass="error"/><br/>
            <sf:label cssErrorClass="error" path="email">Email</sf:label>: <sf:input path="email" cssErrorClass="error"/><br/>
            <sf:label cssErrorClass="error" path="username">Username</sf:label>: <sf:input path="username" cssErrorClass="error"/><br/>
            <sf:label cssErrorClass="error" path="password">Password</sf:label>: <sf:input path="password" cssErrorClass="error"/><br/>
            <input type="submit" value="Register"/>
        </sf:form>
    </body>
</html>
