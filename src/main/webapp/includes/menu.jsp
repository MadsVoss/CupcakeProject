<%-- 
    Document   : menu
    Created on : 29-09-2017, 01:14:58
    Author     : ezl
--%>
<%@page import="Database.User"%>
<%
    User user = null;
    
    if (session.getAttribute("user") != null) {
        user = (User) session.getAttribute("user");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav>
    <ul>
        <a href="">
            <img src="img/cupcake.jpg" alt="">
        </a>
        <a href="shop.jsp">
            <li>Cupcakes</li>
        </a>

        <%if (user == null) {%>
        <a href="login.jsp" class="nava">
            <li>Login</li>
        </a>
        <a href="registration.jsp" class="nava">
            <li>Registration / </li>
        </a>
        <%} else {%>
        <a href="FormServlet?logout=1" class="nava">
            <li>Log out</li>
        </a>
        <%}%>
        
        <%
        if (user != null && user.getRole().equals("Admin")) {
        %>
        <a href="adminPage.jsp" class="nava">
            <li>Admin page /</li>
        </a>
        <%}%>
    </ul>
    <%if (user != null) {%>
    <div id="userinfo">
        <p>Username: <%=user.getUsername()%></p>
        <p>Balance: <%=user.getBalance()%> dkk</p>
    </div>
    <%}%>
</nav>
