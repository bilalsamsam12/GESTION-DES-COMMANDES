<%-- 
    Document   : newjsp
    Created on : 12 mai 2019, 15:52:24
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
            .lu {

                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                /*                background-color: #333;*/
            }



            .navba {
                margin-top: 0.6%;
/*                margin-right: 25%;*/
                float: right;

            }



            #dropdown {
                display: block;
                color: rgb(15, 13, 13);
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }





            .dropdown-content {
                display: none;
                margin-top: 0px;
                position: absolute;
                background-color: #21212155;
                width: 200px;
                margin-left: -25%;

            }

            #dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown-content #a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;

            }

            table {
                margin-top: 30px;
                margin-bottom: 30px;
            }

            thead {
                color: white;
                background-color: #21212299;
                width: 15px;
                text-align: center;
            }

            td {
                width: 115px;
            }

            tbody {
                background-color: white;
            }
            #div1{
                width: 20px;
                height: 20px;
                border-radius: 50%;
                background-color: orange;
                text-align: center;
                color: white;
                
                 


            }
        </style>
    </head>
    <body>
        <div>

            <li id="dropdown" class="navba">
                 <div id="div1" style="margin-top: -17%">
            <%
                ArrayList<String> list = (ArrayList<String>) session.getAttribute("panel");
                if (list != null) {
                    out.println(list.size());
                } else {
                    out.println("<lable >0</label>");
                }
            %>
        </div>
                <a href="javascript:void(0)" class="dropbtn" id="navbar1" style="text-decoration: none"><img
                        src="images/produit.png" style="margin-top: -17%" width="35" height="35" alt="img commander">
                    <!--                    <label
                                            style="color:black;margin-top: 2px">Liste Commandes</label>-->
                </a>
                <div class="dropdown-content" style="padding-right: auto">
                    <div class="card" style="width: 25rem;background-color: transparent">
                        <center>
                            <ul class="lu" style="background-color:#21212189">



                                <%
                                    ArrayList<String> listcmd = (ArrayList<String>) session.getAttribute("panel");

                                    if (listcmd != null) {
                                        if (listcmd.size() == 0) {
                                            out.println("<label style='font-size: 35px;color:white'> aucun produit </label>");

                                        } else {
                                %>
                                <form action="commandertest" method="post">
                                    <table style="margin-top: 0px; ">
                                        <tr style="border-bottom: 1 solid black; text-align: center">
                                            <td class="tdco">Nom & Marque Prod </td>
                                            <td class="tdco">QUANTITER </td>
                                            <td class="tdco">PRIX</td>


                                        </tr>
                                        <%   for (int i = 0; i < listcmd.size(); i++) {
                                                String[] d = listcmd.get(i).split(":");%>


                                        <tr style="border-bottom: 1 solid black; text-align: center">
                                            <td class="tdco"><%=d[3]%></td>
                                            <td class="tdco"><%=d[4]%></td>
                                            <td class="tdco"><%=d[2]%></td>

                                            <%out.println("<td> <a href='test_ajax?id=" + listcmd.get(i) + "' id='a'><img src='images/delete.png' width='35'"
                                                        + " height='35'></a></td>");%>
                                        </tr>

                                        <%    }
                                            %>
                                    </table>
                                    <input type="submit" value="commander" style="background-color: #55555599;border-radius: 10px;border: none;
                                           color: white;
                                           padding: 9px 20px;
                                           text-align: center;
                                           text-decoration: none;
                                           display: inline-block;
                                           font-size: 16px;
                                           margin: 4px 2px;
                                           cursor: pointer;">
                                </form>s
                                <%   }} else {
                                        out.println("<label style='font-size: 35px;color:white'> aucun produit </label>");
                                    }

                                %>


                            </ul>
                        </center>
                    </div>

                </div>
            </li>
        </div>
    </body>
</html>
