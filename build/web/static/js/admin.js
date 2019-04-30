/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {




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


    ////////////////////////////////////////////////////////////////////

//update button
    $("#btn-update").click(function () {
        $("#adminForm").submit(function (e) {
            e.preventDefault();
        });
        if ($("#adminForm")[0].checkValidity()) {
            var id = $("#adminForm #id").val();
            var name = $("#adminForm #name").val();
            var email = $("#adminForm #email").val();
            var password = $("#adminForm #password2").val();
            var myObj = {
                id: id,
                name: name,
                email: email,
                password: password
            };
            ~
                    $.post("updateAdmin", myObj, function (response) {
                        if (response == "success") {

                            swal(
                                    'Updated!',
                                    'You clicked the button!',
                                    'success'
                                    );
                        } else if (response == "fail") {
                            swal(
                                    'Update Fail...',
                                    'Something went wrong!',
                                    'error'
                                    );
                        }
                        $("#adminForm #id").val("");
                        $("#adminForm #name").val("");
                        $("#adminForm #email").val("");
                        $("#adminForm #password1").val("");
                        $("#adminForm #password2").val("");
                    });
        }
    });


});


