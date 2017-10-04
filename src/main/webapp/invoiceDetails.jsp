<%-- 
    Document   : invoiceDetails
    Created on : Oct 4, 2017, 2:29:09 PM
    Author     : Jonatan
--%>

<%@page import="JavaCode.LineItems"%>
<%@page import="java.util.List"%>
<%@page import="JavaCode.ShoppingCart"%>
<%@page import="Database.DataMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int currentInvoice = Integer.parseInt(request.getParameter("ididid"));
    DataMapper dataMapper = new DataMapper();
    ShoppingCart cart;
    cart = dataMapper.fillShoppingCart(currentInvoice);
    List<LineItems> lineItems = cart.getLineItems();
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body
        <h1>Current invoice <%=currentInvoice%></h1>
        <table class="fixed_headers">
            <thead>
                
                <tr>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    
                </tr>
                
            </thead>
            <tbody>
                <%for(int i = 0; i < lineItems.size(); i++){%>
                <tr>
                    <td><%=lineItems.get(i).getCupcake().getName()%></td>
                    <td><%=lineItems.get(i).getQty()%></td>
                    <td><%=lineItems.get(i).getCupcake().getTotalPrice() * lineItems.get(i).getQty()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
