<%-- 
    Document   : Ajouter_admins
    Created on : 21 avr. 2019, 13:13:00
    Author     : SAMSAM BILAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter admins</title>
        <style>


            body {
                margin: 0;
                padding: 0;
            }

            
        </style>
    </head>
    <body>
        <% if (session.getAttribute("mat") != null) {%>
         <%@include file="navbar.jsp" %>
         <%@include file="border.jsp" %>
         <%@include file="infoadmin.jsp" %>
     <%} else {
                                 request.getRequestDispatcher("Login.jsp").forward(request, response);
                             }%>
    </body>
</html>
