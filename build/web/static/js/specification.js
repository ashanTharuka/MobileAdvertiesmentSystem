$(document).ready(function () {
    var tbl = $('#example1').DataTable();

//table row click
    $('#example1 tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
        var pos = tbl.row(this).index();
        var row = tbl.row(pos).data();

        $("#specification-sub #id").val(row[0]);
        $("#specification-sub #specType").val(row[1]);
        $("#specification-sub #specdesc").val(row[2]);
    });


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
    var brandAr = [];
    var modelAr = [];


    function getAllBrands() {
        var mname = $("#specificationTypeForm #mainCategoryName").val();
        var myObj = {
            mname: mname
        };
        $.ajax({
            url: "selectedBrand",
            type: 'GET',
            data: myObj,
            dataType: 'json',
            success: function (response) {
                brandAr.length = 0;
//                $('#example1').DataTable().clear().draw()
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];

                    brandAr.push(myObj.brandName);
                }
            },
            error: function (error) {
                console.log('oops');
            }
        });
    }

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
    //model suggestion
    $('#the-basicss-model .typeahead').typeahead({
        hint: true,
        highlight: true,
        minLength: 1
    },
            {
                name: 'modelAr',
                source: substringMatcher(modelAr)
            });

    $("#mainCategoryName").keyup(function () {
        getAllBrands();
    });
    $("#brandName").keyup(function () {
        keyPressedFun2();
    });
    $("#modelName").keyup(function () {
        keyPressedFunSpe();
    });
    function keyPressedFun2() {
        var mname = $("#specificationTypeForm #brandName").val();
        var myObj = {
            mname: mname
        };

        $.ajax({
            url: "selectedModel",
            type: 'GET',
            dataType: 'json',
            data: myObj,
            success: function (response) {
                modelAr.length = 0;
                console.log("res : " + response);
//                    $('#example1').DataTable().clear().draw()
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    modelAr.push(myObj.modelName_1);
                }
            },
            error: function (error) {
                console.log("oops!");
            }
        });
    }


    function keyPressedFunSpe() {
        var mname = $("#specificationTypeForm #modelName").val();
        var myObj = {
            mname: mname
        };

        $.ajax({
            url: "getSpecifications",
            type: 'GET',
            dataType: 'json',
            data: myObj,
            success: function (response) {
                modelAr.length = 0;

                $('#example1').DataTable().clear().draw();
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    console.log("print : " + myObj.specificationId, myObj.spcificationName, myObj.specificationDescription);
                 
                    tbl.row.add([myObj.specificationId, myObj.spcificationName, myObj.specificationDescription]).draw();
                }
            },
            error: function (error) {
                console.log("oops!");
            }
        });
    }

    $("#btn-update").click(function () {
        $("#specification-sub").submit(function (e) {
            e.preventDefault();
        });
        var id = $("#specification-sub #id").val();
        var desc = $("#specification-sub #specdesc").val();
        var myObj = {
            id: id,
            desc: desc
        };

        $.post("updateSpec", myObj, function (response) {

            if (response === "success") {
                keyPressedFunSpe();
                swal(
                        'Updated!',
                        'You clicked the button!',
                        'success'
                        );
            } else {
                swal(
                        'Oops...',
                        'Something went wrong!',
                        'error'
                        );
            }
            $("#specification-sub #specdesc").val("");
            $("#specification-sub #id").val("");


        });
    });








});
