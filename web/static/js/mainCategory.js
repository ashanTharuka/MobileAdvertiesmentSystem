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

        $("#mainCategoryForm #id").val(row[0]);
        $("#mainCategoryForm #name").val(row[1]);
    });





//add button
    $("#mainCategoryForm #btn-add").click(function () {
        $("#mainCategoryForm").submit(function (e) {
            e.preventDefault();
        });
        if ($("#mainCategoryForm")[0].checkValidity()) {
            var name = $("#mainCategoryForm #name").val();
            var myObj = {
                name: name
            };
            $.post("addMainCategory", myObj, function (response) {
                if (response == "success") {

                    getAllData();
                    swal(
                            'Added!',
                            'You clicked the button!',
                            'success'
                            );
                } else if (response == "exist") {
                    swal(
                            'Already Exist!',
                            'Try Different One',
                            'info'
                            );
                } else {
                    swal(
                            'Oops...',
                            'Something went wrong!',
                            'error'
                            );
                }
                $("#mainCategoryForm #name").val("");
                $("#mainCategoryForm #id").val("");
            });
        }
    });
//update button
    $("#mainCategoryForm #btn-update").click(function () {
        $("#mainCategoryForm").submit(function (e) {
            e.preventDefault();
        });
        if ($("#mainCategoryForm")[0].checkValidity()) {
            var name = $("#mainCategoryForm #name").val();
            var id = $("#mainCategoryForm #id").val();
            var myObj = {
                id: id,
                name: name
            };
            $.post("updateMainCategory", myObj, function (response) {
                if (response == "success") {

                    getAllData();
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
                $("#mainCategoryForm #name").val("");
                $("#mainCategoryForm #id").val("");
            });
        }
    });
//delete button
    $("#mainCategoryForm #btn-delete").click(function () {
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then(function () {
            $("#mainCategoryForm").submit(function (e) {
                e.preventDefault();
            });
            if ($("#mainCategoryForm")[0].checkValidity()) {

                var id = $("#mainCategoryForm #id").val();
                var myObj = {
                    id: id
                };
                $.post("deleteMainCategory", myObj, function (response) {
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
                    $("#mainCategoryForm #name").val("");
                    $("#mainCategoryForm #id").val("");
                });
            }
        })


    });


    //get All data from database
    getAllData();
    function getAllData() {
        $.ajax({
            url: "getAllMainCategory",
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                $('#example1').DataTable().clear().draw()
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];

                    tbl.row.add([myObj.id, myObj.mainCategoryName]).draw();
                }
            },
            error: function (error) {
                console.log('oops');
            }
        })
    }


});

