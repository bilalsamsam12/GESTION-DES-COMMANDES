<%-- 
    Document   : navbar
    Created on : 30 avr. 2019, 09:25:55
    Author     : chagd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style> body {
                margin: 0;
                padding: 0;
            }

            ul {

                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            #img {
                position: absolute;
                top: 0.3%;
                left: 10px;
                border-radius: 20px;
                width: 300px;
                height: 45px;
                margin-bottom: 10px;
            }

            .navbar {
                margin-top: 0.3%;
                margin-left: 10px;
                margin-right: 10px;
                float: left;

            }
            .navba {
                margin-top: 0.3%;
                float: right;

            }

            #home {
                margin-left: 300px;
            }

            #time {
                float: right;
                margin-left: 10px;
                margin-right: 10px;
                margin-top: 0px;
            }

            li a,
            #time {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            #link {
                text-decoration: none;
                color: rgb(53, 143, 185);
            }

            #text {
                margin-left: 5px;
            }

            li a,
            .dropbtn {



                padding: 14px 16px;

            }



            .dropdown-content {
                display: none;
                margin-top: 0px;
                position: absolute;
                background-color: #21212155;
                width: 100px;

            }

            #dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;

            }


        </style>
    </head>
    <body>
        <nav id="nav">
            <form action="" method="">
                <ul>

                    <li><a href="Page_Chef.jsp" id="home" class="navbar">Acceuil</a></li>
                    <!--  <li id="dropdown" class="navbar">
                          <a href="javascript:void(0)" class="dropbtn" id="navbar1">Dropdown</a>
                          <div class="dropdown-content">
                              <a href="#">Link 1</a>
                              <a href="#">Link 2</a>
                              <a href="#">Link 3</a>
                          </div>
                      </li>
                      <li><a href="#home" class="navbar">Operation CRUD </a></li>
  
                      <li><a href="#contact" class="navbar">Contact</a></li>-->


                    <li><a href="Ajoute_users.jsp" class="navbar">Utilisateur </a></li>
                    <li><a href="Ajouter_produits.jsp" class="navbar">Produit </a></li>
                    <li><a href="Ajouter_admins.jsp" class="navbar">Admin </a></li>
                    <li><a href="Ajouter_fournisseur.jsp" class="navbar">Fournisseur </a></li>
                    
                    <li><a href="nous_contacter.jsp" class="navbar"> Nous Contacter</a></li>
              
                    <li ><a href="logout" class="navba">logout </a></li>
                    

                </ul>

                <div id="img"> <img src="images/safran.png" width="250px" height="45px "></div>


            </form>
        </nav>
    </body>
</html>
