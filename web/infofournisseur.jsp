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
        <h1>L'ajoute d'un Fournisseur</h1>
        <div id="divo">
            <form method="post" action="ajoute_fourni">
                <label class="lab2">Matricule :</label>
                <input type="text"  class="inp" pattern="^\d{6}$" required name="matfo" /><br>
                <label class="lab2">Nom :</label>
                <input type="text" required class="inp" name="nomfo" />
                <label class="lab2">Prenom :</label>
                <input type="text" required class="inp"  name="prenomfo" /><br>
                <label class="lab2">Telephone :</label>
                <input type="text"  pattern="^[0-9]{10}$" required maxlength="10" name="telfo" class="inp"  />
                <label class="lab2">E-mail :</label>
                <input type="email" required class="inp"  name="emailfo" /><br>
                <label class="lab2">Adresse :</label>
                <input type="text" required  class="inpt"  name="addresfo" /><br>
                <% Connection con = MyConnection.getMyConnection();
                    PreparedStatement prst = con.prepareStatement("select * from produit");
                    int i=0;
                    ResultSet rst = prst.executeQuery();
                    while (rst.next()) {
                        int id = rst.getInt(1);
                        String nom = rst.getString(4);
                        String marque = rst.getString(2);
                        if(i%3==0){
                            out.println("<br>");
                            i=0;
                        }
                        i++;
                        %>
                        <input type="checkbox" name="produit"  value='<%=id%>' ><label class="lab0" name="name" > <%=nom%> <%=marque%></label> 
                 <%   }
                %>
                <br><input type="submit" value="Ajouter Fournisseur" id="inscre"  class="inp" />
            </form>
        </div>
        <form action="ajoute_fourni" method="get">
            <table border="2">
                <thead>
                    <tr>
                        <td>Matricule</td>
                        <td>Nom</td>
                        <td>Penom</td>
                        <td>Email</td>
                        <td>Telephone</td>
                        <td>Addresse</td>
                        <td>DU</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                          <%
                           con = MyConnection.getMyConnection();
                           prst = con.prepareStatement("select * from fourni");
                          
                           rst = prst.executeQuery();
                          while (rst.next()) {

                            int mat = rst.getInt(1);
                            String nom = rst.getString(2);
                            String prenom = rst.getString(3);
                            String email = rst.getString(4);
                            String tel = rst.getString(5);
                            String add = rst.getString(6);

                            out.println(
                                    "<tr> <td>" + mat + "</td>"
                                    + " <td>" + nom + "</td>"
                                    + " <td>" + prenom + "</td>"
                                    + " <td>" + email + "</td>"
                                    + " <td>" + tel + "</td>"
                                    + " <td>" + add + "</td>"
                                    + " <td><a href='ajoute_fourni?id="+mat+"&value=delf'>"
                                    + "<img src='images/delete.png' width='25px' height='25px' style='margin-right:36px ' title='delete'></a>"
                                    + "<a  href='ajoute_fourni?id="+mat+"&value=upf'><img src='images/Update.png' width='25px' height='25px' title='update'></a></td>"
                                  + "</tr>");
                      }%>
                </tbody>
            </table>
        </form>
    </center>
<%} else {
                                 request.getRequestDispatcher("Login.jsp").forward(request, response);
                             }%>
</body>

</html>