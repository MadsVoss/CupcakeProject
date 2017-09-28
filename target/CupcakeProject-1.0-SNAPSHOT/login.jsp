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
        <link rel="stylesheet" href="CSS/form.css">
    </head>
    <body id="login">
        <jsp:include page="includes/menu.jsp" />
        <h1>Login</h1>
        <div id="bg">
            <div class="module">
                <form class="form" method="POST" action="FormServlet">
                    <input type="text" name="username" required  placeholder="Username" class="textbox" />
                    <input type="password" name="password" required  placeholder="Password" class="textbox" />
                    <input type="submit" name="submit" value="Login" class="button" />
                </form>
            </div>
        </div>
    </body>
</html>
