/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
//
//    var isJpg = function (name) {
//        return name.match(/jpg$/i)
//    };
//    var isPng = function (name) {
//        return name.match(/png$/i)
//    };
//    $("form #register-btn").click(function () {
//        $("#fileForm").submit(function (e) {
//            e.preventDefault();
//        });
//        
//        $.ajax({
//            url: "/register",
//            type: "POST",
//            data: new FormData($("#fileForm")[0]),
//            enctype: 'multipart/form-data',
//            processData: false,
//            contentType: false,
//            cache: false,
//            success: function () {
//                // Handle upload success
//                // 
//                alert("hari");
//                // ...
//            },
//            error: function () {
//                // Handle upload error
//                // ...
//                
//                alert("oops");
//            }
//
//
//
//        });
//
//    });


$(document).on('change', '.btn-file :file', function() {
  var input = $(this),
      numFiles = input.get(0).files ? input.get(0).files.length : 1,
      label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
  input.trigger('fileselect', [numFiles, label]);
});

$(document).ready( function() {
    $('.btn-file :file').on('fileselect', function(event, numFiles, label) {
        
        var input = $(this).parents('.input-group').find(':text'),
            log = numFiles > 1 ? numFiles + ' files selected' : label;
        
        if( input.length ) {
            input.val(log);
        } else {
            if( log ) alert(log);
        }
        
    });
});


});







