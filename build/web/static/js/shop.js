/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var tbl = $('#example1').DataTable();


    //get All data from database
    getAllData();
    function getAllData() {
        $.ajax({
            url: "getAllShops",
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                $('#example1').DataTable().clear().draw();
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];

                    tbl.row.add([myObj.shopName, myObj.ownerName,myObj.email,myObj.url]).draw();
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }


});

