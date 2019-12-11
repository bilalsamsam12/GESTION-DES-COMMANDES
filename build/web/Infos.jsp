<%-- 
    Document   : Infos
    Created on : 21 mai 2019, 17:06:22
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
                background-color: rgba(69, 146, 104, 0.801);

            }

            td {
                width: 25%;
            }

            h2,
            h3,
            p {
                color: aliceblue;
            }
        </style>
    </head>
    <body>
        <% if (session.getAttribute("mat") != null) {%>
        <%if (session.getAttribute("status").equals("User")) {%>
        <%@include file="navbaruser.jsp" %>
        <%} else if (session.getAttribute("status").equals("Admin")) {%>
        <%@include file="navbaradmin.jsp" %>
        <%}%>
        <table style="text-align: center;margin-top: 3%;margin-left: 5%">
            <tr>

                <td style="left: 450px ;position: relative ;top: 15px"><img width="100px" height="100px" src="images/tele.png"
                                                                            style="border-radius: 50% ;text-align: center ;background-color: rgb(101, 139, 139) ;"></td>
            </tr>
            <tr>
                <td style="left: 450px ;position: relative "><h2>TELEPHONE</h2></td>
            </tr>
            <tr>
                <td>
                    <h3>Matis Aerospace Contractantes</h3>
                    <p>+121 6 30 20 10 11 phone</p>
                    <p>+121 5 25 24 14 72 facsimile</p>
                </td>
                <td>
                    <h3>Matis 24/7 Service Département</h3>
                    <p>+121 6 25 27 44 47</p>
                    <p>(puis appuyez sur 2 pour les appels d'urgence)</p>
                </td>
                <td>
                    <h3>Bureau de Service Informatique</h3>
                    <p>+121 6 25 24 24 93 phone</p>
                    <p>+121 5 85 24 44 93 facsimile</p>
                </td>
                <td>
                    <h3>Service de L'application</h3>
                    <p>+121 6 25 24 74 81 phone</p>
                    <p>+121 6 47 14 716 17 phone</p>
                </td>
            </tr>
            <tr>
            <tr>
                <td style="left: 450px ;position: relative ;top: 15px"><img width="100px" height="100px" src="images/location.png"
                                                                            style="border-radius: 50% ;text-align: center ;background-color: rgb(101, 139, 139) ;"></td>
            </tr>
            <tr>
                <td style="left: 450px ;position: relative"><h2>ADDRESS</h2></td>
            </tr>
            <tr>
                <td> <h3>Matis Aerospace </h3>
                    <p>695047 S.Noiaser</p>
                    <p>126857 Casablanca</p></td>
                <td>
                    <h3>Matis Aerospace A Jont Company</h3>
                    <p>695047 S.Noiaser</p>
                    <p>126857 Casablanca</p>
                </td>
                <td>
                    <h3>Safran /Boeing </h3>
                    <p>6950 S.Noiaser </p><br><br>
                </td>
                <td>
                    <h3>Safran /Boeing </h3>
                    <p>6950 S.Noiaser </p><br><br>
                </td>

            </tr>
        </tr>
        <tr>
        <tr>
            <td style="left: 450px ;position: relative ;top: 15px"><img width="100px" height="100px" src="images/email1.png"
                                                                        style="border-radius: 50% ;text-align: center ;background-color:rgb(101, 139, 139) ;"></td>
        </tr>
        <tr>
            <td style="left: 450px ;position: relative"><h2>EMAIL</h2></td>
        </tr>
        <tr>


            <td>
                <h3>Matis Aerospace Contractantes</h3>
                <p>Info@Matisgroup.com</p><br><br><br><br>
            </td>
            <td>
                <h3>Safran Group</h3>
                <p>Info@Safrangroup.com</p><br><br><br><br>
            </td>
            <td>
                <h3>Service Aplication</h3>
                <p>service@Matis.com</p>
                <p>BilalSamsam12@gmail.com</p>
                <p>AmineChagdani@gmail.com</p>
            </td>
            <td>
                <h3>Service Aplication</h3>
                <p>service@Matis.com</p>
                <p>BilalSamsam12@gmail.com</p>
                <p>AmineChagdani@gmail.com</p>
            </td>
        </tr>
    </tr>
</table>

<%} else {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }%>
</body>
</html>
