<%-- 
    Document   : adminPage
    Created on : Sep 28, 2017, 8:51:54 AM
    Author     : Jonatan
--%>

<%@page import="Database.ODetails"%>
<%@page import="java.util.List"%>
<%@page import="Database.DataMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataMapper dataMapper = new DataMapper();
    List<ODetails> oDetailsList = dataMapper.adminPageData();

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AdminPage</h1>
        <%
            int t = 0;
            for(int i = 0; i < oDetailsList.size(); i++){
                
            
        %>
        <a href="invoiceDetails.jsp?ididid=<%=oDetailsList.get(i).getInvoiceid()%>"><%=oDetailsList.get(i).toString()%></a><br>
        <%}%>
    </body>
</html>
