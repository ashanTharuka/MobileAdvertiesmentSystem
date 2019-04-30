/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    var states = [];

    getAllTown();
    function getAllTown() {
        $.ajax({
            url: "getAllTown",
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                  
                    states.push(myObj.townName);

                }
            },
            error: function (error) {
                console.log('oops');
            }
        });
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






    $('#the-basics .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
            {
                name: 'states',
                source: substringMatcher(states)
            });

    //add button
    $("#branchForm #add-btn").click(function () {
        $("#branchForm").submit(function (e) {
            e.preventDefault();
        });
        if ($("#branchForm")[0].checkValidity()) {
            var id = $("#branchForm #id").val();
            var add1 = $("#branchForm #add1").val();
            var add2 = $("#branchForm #add2").val();
            var city = $("#branchForm #city").val();
            var tel1 = $("#branchForm #tel1").val();
            var tel2 = $("#branchForm #tel2").val();
            var myObj = {
                id: id,
                add1: add1,
                add2: add2,
                city: city,
                tel1: tel1,
                tel2: tel2
            };
            $.post("addBranch", myObj, function (response) {
                getAllBranch();
                if (response == "success") {
                   
                  
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

                $("#branchForm #city").val("");
                $("#branchForm #id").val("");
            });
        }
    });
getAllBranch();

    function  getAllBranch() {
        $.ajax({
            url: "getAllBranch",
            type: 'GET',
            dataType: 'json',
            success: function (response) {
           
                $('#example1').DataTable().clear().draw()
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    console.log(myObj);
                    tbl.row.add([myObj.branchId, myObj.city,myObj.tel1,myObj.tel2]).draw();
                }
            },
            error: function (error) {
                console.log("oops!");
            }
        });
    }
    ;

});