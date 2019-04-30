<%-- 
    Document   : Test
    Created on : Sep 19, 2017, 9:10:12 PM
    Author     : Ashan Tharuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>JSP Page</title>
        <script src="static/js/typeahead.js"></script>
        <link rel="stylesheet" href="static/css/specificationtype.css">



    </head>
    <body>
        <div id="the-basics">
            <input class="typeahead" type="text" placeholder="select MainCategory" id="name">
        </div>
    </body>
    <script>
        $(document).on("click", ".login__submit", function (e) {
            if (animating)
                return;
            animating = true;
            var that = this;
            ripple($(that), e);
            $(that).addClass("processing");
            setTimeout(function () {
                $(that).addClass("success");
                setTimeout(function () {
                    $app.show();
                    $app.css("top");
                    $app.addClass("active");
                }, submitPhase2 - 70);
                setTimeout(function () {
                    $login.hide();
                    $login.addClass("inactive");
                    animating = false;
                    $(that).removeClass("success processing");
                }, submitPhase2);
            }, submitPhase1);
        });
    </script>
</html>
