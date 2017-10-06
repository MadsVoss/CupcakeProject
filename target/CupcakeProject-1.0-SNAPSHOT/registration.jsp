<%-- 
    Document   : registration
    Created on : 20-09-2017, 20:00:03
    Author     : ezl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="CSS/main.css">
        <link rel="stylesheet" href="CSS/form.css">
    </head>
    <body id="registration">        
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />
            <h1>Registration</h1>
            <form id="registrationForm" action="FormServlet" method="POST">
                <label for="username">Username</label>
                <input type="text" name="username" placeholder="Username" required>
                <label for="email">Email</label>
                <input type="email" name="email" placeholder="Email" required>
                <label for="email2">Email again</label>
                <input type="email" name="email2" placeholder="Email again" required>
                <label for="password2">Password</label>
                <input type="password" name="password" placeholder="Password" required>
                <label for="password2">Password again</label>
                <input type="password" name="password2" placeholder="Password again" required>
                <input type="submit" name="submit" value="Sign up">
            </form>
        </div>
    </body>
</html>
