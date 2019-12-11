<%-- 
    Document   : prixprod
    Created on : 30 avr. 2019, 08:53:07
    Author     : chagd
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .div1 {
                background-color: #21212152;
                padding-top: 15px;
                margin-top: 3%;
                position: relative;
                padding-bottom:auto;
                width: 470px;
                border-radius: 10px;
                -webkit-box-shadow: 10px 10px 10px 10px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 10px 10px 10px #212121;
            }
            .lab {
                position: absolute;
                padding-left: 3px;
                padding-bottom: 1px;
                font-weight: bold;
                text-shadow: 3px;
                font-weight: 30px;
                font-size: 15px;
                color: white;
            }
            input {
                width: 220px;
                height: 30px;
                border-radius: 5px;
                padding-left: 7px;
                color: white;
                border: solid 1px black;
                border: solid 1px white;
                -webkit-box-shadow: 7px 7px 7px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 5px 5px 5px #212121;
                background-color: transparent;
                margin-bottom: 10px;
                margin-top: 20px;

            }
            .inscre {
                width: 220px;
                height: 30px;
                border-radius: 5px;
                padding-left: 10px;
                border: solid 1px rgb(184, 184, 199);
                font-weight: bold;
                color: rgb(231, 232, 238);
                text-align: center;
                background-color: #21212299;
                -webkit-box-shadow: 7px 7px 7px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 5px 5px 5px #212121;
                margin-top: 20px;

            }
            body {
                background-image: url("images/3.jpg");
            }

        </style>
    </head>
    <body>
        <% if (session.getAttribute("mat") != null) {%>
        <%if (session.getAttribute("status").equals("Chef")) {%>
        <%@include file="navbar.jsp" %>
        <%} else if (session.getAttribute("status").equals("Admin")) {%>
        <%@include file="navbaradmin.jsp" %>

        <%}%>
        <%@include file="border.jsp" %>
    <center>    <div class="div1">
            <form action="prixproduit" method="post">
                <%
                    ArrayList<String> listprod = (ArrayList<String>) request.getAttribute("list");
                    
                    String []pri=new String[listprod.size()];
                    int i=0;
                    if (listprod != null) {
                        for (String s : listprod) {
                            String[] p = s.split(":");
                    
                %> 
                <label class="lab" name=<%=p[0]%>> <%=p[1]%> <%=p[2]%></label><input type="text" placeholder="exemple : 21.00 - 2.35" pattern="^[0-9]+\.[0-9]{1,2}$" required  name=<%=p[0]%> /> <br>
                <%
                    pri[i]=listprod.get(i);
                    i++;
                    }
                   
                    session.setAttribute("pri", pri);

                %>
                <input type="submit" value="valider" class="inscre">
            </form>
        </div></center>

    <% } 
        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }%>
</body>
</html>
