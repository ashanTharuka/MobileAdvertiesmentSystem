/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    var tbl = $('#example1').DataTable();


    var states = [];
    getAllMainCategory();
    function getAllMainCategory() {
        $.ajax({
            url: "getAllMainCategory",
            type: 'GET',
            dataType: 'json',
            success: function (response) {
                $('#example1').DataTable().clear().draw();
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


    $("#brandName").keyup(function () {
        keyPressedFun2();
    });
    $("#mainCategoryName").keyup(function () {
        getAllBrands();
    });

    function getAllBrands() {
        var mname = $("#specificationTypeForm #mainCategoryName").val();
//        alert(mname);
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
                    console.log(myObj.brandName);
                    brandAr.push(myObj.brandName);
                }
            },
            error: function (error) {
                console.log('oops');
            }
        });
    }
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


    $('#specificationTypeForm .rad').on('change', function () {
        var val = $('input[name=war]:checked', '#specificationTypeForm').val();

        if (val === "company") {
            $("#month1").css("visibility", "visible");
            $("#price1").css("visibility", "visible");
            $("#month1").val("");
            $("#price1").val("");
            $("#month2").css("visibility", "hidden");
            $("#price2").css("visibility", "hidden");
        } else if (val === "seller") {
            $("#month1").css("visibility", "hidden");
            $("#price1").css("visibility", "hidden");
            $("#month2").css("visibility", "visible");
            $("#price2").css("visibility", "visible");

            $("#month2").val("");
            $("#price2").val("");

        }


    });



    $("#specificationTypeForm #add-btn").click(function () {
        $("#specificationTypeForm").submit(function (e) {
            e.preventDefault();
        });
        var val = $('input[name=war]:checked', '#specificationTypeForm').val();
        var shop = $("#shopD").val();
        var mName = $("#specificationTypeForm #modelName").val();
        var mColor = $("#specificationTypeForm #modelColor").val();
        var price = $("#specificationTypeForm #price").val();
        var warrantyType = $('input[name=war]:checked', '#specificationTypeForm').val();
        var month = "";
        var mPrice = "";

        if (val === "company") {
            month = $("#month1").val()();
            mPrice = $("#price1").val();
        } else if (val === "seller") {
            month = $("#month2").val();
            mPrice = $("#price2").val();
        }



        var myObj = {
            s: shop,
            m: mName,
            c: mColor,
            p: price,
            wa: warrantyType,
            mo: month,
            mp: mPrice

        };

        $.post("addAdddvertiesment", myObj, function (response) {
            console.log("RESPONCE : " + response);
            if (response === "success") {

                swal(
                        'Added!',
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
            $("#specificationTypeForm #modelName").val("");
            $("#specificationTypeForm #modelColor").val("");
        });

    });

    //get All CustomerAdds from database
    getAllData();
    function getAllData() {
       var shop=$("#shopD").val();
        var myObj = {
            shopName: shop

        };
        $.ajax({
            url: "getAllAddsByShop",
            type: 'POST',
            data: myObj,
            dataType: 'json',
            success: function (response) {
                $('#example1').DataTable().clear().draw();
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    tbl.row.add([myObj.modelName, myObj.color, myObj.price]).draw();
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }



});
