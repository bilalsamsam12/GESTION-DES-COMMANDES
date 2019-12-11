<%-- 
    Document   : updateuser
    Created on : 22 avr. 2019, 14:27:26
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

                background-image: url("images/3.jpg");


                margin: 0;
                padding: 0;
            }
            #link {
                text-decoration: none;
                color: rgb(53, 143, 185);
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

            li a,
            #time {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }
            ul {

                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            #img0 {
                position: absolute;
                top: 9px;
                left: 10px;
                border-radius: 20px;
                width: 300px;
                height: 45px;
                margin-bottom: 10px;
            }

            .navbar {
                margin-top: 9px;
                margin-left: 10px;
                margin-right: 10px;
                float: left;

            }

            #home {
                margin-left: 500px;
            }



            #div1 {
                background-color: #21212152;
                display: block;
                margin-left: auto;
                margin-right: auto;       
                width: 470px;
                height: 600px;
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
                margin-top: 7%;
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
                margin-bottom: 20px;
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
                font-size: 30px;
                
            }
        </style>


    </head>
    <body>
        <%@include file="border.jsp" %>
        <% if (session.getAttribute("mat") != null) {%>
        <%if (session.getAttribute("status").equals("Chef")) {%>
        <%@include file="navbar.jsp" %>
        <%} else if (session.getAttribute("status").equals("Admin")) {%>
        <%@include file="navbaradmin.jsp" %>

        <%}%>
    <center><h1>Modification </h1>

        <div id="div1">
            <form method="post" action="updateuser" name="f">

                <label id="lab2" >Matricule :</label>
                <input type="hidden"  name="matu"   value=<%=request.getAttribute("matup")%> > 
                <input type="text"  id="inp"     value=<%=request.getAttribute("matup")%>  disabled /><br>
                <label id="lab2">Nom :</label>
                <input type="text" value=<%=request.getAttribute("nomup")%> id="inp" name="nomu" required /><br>
                <label id="lab2">Prenom :</label>
                <input type="text" value=<%=request.getAttribute("prenomup")%> id="inp"   required  name="prenomu" /><br>
                <label id="lab2">Email :</label>
                <input type="email" value=<%=request.getAttribute("emailup")%> id="inp" required  name="emailu" /><br>
                <label id="lab2">Telephone:</label>
                <input type="tel" value=<%=request.getAttribute("telup")%> id="inp" required name="telu" pattern="^[0-9]{10}$" /><br>
                <label id="lab2">Programme:</label>
                <select id="select" required   name="programmeu">
                    <option value="--Choisir--" >--Choisir--</option>  
                    <%
                        String s = "";
                        String[] listprog ={"Boeing","Snecma","B 787","Leap","Rh","Finance","Maintenace","Airbus","Qualite","5X","Achat","Calibration","Dassault","It","Lean","Logistique","Turbomeca"};
                        for(int i=0;i<listprog.length;i++){
                            s="";
                            if(listprog[i].equals(request.getAttribute("programmeup"))){
                                s="selected";
                            }
                            %>
                            <option  value="<%=listprog[i]%>" <%=s%> ><%=listprog[i]%></option>
                    <%
                        }
                    %>
<!--                    <option value="Boeing" >Boeing</option>
                    <option value="Snecma">Snecma</option>
                    <option  value="B 787">B 787</option>
                    <option value="Leap">Leap</option>
                    <option value="Rh">Rh</option>
                    <option value="Finance"> Finance</option>
                    <option value="Maintenace">Maintenace</option>
                    <option value="Airbus"> Airbus</option>
                    <option    value="Qualite">Qualite</option>
                    <option    value="5X"> 5X</option>
                    <option    value="Achat">Achat</option>
                    <option     value="Calibration">Calibration</option>
                    <option        value="Dassault">Dassault</option>
                    <option    value="It">It</option>
                    <option    value="Lean">Lean</option>
                    <option        value="Logistique">Logistique</option>
                    <option        value="Turbomeca">Turbomeca</option>-->
                </select><br>
                <label id="lab2">Status :</label>
                <select name="statusu" id="select" required>
                     <%
                        String s1 = "";
                        String[] listprog1 ={"User","Admin"};
                        for(int i=0;i<listprog1.length;i++){
                            s1="";
                            if(listprog1[i].equals(request.getAttribute("statusup"))){
                                s1="selected";
                            }
                            %>
                            <option value="<%=listprog1[i]%>" <%=s1%> ><%=listprog1[i]%></option>
                    <%
                        }
                    %>
                </select><br>
                <input type="submit" value="modifier Utilisateur" id="inscre" />
            </form>
        </div>
    </center>
    <%} else {
         request.getRequestDispatcher("Login.jsp").forward(request, response);
     }%>
</body>
</html>
