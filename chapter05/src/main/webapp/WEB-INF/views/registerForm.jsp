<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false" %>
<html>
    <head>
        <title>Spitter</title>
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <h1>Register</h1>

        <form method="POST">
            First Name: <input type="text" name="firstName"/>
            Last Name: <input type="text" name="lastName"/>
            Email: <input type="email" name="email"/>
            Username: <input type="text" name="username"/>
            Password: <input type="password" name="password"/>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
