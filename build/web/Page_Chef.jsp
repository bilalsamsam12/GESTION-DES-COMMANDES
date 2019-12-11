<%-- 
    Document   : Page_Chef
    Created on : 11 mai 2019, 14:51:12
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
                margin: 0;
                padding: 0;
            }

           
            body {
                background-image: url("images/3.jpg");

            }
                #d{
                background-color: #21212152;
                padding-top: 15px;
                margin-top: 1%;
                width: 550px;
                margin-bottom: 20px;
                height: 520px;
                border-radius: 10px;
                -webkit-box-shadow: 10px 10px 10px 10px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 10px 10px 10px #212121;


            }
            td{
                
                padding-left: 50px;
            }
            a{
                text-align: center;
                text-decoration: none;
                color: wheat;
            }
        </style>
    </head>
    <body>
        <% if  (session.getAttribute("mat") != null){%>
        <%@include file="navbar.jsp" %>
    <center><div id="d">
            <table>
                <tr>
                    <td width="90" align="center" valign="top"><a href="Ajoute_users.jsp" width="160"height="98"><img src="images/user_icon.png" width="190"></a></td> 
                    <td width="90" align="center" valign="top"><a href="Ajouter_admins.jsp" width="160"height="98"><img src="images/Admin1.png" width="190"></a></td> 

                </tr>
                <tr>
                    <td align="center"><h4><a href="Ajoute_users.jsp">GESTION UTILISATEUR</a></h4></td> 
                    <td><h4><a href="Ajouter_admins.jsp">GESTION ADMIN</a></h4></td>
                </tr>
                 <tr>
                    <td width="90" align="center" valign="top"><a href="Ajouter_produits.jsp" width="160"height="98"><img src="images/produit_icon.png" width="190"></a></td> 
                    <td width="90" align="center" valign="top"><a href="Ajouter_fournisseur.jsp" width="160"height="98"><img src="images/fournisseur_icon.png" width="190"></a></td> 

                </tr>
                <tr>
                    <td><h4><a href="Ajouter_produits.jsp">GESTION PRODUIT</a></h4></td> 
                    <td><h4><a href="Ajouter_fournisseur.jsp">GESTION FOURNISSEUR</a></h4></td>
                </tr>

            </table>
        </div></center>
        <%@include file="footerbare.jsp" %>
        <%@include file="border.jsp" %>
        <%}
         else {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                }%>
    </body>
</html>
