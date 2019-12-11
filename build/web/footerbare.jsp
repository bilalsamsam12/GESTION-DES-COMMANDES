<%-- 
    Document   : footerbare
    Created on : 18 avr. 2019, 10:45:39
    Author     : SAMSAM BILAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style> 
            #im {
                width: 100%;
                height: 150px;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                border-top-left-radius: 5px;
                border-top-right-radius: 5px;
                -webkit-box-shadow: 0px 0px 5px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 0px 0px 5px #212121;


            }

            #footer { 
                width: 100%;
                height: 400px;
                background-color: #00000095;
                padding: 0;
                position: relative;


            }

            #foot {
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                border-top-left-radius: 5px;
                border-top-right-radius: 5px;
                margin-top: 0.5%;
                margin-left: 5%;
                background-color: #ffffff99;
                width: 13%;
                height: 90%;
                float: left;
                -webkit-box-shadow: 7px 7px 7px #212121;
                filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);
                box-shadow: 7px 7px 7px #212121;

            }</style>
    </head>
    <body>
        <footer id="footer">
            <div id="foot">
                <img id="im" src="images/1.jpg" width="250px" height="45px ">
                <div id="text">
                    <p>Text messaging, or texting, is the act of composing and sending electronic messages, typically
                        consisting of alphabetic and numeric characters, between two or more users of mobile devices.
                        <br> <a href="#" id="link">voir plus...</a>
                    </p>

                </div>

            </div>
            <div id="foot">
                <img src="images/5.jpg" width="250px" height="45px " id="im">
                <div id="text">
                    <p>Text messaging, or texting, is the act of composing and sending electronic messages, typically
                        consisting of alphabetic and numeric characters, between two or more users of mobile devices.
                        <br> <a href="www.google.com" id="link">voir plus...</a>
                    </p>
                </div>
            </div>
            <div id="foot">
                <img src="images/aerobus.jpg" width="250px" height="45px " id="im">
                <div id="text">
                    <p>Text messaging, or texting, is the act of composing and sending electronic messages, typically
                        consisting of alphabetic and numeric characters, between two or more users of mobile devices.
                        <br> <a href="#" id="link">voir plus...</a>
                    </p>
                </div>
            </div>
            <div id="foot">
                <img src="images/boeing.jpg" width="250px" height="45px " id="im">
                <div id="text">
                    <p>Text messaging, or texting, is the act of composing and sending electronic messages, typically
                        consisting of alphabetic and numeric characters, between two or more users of mobile devices.
                        <br> <a href="#" id="link">voir plus...</a>
                    </p>
                </div>
            </div>
            <div id="foot">
                <img src="images/matis1.jpg" width="250px" height="45px " id="im">
                <div id="text">
                    <p id="text">Text messaging, or texting, is the act of composing and sending electronic messages,
                        typically
                        consisting of alphabetic and numeric characters, between two or more users of mobile devices.
                        <br> <a href="#" id="link">voir plus...</a>
                    </p>
                </div>
            </div>

        </footer>
    </body>
</html>
