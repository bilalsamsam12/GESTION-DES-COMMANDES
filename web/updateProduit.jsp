<%-- 
    Document   : updateProduit
    Created on : 3 mai 2019, 11:04:14
    Author     : chagd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-image: url("images/3.jpg");

            }

            #di {
                background-color: #21212152;
                padding-top: 15px;
                margin-top: 0%;
                padding-top: 60px;
                width: 470px;
                height: 450px;
                border-radius: 10px;
                -webkit-box-shadow: 10px 10px 10px 10px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 10px 10px 10px #212121;
            }


            #inscre {
                width: 220px;
                height: 30px;
                margin-top: 40px;
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

            }

            #lab2 {
                position: absolute;
                padding-left: 3px;
                padding-bottom: 1px;
                font-weight: bold;
                text-shadow: 3px;
                font-weight: 30px;
                font-size: 25px;
                color: white;
            }

            #select {
                width: 230px;
                height: 30px;
                border-radius: 5px;
                padding-left: 10px;
                border: solid 1px black;
                border: solid 1px white;
                -webkit-box-shadow: 7px 7px 7px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 5px 5px 5px #212121;
                background-color: transparent;
                color: white;
                margin-bottom: 60px;
                margin-top: 20px;

            }

            option {
                width: 270px;
                height: 30px;
                font-family: 'Courier New', Courier, monospace;
                font-weight: bold;
                font-size: 15px;
                color: #212121;
            }

            .inp {
                width: 220px;
                height: 30px;
                border-radius: 5px;
                padding-left: 10px;
                color: white;
                border: solid 1px black;
                border: solid 1px white;
                -webkit-box-shadow: 7px 7px 7px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 5px 5px 5px #212121;
                background-color: transparent;
                margin-bottom: 40px;
                margin-top: 40px;
            }

            h1 {
                font-family: Arial, Helvetica, sans-serif;
                color: rgb(96, 104, 110);
            }
            table {
                margin-top: 30px;
            }

            thead {
                color: white;
                background-color: #21212299;
                width: 15px;
                text-align:center;
            }

            td {
                width: 115px;
            }

            tbody {
                background-color: white;
            }
        </style>
    </head>
    <body>
         <% if (session.getAttribute("mat") != null) {%>
         <%@include file="navbar.jsp" %>
         <%@include file="border.jsp" %>
    <center>
        <h1>Modification d'un Produit</h1>
        <div id="di">
            <form method="post" action="updateprod">
                <input type="hidden" name="idp" value=<%=request.getAttribute("idp")%>>
               <label id="lab2" >Nom :</label>
               <input type="text" placeholder="Nom du produit" class="inp" name="nomp" required  value=<%=request.getAttribute("nomp")%> /><br>
                <label id="lab2">Marque :</label>
                <input type="text" placeholder="Marque " class="inp" name="marquep" required value=<%=request.getAttribute("marquep")%> /><br>
                <label id="lab2">Image :</label>
            <input type="text" placeholder="exemple:  img.jpg " class="inp" name="imagep" pattern="^.*.jpg$" required value=<%=request.getAttribute("imagep")%> /><br>

                
                <input type="submit" value="modifier Produit" id="inscre" />
            </form>
                    </center>
<%} else {
                                 request.getRequestDispatcher("Login.jsp").forward(request, response);
                             }%>
    </body>
</html>
