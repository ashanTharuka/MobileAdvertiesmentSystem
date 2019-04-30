<%-- 
    Document   : LogIn
    Created on : Sep 20, 2017, 3:50:19 AM
    Author     : Ashan Tharuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>tech.lk-Online Price Search</title>
        <link rel="icon" href="static/img/titleBarLogo.jpg" type="image/png">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="static/css/footer.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/img-picker.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/register.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>



        <div class="container">

            <div id="registerPageLogo">
                <img src="static/img/techLogo.png" class="img-responsive">
            </div>
            <div class="row">
                <div class="register">
                    <div class="row">
                        <form id="fileForm" action="register-shop" method="POST" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="name">Business logo </label>
                                <!--<div name="image" type="file" class="img-picker" ></div>-->
                                <!--<input type="file" name="image">-->
                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <span class="btn btn-primary btn-file">
                                            Browse&hellip; <input type="file" name="image" single>
                                        </span>
                                    </span>
                                    <input type="text" class="form-control" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name">Business owner name</label>
                                <input type="text" class="form-control collectes-ville text-center" name="oname" id="ownerName" placeholder="Enter owner name" required="">
                            </div>
                            <div class="form-group">
                                <label for="name">Business name</label>
                                <input type="text" class="form-control collectes-ville text-center" name="bname" id="shopName" placeholder="Enter business name" required="">
                            </div>
                            <div class="form-group">
                                <label for="email">Business email</label>
                                <input type="email" class="form-control collectes-ville text-center" name="be" id="email" placeholder="Enter business email">
                            </div>
                            <div class="form-group">
                                <label for="url">Business web site</label>
                                <input type="text" class="form-control collectes-ville text-center" name="web" id="url" placeholder="Enter business web site">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password</label>
                                <input type="password" class="form-control collectes-ville text-center" name="pwd" id="password1" placeholder="Enter password" required="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Re-enter password</label>
                                <input type="password" class="form-control collectes-ville text-center" id="password2" placeholder="Re-enter password" required="">
                            </div>
                            <div class="row">
                                <button type="submit" class="btn btn-primary " id="register-btn" >Register</button>
                            </div>                                          
                        </form>
                    </div>
                </div>
            </div>


        </div>






        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>





        <!--password and confirm password match-->
        <script>

            var password = document.getElementById("password1")
                    , confirm_password = document.getElementById("password2");

            function validatePassword() {
                if (password.value != confirm_password.value) {
                    confirm_password.setCustomValidity("Passwords Don't Match");
                } else {
                    confirm_password.setCustomValidity('');
                }
            }

            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;
        </script>
       
        <script src="static/js/Register.js"></script>
        <%@ include file="/static/Footer.jspf"%>
    </body>
</html>