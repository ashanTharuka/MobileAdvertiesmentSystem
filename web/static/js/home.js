/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {






    $('#login #loginBtn').click(function () {
        $("#login").submit(function (e) {
            e.preventDefault();
        });
        if ($("#login")[0].checkValidity()) {
            var email = $("#login #email").val();
            var password = $("#login #pwd").val();

            var myObj = {
                email: email,
                password: password

            };
            $.post("login", myObj, function (response) {

                console.log(response);

                if (response == "admin") {

                    document.forms[0].action = "Dashbord";
                    document.forms[0].submit();
                    $("#login #email").val("");
                    $("#login #pwd").val("");

                } else if (response == "shop") {
                    document.forms[0].action = "Customer_Dashbord";
                    document.forms[0].submit();
                    $("#login #email").val("");
                    $("#login #pwd").val("");
                } else if (response == "noOne") {
                    swal(
                            'No One Like That?',
                            'Please Register As Seller',
                            'warning'
                            )
                    $("#login #email").val("");
                    $("#login #pwd").val("");
                }

            });
        }
    });

    $('#for #forg').click(function () {
        $("#forg").submit(function (e) {
            e.preventDefault();
        });
        if ($("#forg")[0].checkValidity()) {
            var email = $("#for #email").val();


            var myObj = {
                email: email


            };
            $.post("forgotPass", myObj, function (response) {

                console.log(response);

                if (response === "success") {
                    swal(
                            'success!',
                            'You clicked the button!',
                            'success'
                            );
                } else if (response === "fail") {
                    swal(
                            'Oops...',
                            'Something went wrong!',
                            'error'
                            );
                }
                $("#for #email").val("");



            });
        }
    });




});
