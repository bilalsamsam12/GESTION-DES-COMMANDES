<%-- 
    Document   : updatefourni
    Created on : 2 mai 2019, 08:15:36
    Author     : chagd
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="stage.MyConnection"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
               background-image: url("images/3.jpg");
                background-size: 100%;

            }
            #divo{
                background-color: #21212152;
                padding-top: 15px;
                margin-top: 1%;
                width: 700px;
                height: 530px;
                border-radius: 10px;
                -webkit-box-shadow: 10px 10px 10px 10px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 10px 10px 10px  #212121;


            }


            #inscre{
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
            .lab2{
                position: absolute;
                padding-left: 3px;
                padding-bottom: 1px;
                font-weight: bold;
                text-shadow: 3px;
                font-weight: 30px;
                font-size: 15px;
                color: white;
                margin-left: 50px;
            }
            .lab0{
                padding-left: 3px;
                padding-bottom: 1px;
                font-weight: bold;
                text-shadow: 3px;
                font-weight: 30px;
                font-size: 20px;
                color: white;
                margin-right: 20px; 
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
            option{

                background-color:#00000070;
                color:white;
                width: 270px;
                height: 30px;
                font-family: 'Courier New', Courier, monospace;
                font-weight: bold;
                font-size: 15px;

            } 


            .inp{
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
                margin-left: 50px;

            }
            h1{
                font-family: Arial, Helvetica, sans-serif;
                color: rgb(96, 104, 110);
            }
            .inpt{
                width: 500px;
                height: 40px;
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
                margin-left: 50px;

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
    <center>

        <h1>Modification d'un Fournisseur</h1>
        <div id="divo">
            <form method="get" action="prixproduit">
                <label class="lab2">Matricule :</label>
                <input type="hidden"  name="matf"   value=<%=request.getAttribute("matf")%> > 
                <input type="text"  class="inp" pattern="^\d{6}$" disabled value="<%=request.getAttribute("matf")%>" required  /> <br>
                <label class="lab2">Nom :</label>
                <input type="text" required class="inp" name="nomf" value="<%=request.getAttribute("nomf")%>" />
                <label class="lab2">Prenom :</label>
                <input type="text" required class="inp"  name="prenomf" value="<%=request.getAttribute("prenomf")%>" /><br>
                <label class="lab2">Telephone :</label>
                <input type="text"  pattern="^[0-9]{10}$" required maxlength="10" name="telf" class="inp" value="<%=request.getAttribute("telf")%>" />
                <label class="lab2">E-mail :</label>
                <input type="email" required class="inp"  name="emailf" value="<%=request.getAttribute("emailf")%>" /><br>
                <label class="lab2">Adresse :</label>
                <input type="text" required  class="inpt"  name="addrf" value="<%=request.getAttribute("addrf")%>"/><br>
                <% Connection con = MyConnection.getMyConnection();
                    PreparedStatement prst = con.prepareStatement("select * from produit");
                    int mat = Integer.parseInt(request.getAttribute("matf") + "");
                    PreparedStatement pst = con.prepareStatement("select * from fourprod where matricule_f=? ", ResultSet.TYPE_SCROLL_INSENSITIVE);
                    pst.setInt(1, mat);
                    int i = 0;
                    ResultSet rst = prst.executeQuery();
                    ResultSet st = pst.executeQuery();
                    ArrayList <String> lp=new ArrayList <String>();
                    while (st.next()) {
                            int idp = st.getInt(1);
                            lp.add(idp+"");
                        }
                    
                    String s = "";
                    while (rst.next()) {
                       
                        String id = rst.getString(1);
                        String nom = rst.getString("nom_p");
                        String marque = rst.getString("marque");
                        if (i % 3 == 0) {
                            out.println("<br>");
                            i = 0;
                        }
                        i++;
                        for(String j:lp){
                            s="";
                            if(id.equals(j)){
                                s="checked";
                                break;
                            }
                        }

                        
                %>
                <input type="checkbox" name="produit"   <%=s%>  value='<%=id%>' ><label class="lab0" name="name" > <%=nom%> <%=marque%></label> 
                <%
                    }
                %>
                <br><input type="submit" value="Modifier Fournisseur" id="inscre"  class="inp" />
            </form>
        </div>
        <%} else {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }%>
    </body>
</html>
