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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper"
        <jsp:include page="includes/menu.jsp" />
        <h1>AdminPage</h1>
        <%
            int t = 0;
            for(int i = 0; i < oDetailsList.size(); i++){
                
            
        %>
        <a class="invoiceDetails" href="invoiceDetails.jsp?ididid=<%=oDetailsList.get(i).getInvoiceid()%>"><%=oDetailsList.get(i).toString()%></a><br>
        <%}%>
        </div>
    </body>
</html>
