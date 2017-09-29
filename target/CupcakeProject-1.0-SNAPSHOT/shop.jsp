<%-- 
    Document   : shop
    Created on : 21-09-2017, 10:47:34
    Author     : Mads Voss
--%>
<%@page import="Database.User"%>
<%@page import="Database.DataMapper"%>
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
    
    float totalPrice = 0;
    if(session.getAttribute("ShoppingCart") != null){
        ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("ShoppingCart");
        lineItems = shoppingCart.getLineItems();
        totalPrice = shoppingCart.getTotalPrice();
    }
    else{
    lineItems = new ArrayList();
    
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link rel="stylesheet" href="CSS/main.css">
        <link rel="stylesheet" href="CSS/form.css">
    </head>
    <body>
        <jsp:include page="includes/menu.jsp" />
        <h1>Shop</h1>
        <div id="bg">
            <form class="form" action="ProductControlServlet" method="POST">
                <select name="Topping" class="textbox">
                    <%for (int i = 0; i < toppingList.size(); i++) {%>
                    <option value="<%=i%>"><%=toppingList.get(i).getName()%></option>
                    <%}%>
                </select>
                <select name="Bottom" class="textbox">
                    <%for (int i = 0; i < bottomList.size(); i++) {%>
                    <option value="<%=i%>"><%=bottomList.get(i).getName()%></option>
                    <%}%>
                </select>
                <input class="textbox" type="input" name="qty" placeholder="Quantity" required/>
                <input class="textbox" type="submit" name="submit" value="Add Cupcake"/>
            </form>
        </div>
            
        <table class="fixed_headers">
            <thead>
                
                <tr>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Remove</th>
                </tr>
                
            </thead>
            <tbody>
                <%for(int i = 0; i < lineItems.size(); i++){%>
                <tr>
                    <td><%=lineItems.get(i).getCupcake().getName()%></td>
                    <td><%=lineItems.get(i).getQty()%></td>
                    <td><%=lineItems.get(i).getCupcake().getTotalPrice() * lineItems.get(i).getQty()%></td>
                    <td><a href="ProductControlServlet?index=<%=i%>">x</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
            <p>Total price: <%=totalPrice%></p>
            <form action="ProductControlServlet" method="POST">
                <input type="submit" value="Checkout" name="submit" />
                
            </form>
            
            <%
                User user = (User)session.getAttribute("user");
                if(user.getRole().equals("Admin")){
            %>
            <a href="adminPage.jsp">Admin page</a>
            <%}%>
            
    </body>
</html>
