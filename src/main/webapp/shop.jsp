<%-- 
    Document   : shop
    Created on : 21-09-2017, 10:47:34
    Author     : Mads Voss
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="JavaCode.LineItems"%>
<%@page import="JavaCode.ShoppingCart"%>
<%@page import="Database.Topping"%>
<%@page import="java.util.List"%>
<%@page import="Database.Bottom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Bottom> bottomList = (List<Bottom>) session.getAttribute("BottomList");
    List<Topping> toppingList = (List<Topping>) session.getAttribute("ToppingList");
    List<LineItems> lineItems;
    if(session.getAttribute("ShoppingCart") != null){
        ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("ShoppingCart");
        lineItems = shoppingCart.getLineItems();
    }
    else
    lineItems = new ArrayList();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>
        <h1>Shop</h1>
        <form action="ProductControlServlet" method="POST">
            <select name="Topping">
                <%for (int i = 0; i < toppingList.size(); i++) {%>
                <option value="<%=i%>"><%=toppingList.get(i).getName()%></option>
                <%}%>
            </select>
            <select name="Bottom">
                <%for (int i = 0; i < bottomList.size(); i++) {%>
                <option value="<%=i%>"><%=bottomList.get(i).getName()%></option>
                <%}%>
            </select>
            <input type="input" name="qty" placeholder="Quantity" required/>
            <input type="submit" name="submit" value="Add Cupcake"/>
        </form>
            
        <table class="fixed_headers">
            <thead>
                <%for(int i = 0; i < lineItems.size(); i++){%>
                <tr>
                    <th><%=lineItems.get(i).getCupcake().getName()%></th>
                    <th><%=lineItems.get(i).getQty()%></th>
                    <th><%=lineItems.get(i).getCupcake().getTotalPrice() * lineItems.get(i).getQty()%></th>
                    <th><a href="ProductControlServlet?index=<%=i%>">Remove</a></th>
                </tr>
                <%}%>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><a href="">Remove</a></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
