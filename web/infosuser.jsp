<%@page import="stage.MyConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <style>
            body {
                background-image: url("images/3.jpg");

            }

            #div1 {
                background-color: #21212152;
                display: block;
                margin-left: auto;
                margin-right: auto;       
                width: 470px;
                height: 530px;
                border-radius: 10px;
                -webkit-box-shadow: 10px 10px 10px 10px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 10px 10px 10px #212121;


            }


            #inscre {
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

            }

            #lab2 {
                position: absolute;
                padding-left: 3px;
                padding-bottom: 1px;
                font-weight: bold;
                text-shadow: 3px;
                font-weight: 30px;
                font-size: 15px;
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
            optgroup {
                color: #212121;
                font-family: 'Courier New', Courier, monospace;
            }

            option{
                width: 270px;
                height: 30px;
                font-family: 'Courier New', Courier, monospace;
                font-weight: bold;
                font-size: 15px;
                color: #212121;
            }

            #inp {
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
                margin-bottom: 20px;
                margin-top: 20px;
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
    <center>
        <h1>L'ajoute d'un Utilisateur</h1>
        <%if (request.getParameter("error") != null) {%>
        <div style="color: red ; font-size: 20px">
            <strong> <%=request.getAttribute("msg")%></strong>
        </div>
        <%}%>     
        <div id="div1">
            <form method="post" action="ajoute_user">
                <label id="lab2">Matricule :</label>
                <input type="text" placeholder="" id="inp" required class="" pattern="^\d{6}$" name="mat" /><br>
                <label id="lab2">Nom :</label>
                <input type="text" placeholder="" id="inp" required maxlength="" class=""  name="nom" /><br>
                <label id="lab2">Prenom :</label>
                <input type="text" placeholder="" id="inp" required class=""  name="prenom" /><br>
                <label id="lab2">Email :</label>
                <input type="email" placeholder="" id="inp" required maxlength="" class=""  name="email" /><br>
                <label id="lab2">Telephone:</label>
                <input type="tel" placeholder="" id="inp" required maxlength="" pattern="^[0-9]{10}$"  name="tel" /><br>
                <label id="lab2">Programme:</label>
                <select id="select"  required name="programme">
                    <option >--Choisir--</option>  
                    <option>Boeing</option>
                    <option>Snecma</option>
                    <option>B 787</option>
                    <option>Leap</option>
                    <option>Rh</option>
                    <option>Finance</option>
                    <option>Maintenace</option>
                    <option>Airbus</option>
                    <option>Qualite</option>
                    <option>5X</option>
                    <option>Achat</option>
                    <option>Calibration</option>
                    <option>Dassault</option>
                    <option>It</option>
                    <option>Lean</option>
                    <option>Logistique</option>
                    <option>Turbomeca</option>
                </select><br>
                <input type="submit" value="Ajouter Utilisateur" id="inscre" />
            </form>
        </div>
        <form action="ajoute_user" method="get">
            <table border="2">
                <thead>
                    <tr>
                        <td>Matricule</td>
                        <td>Nom</td>
                        <td>Prenom</td>
                        <td>Email</td>
                        <td>Telephone</td>
                        <td>Programme</td>

                    </tr>
                </thead>
                <tbody>


                    <%
                        Connection con = MyConnection.getMyConnection();
                        PreparedStatement prst = con.prepareStatement("select * from Util where Status=?");
                        prst.setString(1, "User");
                        ResultSet rst = prst.executeQuery();
                        while (rst.next()) {

                            int mat = rst.getInt(1);
                            String nom = rst.getString(2);
                            String prenom = rst.getString(3);
                            String email = rst.getString(4);
                            String tel = rst.getString(5);
                            String prog = rst.getString(6);

                            out.println(
                                    "<tr> <td>" + mat + "</td>"
                                    + " <td>" + nom + "</td>"
                                    + " <td>" + prenom + "</td>"
                                    + " <td>" + email + "</td>"
                                    + " <td>" + tel + "</td>"
                                    + " <td>" + prog + "</td>"
                                    + " <td><a href='ajoute_user?id=" + mat + "&value=del'>"
                                    + "<img src='images/delete.png' width='25px' height='25px' style='margin-right:36px ' title='delete'></a>"
                                    + "<a  href='ajoute_user?id=" + mat + "&value=up'><img src='images/Update.png' width='25px' height='25px' title='update'></a></td>"
                                    + "</tr>");
                        }%>


                </tbody>
            </table>
        </form>
        <%} else {
                                 request.getRequestDispatcher("Login.jsp").forward(request, response);
                             }%>
    </center>

</body>

</html>