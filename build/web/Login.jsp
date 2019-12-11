<%-- 
    Document   : identificationBB
    Created on : 20 avr. 2019, 18:38:10
    Author     : SAMSAM BILAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>


    <style>
        body {
            background-image: url("images/2.jpg")  ;
            background-position: center;
            background-size: cover;
            margin: 0;
            padding: 0;
        }
        #mat {
            background-color: #4b320377;
            padding-top: 10px;
            margin-top: 7%;
            width: 330px;
            height: 350px;
            /* border: 5px double black; */
            border-radius: 10px;
            -webkit-box-shadow: 10px 10px 10px 10px #212121;
            filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
            box-shadow: 10px 10px 10px  #212121;


        }
        input{
            -webkit-box-shadow: 7px 7px 7px #212121;
            filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
            box-shadow: 5px 5px 5px #212121;
            background-color: transparent;
            margin-bottom: 10px;
        }
        #form {
            align-content: center;
        }
        #matre {
            width: 220px;
            height: 30px;
            border-radius: 5px;
            padding-left: 10px;
            color: white; 
            border: solid 1px black;
            border: solid 1px rgb(209, 167, 167);
        }

        #connexion {
            width: 220px;
            height: 30px;
            border-radius: 5px;
            padding-left: 10px;
            border: solid 2px rgb(84, 87, 226);
            font-weight: bold;
            color: rgb(84, 87, 226);
            text-align: center;
            background-color: transparent;
        }
        #lab2 {
            color: rgb(219, 159, 159);
            size: 30px;
            font-weight: bold;
            text-shadow: 3px;
            font-weight: 30px;
        }
    </style>
</head>

<body>

    <center>
        
            <div id="mat">
                <form action="login" method="post" id="form">
                    <label id="lab1">
                        <h2 style="color:rgb(84, 87, 226)"> Bienvenue sur Votre Application de Gestion de Commande</h2>
                    </label> <br><br>
                    <label id="lab2"> Matriculation :</label> <br><br>
                    <input type="text" name="matr" id="matre" class="matr" pattern="^\d{6}$"
                           placeholder="Entrez Votre Matricule..."  required><br><br>
                     

                    <input type="submit" value="Connexion" id="connexion">
                </form>


            </div>
        <br><br><br><br>
    </center>
</body>

</html>