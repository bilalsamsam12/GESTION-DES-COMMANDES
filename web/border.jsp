<%-- 
    Document   : border
    Created on : 20 avr. 2019, 19:59:11
    Author     : SAMSAM BILAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #div11{

                border: solid 1px black;
                width: 20%;
                height: 45%;
                position: absolute;
                top:15%;
                border-radius: 10px;
                -webkit-box-shadow: 10px 10px 10px 10px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 10px 10px 10px #212121;
            }
            #div2 {
                margin-top: -109px;
                text-align: center;
                margin-left: 90px;         
                padding-right: auto;


            }

            .label {
                font-weight: bold;
                color: aliceblue;
                text-align: center;
                line-height: 2em;
                font-family: Georgia, 'Times New Roman', Times, serif;


            }

            .label1 {
                color: aliceblue;
                text-align: center;
                font-weight: bold;
                line-height: 2.5em;
                font-family: Georgia, 'Times New Roman', Times, serif;
            }

            #div3 {

                margin-top: 15px;
                height: 100px;

            }

            #img1 {
                width: 40%;
                height: 40%;
                border-radius: 10px;
            }

            #statut {
                padding-top: 5px;
            }
        </style>
    </head>
    <body>
        <div id="div11">
            <img id="img1" src="images/user.png">
            <div id="div2">
                <center> <label id="statut" class="label" name="status"><%=session.getAttribute("status")%> </label><br>
                    <label class="label" name="prenom"><%=session.getAttribute("prenom")%>  </label><br>
                    <label class="label" name="nom"><%=session.getAttribute("nom")%> </label><br></center>
            </div>
            <div id="div3">
                <center> <label class="label1" name="email"><%=session.getAttribute("email")%>  </label><br>
                    <label class="label1" name="tel"><%=session.getAttribute("tel")%>  </label><br>
                    <label class="label1" name="programme"><%=session.getAttribute("programme")%>  </label><br>
                    <label class="label1" name="matricule"><%=session.getAttribute("mat")%>  </label></center>
            </div>
        </div>
    </body>
</html>
