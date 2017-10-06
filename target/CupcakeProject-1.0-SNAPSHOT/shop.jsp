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
    User user = (User) session.getAttribute("user");
    float balance = user.getBalance();

    if (session.getAttribute("ShoppingCart") != null) {
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
        lineItems = shoppingCart.getLineItems();
        totalPrice = shoppingCart.getTotalPrice();
    } else {
        lineItems = new ArrayList();
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/main.css">
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="includes/menu.jsp" />    
            <h1>Shop</h1>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>add cupcake</h3>
                        <form action="ProductControlServlet" method="POST">
                            <div class="form-group">
                                <label for="exampleFormControlSelect1">Topping</label>
                                <select name="Topping" class="form-control" id="exampleFormControlSelect1">
                                    <%for (int i = 0; i < toppingList.size(); i++) {%>
                                    <option value="<%=i%>"><%=toppingList.get(i).getName()%>: <%=toppingList.get(i).getPrice()%> dkk</option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlSelect1">Bottom</label>
                                <select name="Bottom" class="form-control" id="exampleFormControlSelect1">
                                    <%for (int i = 0; i < bottomList.size(); i++) {%>
                                    <option value="<%=i%>"><%=bottomList.get(i).getName()%>: <%=bottomList.get(i).getPrice()%> dkk</option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="exampleFormControlInput1">Quantity</label>
                                <input type="number" name="qty" class="form-control" id="exampleFormControlInput1" placeholder="0">
                            </div>
                            <button type="submit" name="submit" class="btn btn-primary" value="Add Cupcake">Add cupcake to shopping cart</button>
                        </form>
                    </div>
                    <div class="col-sm-6">
                        <h3>Shopping cart</h3>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (int i = 0; i < lineItems.size(); i++) {%>
                                <tr>
                                    <td><%=lineItems.get(i).getCupcake().getToppingName()%> <%=lineItems.get(i).getCupcake().getBottomName()%></td>
                                    <td><%=lineItems.get(i).getQty()%></td>
                                    <td><%=lineItems.get(i).getCupcake().getTotalPrice() * lineItems.get(i).getQty()%> dkk</td>
                                    <td><a href="ProductControlServlet?index=<%=i%>">x</a></td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                        <p>Total price: <%=totalPrice%> dkk</p>
                        <form action="ProductControlServlet" method="POST">
                            <button type="submit" name="submit" class="btn btn-primary" value="Checkout">Checkout</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
