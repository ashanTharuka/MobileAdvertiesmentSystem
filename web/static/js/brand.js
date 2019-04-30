$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    var tbl = $('#example1').DataTable();

//table row click
    $('#example1 tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
        var pos = tbl.row(this).index();
        var row = tbl.row(pos).data();

        $("#specificationTypeForm #id").val(row[0]);
        $("#specificationTypeForm #name").val(row[1]);
    });


//add button
    $("#specificationTypeForm #btn-add").click(function () {
        $("#specificationTypeForm").submit(function (e) {
            e.preventDefault();
        });
        if ($("#specificationTypeForm")[0].checkValidity()) {
            var mname = $("#specificationTypeForm #mname").val();
            var name = $("#specificationTypeForm #name").val();
            var myObj = {
                spName: name,
                mName: mname
            };
            $.post("addBrand", myObj, function (response) {
                if (response == "success") {
                    keyPressedFun();
                    getAllBrands();
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
                keyPressedFun();
                $("#specificationTypeForm #name").val("");
                $("#specificationTypeForm #id").val("");
            });
        }
    });

//update button
    $("#specificationTypeForm #btn-update").click(function () {
        $("#specificationTypeForm").submit(function (e) {
            e.preventDefault();
        });
        if ($("#specificationTypeForm")[0].checkValidity()) {
            var mname = $("#specificationTypeForm #mname").val();
            var id = $("#specificationTypeForm #id").val();
            var name = $("#specificationTypeForm #name").val();
            var myObj = {
                spId: id,
                spName: name,
                mName: mname
            };
            $.post("updateBrand", myObj, function (response) {
                if (response == "success") {
                    keyPressedFun();
                    swal(
                            'Updated!',
                            'You clicked the button!',
                            'success'
                            );
                } else {
                    swal(
                            'Update Fail...',
                            'Something went wrong!',
                            'error'
                            );
                }
                $("#specificationTypeForm #name").val("");
                $("#specificationTypeForm #id").val("");
            });
        }
    });
//delete button
    $("#specificationTypeForm #btn-delete").click(function () {

        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then(function () {
            $("#specificationTypeForm").submit(function (e) {
                e.preventDefault();
            });
            if ($("#specificationTypeForm")[0].checkValidity()) {
                var id = $("#specificationTypeForm #id").val();
                var myObj = {
                    id: id
                };
                $.post("deleteBrand", myObj, function (response) {
                    if (response == "success") {
                        keyPressedFun();
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
                    $("#specificationTypeForm #name").val("");
                    $("#specificationTypeForm #id").val("");
                });
            }
        })
    });

    //brand array
    var brandAr = [];

    //search bx data fill
    var states = [];
    getAllMainCategory();
    function getAllMainCategory() {
        $.ajax({
            url: "getAllMainCategory",
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                $('#example1').DataTable().clear().draw()
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];

                    states.push(myObj.mainCategoryName);
                }
            },
            error: function (error) {
                console.log('oops');
            }
        })
    }
    getAllBrands();
    function getAllBrands() {
        $.ajax({
            url: "getAllBrand",
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                $('#example1').DataTable().clear().draw()
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    
                    brandAr.push(myObj.brandName);
                }
            },
            error: function (error) {
                console.log('oops');
            }
        })
    }
//this function search and return relavant word from array,what we typing
    var substringMatcher = function (strs) {
        return function findMatches(q, cb) {
            var matches, substringRegex;
            // an array that will be populated with substring matches
            matches = [];
            // regex used to determine if a string contains the substring `q`
            substrRegex = new RegExp(q, 'i');
            // iterate through the pool of strings and for any string that
            // contains the substring `q`, add it to the `matches` array
            $.each(strs, function (i, str) {
                if (substrRegex.test(str)) {
                    matches.push(str);
                }
            });

            cb(matches);
        };
    };
    //mainCategory search box lib function
    $('#the-basics .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
            {
                name: 'states',
                source: substringMatcher(states)
            });
    //brand search box lib function
    $('#the-basicss-test .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
            {
                name: 'brandAr',
                source: substringMatcher(brandAr)
            });
//getall mainc to relavant mainCategory
    $("#mname").keyup(function () {
        keyPressedFun();
    });
   
//
//getall specifications to relavant mainCategory
       
        function keyPressedFun() {
            var mname = $("#specificationTypeForm #mname").val();
            var myObj = {
                mname: mname
            };
//
//        $.get("selectedSpecificationType", myObj, function (response) {
//            console.log(response);
//            })
            $.ajax({
                url: "selectedBrand",
                type: 'GET',
                dataType: 'json',
                data: myObj,
                success: function (response) {
                    brandAr.length=0;
                    console.log("res : " + response);
                    $('#example1').DataTable().clear().draw()
                    var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                    for (var index in jsonArray) {
                        var myObj = jsonArray[index];
                        console.log(myObj);
                        tbl.row.add([myObj.id, myObj.brandName]).draw();
                    }
                },
                error: function (error) {
                    console.log("oops!");
                }
            })
        }
    //hit enter key
//$(document).keypress(function(e) {
//    if(e.which == 13) {
//        alert('You pressed enter!');
//    }
});
