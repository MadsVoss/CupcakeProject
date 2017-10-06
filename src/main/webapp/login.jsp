    <%-- 
    Document   : login
    Created on : 20-09-2017, 20:23:35
    Author     : ezl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/main.css">
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />
            <h1>Login</h1>
            <form id="loginForm" action="FormServlet" method="POST">
                <label for="username">Username</label>
                <input type="text" name="username" placeholder="Username" required>
                <label for="password">Password</label>
                <input type="password" name="password" placeholder="Password" required>
                <input type="submit" name="submit" value="Login">
            </form>
        </div>
    </body>
</html>
