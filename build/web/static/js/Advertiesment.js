/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var tbl = $('#example1').DataTable();
//table row click
    $('#example1 tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
        var pos = tbl.row(this).index();
        var row = tbl.row(pos).data();
        $("#addForm #shopName").val(row[0]);
        $("#addForm #modelName").val(row[2]);
    });
    //get All data from database
    getAllData();
    function getAllData() {
        $.ajax({
            url: "AllAddBySearch",
            type: 'GET',
            dataType: 'json',
            success: function (response) {

                $('#example1').DataTable().clear().draw();
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    tbl.row.add([myObj.shopName, myObj.brandName, myObj.modelName, myObj.price]).draw();
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

//delete button
    $("#mainCategoryForm-buttonSet #btn-remove").click(function () {
        $("#addForm").submit(function (e) {
            e.preventDefault();
        });
        if ($("#addForm")[0].checkValidity()) {

            swal({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then(function () {

//
                var shop = $("#addForm #shopName").val();
                var model = $("#addForm #modelName").val();
                var myObj = {
                    shopName: shop,
                    modelName: model
                };
                $.post("deleteAddDetail", myObj, function (response) {
                    console.log(response);
                    if (response == "success") {
                        getAllData();
                        swal(
                                'Deleted!',
                                'You clicked the button!',
                                'success'
                                );
                    } else {
                        swal(
                                'Delete Fail...',
                                'Something went wrong!',
                                'error'
                                );
                    }
                    $("#addForm #shopName").val("");
                    $("#addForm #modelName").val("");
                });

            });
        }
    });
//
//           



});

