<%-- 
    Document   : ajoute_user
    Created on : 21 avr. 2019, 12:44:03
    Author     : SAMSAM BILAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter users</title>
        <style>






        </style>
    </head>
    <body>
        <% if (session.getAttribute("mat") != null) {
               %>
       <%if (session.getAttribute("status").equals("Chef")) {%>
        <%@include file="navbar.jsp" %>
        <%} else if (session.getAttribute("status").equals("Admin")) {%>
        <%@include file="navbaradmin.jsp" %>
        <%}%>
        <%@include file="infosuser.jsp" %>
        <%@include file="border.jsp" %>
        <%} else {
         request.getRequestDispatcher("Login.jsp").forward(request, response);
     }%>
    </body>
</html>
