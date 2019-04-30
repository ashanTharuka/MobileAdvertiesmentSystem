/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    var tbl = $('#example1').DataTable();

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
    $("#modelForm #mainCategoryName").keyup(function () {
        getAllBrands();
    });
    function getAllBrands() {
        var mname = $("#modelForm #mainCategoryName").val();
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
    $("#brandName").keyup(function () {
        getAllData();
    });















///////////////////////////////// img picker////////////////////////////////////////////////
    $(document).on('change', '.btn-file :file', function () {
        var input = $(this),
                numFiles = input.get(0).files ? input.get(0).files.length : 1,
                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
        input.trigger('fileselect', [numFiles, label]);
    });

    $(document).ready(function () {
        $('.btn-file :file').on('fileselect', function (event, numFiles, label) {

            var input = $(this).parents('.input-group').find(':text'),
                    log = numFiles > 1 ? numFiles + ' files selected' : label;

            if (input.length) {
                input.val(log);
            } else {
                if (log)
                    alert(log);
            }

        });
    });



    function getAllData() {
        var mname = $("#brandName").val();
        var myObj = {
            mname: mname
        };
        $.ajax({
            url: "selectedModel",
            type: 'GET',
            data: myObj,
            dataType: 'json',
            success: function (response) {

                $('#example1').DataTable().clear().draw();
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    tbl.row.add([myObj.modelId, myObj.modelName_1]).draw();
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

getAllFirstTime();
//getAll models first time
    function getAllFirstTime() {

        $.ajax({
            url: "getAllModel",
            type: 'GET',
            dataType: 'json',
            success: function (response) {

                $('#example1').DataTable().clear().draw();
                var jsonArray = jQuery.parseJSON(JSON.stringify(response));
                for (var index in jsonArray) {
                    var myObj = jsonArray[index];
                    tbl.row.add([myObj.modelId, myObj.modelName_1]).draw();
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
    }


});

