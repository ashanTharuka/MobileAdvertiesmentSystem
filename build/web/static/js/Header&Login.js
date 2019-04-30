/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

//    //department-text toggle
//    $(".departments-text").click(function () {
//        $("#departments-list").slideToggle("fast");
//        //$("#departments-list").toggle();
//    });

    //phone slide
    $(".department-phones").hover(function () {
        $(".department-phones #department-brands").toggle();
    });
    $(".department-Tablets").hover(function () {
        $(".department-Tablets #department-brands").toggle();
    });
    $(".department-laptop").hover(function () {
        $(".department-laptop #department-brands").toggle();
    });
    $(".department-computer").hover(function () {
        $(".department-computer #department-brands").toggle();
    });
    $(".department-Camera").hover(function () {
        $(".department-Camera #department-brands").toggle();
    });
    $(".department-smartwatch").hover(function () {
        $(".department-smartwatch #department-brands").toggle();
    });
    $(".department-speaker").hover(function () {
        $(".department-speaker #department-brands").toggle();
    });
    $(".department-television").hover(function () {
        $(".department-television #department-brands").toggle();
    });
    $(".department-projector").hover(function () {
        $(".department-projector #department-brands").toggle();
    });
    $(".department-printer").hover(function () {
        $(".department-printer #department-brands").toggle();
    });
    $(".department-powerbank").hover(function () {
        $(".department-powerbank #department-brands").toggle();
    });


    //menu list up and down
    $("#menu-bar").click(function () {
        $(".departments-list1").toggle();
        $(".departments-list1").css("visibility", "visible");

    });


//////////////////////////////////////////Login/////////////////////////////////////////

//pop up forgot password
    $("#forgotLink").click(function () {
        $(".modal-content img").css("display", "block");
        $(".modal-body img").css("display", "none");
        $(".modal-title").css("display", "none");
        $("#forgotPassword").css("display", "block");
        $("#loging").css("display", "none");

    });
    $("#top-bar-links li:last-child").click(function () {

        $(".modal-content img").css("display", "none");
        $(".modal-body #loging img").css("display", "block");
        $(".modal-title").css("display", "block");
        $("#forgotPassword").css("display", "none");
        $("#loging").css("display", "block");

    });


});


