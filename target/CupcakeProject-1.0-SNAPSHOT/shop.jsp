<%-- 
    Document   : shop
    Created on : 21-09-2017, 10:47:34
    Author     : Mads Voss
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>
        <h1>Shop</h1>
        <form action="FormServlet" method="GET">
            <select name="Topping">
                <option></option>
            </select>
            <select name="Bottom">
                <option></option>
            </select>
            <input type="input" name="qty" required/>
            <input type="submit" name="submit" value="Add Cupcake"/>
        </form>
    </body>
</html>
