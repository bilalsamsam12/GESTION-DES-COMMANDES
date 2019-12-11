<%-- 
    Document   : DemanderProd
    Created on : 6 mai 2019, 19:08:10
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
                margin: 0%;
                padding: 0%;
                margin-right: 0%;
                /*background-image: url("images/3.jpg");*/
            }
            table{
                width: 95%;
                height: 35%;

            }
            #imagepr{
                width: 100%;
                height: 100%;
                background-color: transparent;
            }

            /*            #x1{
                            padding-left: 23%;
                            
                        }*/

            #div2{

            }
             .lab1{
                margin-left: 60px;
                color: black;
                font-size: 20px;
                margin-top: 10px;

            }
            input[type=text] {
                margin-left: 30px;
                margin-top: 10px;
                width: 220px;
                border-radius: 5px;
                border: solid #333 1px;
                height: 30px;
                padding-left: 15px;

            }
            #but{
                background-color: #333;
                width: 90px;
                height: 30px;
                border: solid #333 1px;
                border-radius: 5px;
                color: white;
                margin-left: 30px;
            }


        </style>
        <script src="js/jquery-3.3.1.js">
        </script>


    </head>
    <body>
    <center>
        <% if (session.getAttribute("mat") != null) {%>
        <%if (session.getAttribute("status").equals("Chef")) {%>
        <%@include file="navbar.jsp" %>
        <%} else if (session.getAttribute("status").equals("Admin")) {%>
        <%@include file="navbaradmin.jsp" %>

        <%} else if (session.getAttribute("status").equals("User")) {%>
        <%@include file="navbaruser.jsp" %>
      
        
        <%}%>

        <%--     <%@include file="border.jsp" %>--%>
            <%@include file="newjsp.jsp" %>


            <div style="margin-top: 6%;margin-left: 2%">

                <label class="lab1"> Nom</label> <input type="text" placeholder="Entrer un Nom ..." style="background-color: black;color: white" id="nom">
            <label class="lab1">  Marque </label><input type="text" placeholder="Entrer une Marque ..." style="background-color: black;color: white" id="marq">
            <input type="button" value="chercher" id="but">
        </div>
        <div id="div2"> 

            <table>
                <%                    int i = 0, j = 1;
                    Connection con = MyConnection.getMyConnection();
                    PreparedStatement prst = con.prepareStatement("select * from fourprod f inner join produit p on(p.idprod=f.idprod)");
                    ResultSet rst = prst.executeQuery();
                    out.println("<tr>");
                    while (rst.next()) {

                        if (i % 3 == 0) {
                            out.println("</tr><tr>");
                        }

                %>



                <td > 
                    <form action="Commander" method="post">
                        <div id="divimg">  <img src="imgproduit/<%=rst.getString("image")%> " id='imagepr' /></div>
                        <center><strong> <%=rst.getString("nom_p") + "   " + rst.getString("marque")%></strong> </center>
                        <center><mark style="background-color: #33333333"><label><%=rst.getFloat("prix")%> </label>DH </mark></center>
                         <center> <label>Quantite:</label>
                             <input type="text" pattern="^[0-9]+$" required name="qte" style="width: 90px"/>
                            <input type="hidden" name="idpro" value="<%=rst.getInt("idprod")%>:<%=rst.getInt("matricule_f")%>:<%=rst.getFloat("prix")%>:<%=rst.getString("nom_p")%>   <%= rst.getString("marque")%>" />
                            <input type="submit" value="add"  style="background-color: #333;
                                   width: 70px;
                                   height: 30px;
                                   border: solid #333 1px;
                                   border-radius: 5px;
                                   color: white;
                                   margin-left: 30px"> </center>


                    </form>
                </td>
                <%
                        j++;
                        i++;
                    }
                %>
            </table>

        </div>
            <% if (session.getAttribute("status").equals("User")) {%>
        
         <%@include file="footerbare.jsp" %>
        
        <%}%>

        <%} else {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }%>
            </center>
    </body>
    <!--     <script>
                $(document).on("click", ".addTcad", function () {
    
    
                    $(this).closest("form").submit();
                });
            </script>-->
    <script>



        $("#but").click(function () {
            $.ajax({
                'type': 'POST',
                'url': 'test_ajax',
                'data': {'text': $("#nom").val(), 'marq': $("#marq").val()},
                'success': function (d) {
                    $("#div2").html(d);
                    // $("#S2").prop("disabled",false)

                },
                'error': function (error) {
                    alert("error");
                }

            });
        });

    </script>
</html>
