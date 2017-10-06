<%-- 
    Document   : confirmation
    Created on : Sep 24, 2017, 7:46:28 PM
    Author     : Jonatan
--%>

<%@page import="JavaCode.LineItems"%>
<%@page import="java.util.List"%>
<%@page import="Database.DataMapper"%>
<%@page import="JavaCode.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int checkOutInvoice = Integer.parseInt(request.getParameter("checkOutInvoice"));
    DataMapper dataMapper = new DataMapper();
    float totalPrice = 0;
    ShoppingCart shoppingCart = dataMapper.fillShoppingCart(checkOutInvoice);
    List<LineItems> lineItems = shoppingCart.getLineItems();
    totalPrice = shoppingCart.getTotalPrice();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
        <jsp:include page="includes/menu.jsp" /> 
        <h1>Your cupcakes are on the way</h1>
        <div class="col" id="checkOutInvoice">
                        
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (int i = 0; i < lineItems.size(); i++) {%>
                                <tr>
                                    <td><%=lineItems.get(i).getCupcake().getToppingName()%> <%=lineItems.get(i).getCupcake().getBottomName()%></td>
                                    <td><%=lineItems.get(i).getQty()%></td>
                                    <td><%=lineItems.get(i).getCupcake().getTotalPrice() * lineItems.get(i).getQty()%> dkk</td>
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                        <p>Total price: <%=totalPrice%> dkk</p>
                        
                    </div>
        </div>
    </body>
</html>
