<%@page import="stage.MyConnection"%>
<%@page import="java.sql.*"%>
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

            #div7 {
                background-color: #21212152;
                padding-top: 15px;
                margin-top: 1%;
                width: 470px;
                height: 470px;
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
                margin-top: 20px;

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


            #inp {
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

            h1 {
                font-family: Arial, Helvetica, sans-serif;
                color: rgb(96, 104, 110);
            }


            option {
                width: 270px;
                height: 30px;
                font-family: 'Courier New', Courier, monospace;
                font-weight: bold;
                font-size: 15px;
                color: #212121;

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
                margin-bottom: 0px;
                margin-top: 20px;
                text-align: center;

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
        
        <h1>L'ajoute d'un Admin</h1>
        
        <div id="div7">
            
        <%if (request.getParameter("error") != null) {%>
        <div style="color: red ; font-size: 20px">
            <strong> <%=request.getAttribute("msg")%></strong>
        </div>
        <%}%> 
            <form method="post" action="Ajouter_admin">
                <label id="lab2">Matricule :</label>
                <input type="text" id="inp" pattern="^\d{6}$" name="matad" required /><br>
                <label id="lab2">Nom :</label>
                <input type="text"  id="inp"  name="nomad" required /><br>
                <label id="lab2">Prenom :</label>
                <input type="text"  id="inp" name="prenomad" required /><br>
                <label id="lab2">Email :</label>
                <input type="email" id="inp" required name="emailad" /><br>
                <label id="lab2">Telephone:</label>
                <input type="tel"  id="inp"  pattern="^[0-9]{10}$"  required name="telad" /><br>
                <label id="lab2">Programme:</label>
                <select id="select" name="programmead" required>
                    <option>--Choisir--</option>
                    <option>Boeing</option>
                    <option>Snecma</option>
                    <option>B 787</option>
                    <option>Leap</option>
                    <option>Rh</option>
                    <option>Finance</option>
                    <option>Maintenace</option>
                    <option>Airobus</option>
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
                <input type="submit" value="Ajouter Admin" id="inscre" />
            </form>
        </div>

        <form action="" method="">
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
                        prst.setString(1, "Admin");
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
                                    + " <td><a href='ajoute_user?id=" + mat + "&value=delad'>"
                                    + "<img src='images/delete.png' width='25px' height='25px' style='margin-right:36px ' title='delete'></a>"
                                    + "<a  href='ajoute_user?id=" + mat + "&value=upad'><img src='images/Update.png' width='25px' height='25px' title='update'></a></td>"
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