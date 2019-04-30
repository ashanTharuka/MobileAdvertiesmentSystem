/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    
    
     $("#woow").click(function () {

        var myObj = {
            name: "test"

        };
        $.get("sessionDeleteShop", myObj, function (response) {
            console.log(response);
            if (response == "success") {
                window.location.href = 'HomePage.jsp';
            } else if (response == "fail") {
                alert("oops");
            }

        });
    });
    
    
});
