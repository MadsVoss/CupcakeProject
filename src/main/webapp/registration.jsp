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
    <body>
        <div id="bg">
            <div class="module">
                <h2>Registration</h2>
                <form class="form" method="POST" action="FormServlet">
                    <input type="text" name="username" required  placeholder="Username" class="textbox" />
                    <input type="email" name="email" required  placeholder="Email" class="textbox" />
                    <input type="email" name="email2" required  placeholder="Email Again" class="textbox" />
                    <input type="password" name="password" required placeholder="Password" class="textbox" />
                    <input type="password" name="password2" required  placeholder="Password Again" class="textbox" />
                    <input type="submit" name="submit" value="Register" class="button" />
                </form>
            </div>
        </div>
    </body>
</html>
