<%-- 
    Document   : index
    Created on : 9 mai 2019, 13:17:09
    Author     : SAMSAM BILAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="bootstrap/bootstrap.min.js"></script>
        <script src="bootstrap/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <style>
            body{
                background-image: url("images/3.jpg");
            }
            .contact{
                padding: 4%;
                height: 400px;
            }
            .col-md-3{
                background: #ff9b00;
                padding: 4%;
                border-top-left-radius: 0.5rem;
                border-bottom-left-radius: 0.5rem;
            }
            .contact-info{
                margin-top:10%;
            }
            .contact-info img{
                margin-bottom: 15%;
            }
            .contact-info h2{
                margin-bottom: 10%;
            }
            .col-md-9{
                background: #fff;
                padding: 3%;
                border-top-right-radius: 0.5rem;
                border-bottom-right-radius: 0.5rem;
            }
            .contact-form label{
                font-weight:600;
            }
            .contact-form button{
                background: #25274d;
                color: #fff;
                font-weight: 600;
                width: 25%;
            }
            .contact-form button:focus{
                box-shadow:none;
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
      
    <center> <form action="SendEmail" method="post">
            <div class="container contact">
                <div class="row">
                    <div class="col-md-3">
                        <div class="contact-info">
                            <img src="images/contact.png" alt="image"/>
                            <h2>Contact Us</h2>
                            <h4>Nous sommes à l'écoute</h4>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="contact-form">



                            <div class="form-group">
                                <label class="control-label col-sm-2" for="fname">Sujet:</label>
                                <div class="col-sm-10">          
                                    <input type="text" class="form-control" id="fname" placeholder="Enter Sujet" name="sujet">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="comment">Message:</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" id="comment" name="message"></textarea>
                                </div>
                            </div>
                            <div class="form-group">        
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">Envoyer</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form></center>  
        <%} else {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }%>
</body>
</html>
