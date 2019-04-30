<%-- 
    Document   : AdminDashBoard
    Created on : Sep 18, 2017, 1:04:06 AM
    Author     : Ashan Tharuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title>tech.lk-Online Price Search</title>
        <link rel="icon" href="static/img/titleBarLogo.jpg" type="image/png">
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.9.1/sweetalert2.min.css">
        <link rel="stylesheet" href="static/css/bootstrap.min.css">
        <link rel="stylesheet" href="static/css/font-awesome.min.css">
        <link rel="stylesheet" href="static/css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="static/css/AdminLTE.min.css">
        <link rel="stylesheet" href="static/css/model.css">
              <link rel="stylesheet" href="static/css/_all-skins.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">






    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <%

            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            String id = (String) session.getAttribute("adminId");
            if (name == null && email == null && id == null) {

                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/HomePage.jsp"));
            }
        %>
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="index2.html" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>A</b>LT</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Admin</b>Console</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Messages: style can be found in dropdown.less-->
                            <li class="dropdown messages-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">


                                </a>

                            </li>
                            <!-- Notifications: style can be found in dropdown.less -->

                            <!-- Tasks: style can be found in dropdown.less -->
                            <li class="dropdown tasks-menu">
                                <a href="HomePage.jsp" >
                                    <i class="glyphicon glyphicon-home"></i>

                                </a>

                            </li>
                            <!-- User Account: style can be found in dropdown.less -->
                            </li>
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="static/img/userLogIn.png" class="user-image" alt="User Image">
                                    <span class="hidden-xs"> <%=name%></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="static/img/admin.png" class="img-circle" alt="User Image">

                                        <p>
                                            <%=name%>
                                            <small>Admin</small>
                                        </p>
                                    </li>
                                    <!-- Menu Body -->

                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="#" onclick="Admin()" class="btn btn-default btn-flat">Profile</a>
                                        </div>
                                        <div class="pull-right">
                                            <a id="woow" href="#" class="btn btn-default btn-flat">Sign out</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!-- Control Sidebar Toggle Button -->

                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->

                    <!-- search form -->

                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">MAIN NAVIGATION</li>
                        <li class=" treeview">
                            <a href="#" onclick="Dashbord()">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>

                            </a>

                        </li>
                        <li class=" treeview">
                            <a href="#" onclick='Pendding()'>
                                <i class="fa fa-files-o"></i>
                                <span>Pendding</span>

                            </a>

                        </li>
                        <li class=" treeview">
                            <a href="#"  onclick='MainCategory()'>
                                <i class="fa fa-th"></i>
                                <span>MainCategory</span>

                            </a>
                        </li>

                        <li class="treeview">

                            <a href="#" onclick='SpecificationType()'>
                                <i class="fa fa-pie-chart"></i>
                                <span>Specification Type</span>

                            </a>


                        </li>



                        <li class="treeview">
                            <a href="#" onclick='Brand()'>
                                <i class="fa fa-laptop"></i>
                                <span>Brand</span>

                            </a>

                        </li>
                        <li class="active treeview">
                            <a href="#" onclick='Model()'>
                                <i class="fa fa-edit"></i>
                                <span>Model</span>

                            </a>

                        </li>
                        <li class="treeview">
                            <a href="#" onclick='Specification()'>
                                <i class="fa fa-table"></i>
                                <span>Specification</span>

                            </a>

                        </li>
                        <li>
                            <a href="#" onclick='Advertiesment()'>
                                <i class="fa fa-calendar"></i> 
                                <span>Advertiesment</span>

                            </a>
                        </li>
                        <li>
                            <a href="#" onclick='Shop()'>
                                <i class="fa fa-envelope"></i> 
                                <span>Shop</span>

                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#" onclick='Admin()'>
                                <i class="fa fa-folder"></i> 
                                <span>Admin</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#" >
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class=""></i> 
                                <span></span>
                            </a>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Model
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Model</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="box">
                         <!--/.box-header--> 
                        <div class="box-body">
                            <div class="row" >
                                <div class="col-md-12">
                                    <form style="display: none"></form>
                                    <form id="modelForm" method="POST" action="addModel" enctype="multipart/form-data">
                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-md-2"></div>
                                                <div class="col-md-3">
                                                    <label for="name">MainCategory Name:</label>
                                                    <div id="the-basics">
                                                        <input type="text" class="form-control typeahead" id="mainCategoryName" name="mname" placeholder="select MainCategory"  required>
                                                    </div>
                                                </div>
                                                <div class="col-md-1"></div>
                                                <div class="col-md-3">
                                                    <label for="name">Brand Name:</label>
                                                    <div id="the-basicss-test">
                                                        <input type="text" class="form-control typeahead" id="brandName" name="bname"  placeholder="select Brands"  required>
                                                    </div>
                                                </div>
                                                <div class="col-md-2"></div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-md-2"></div>
                                                <div class="col-md-3">
                                                    <label for="name">Model Name 1:</label>
                                                    <input type="text" class="form-control modelInput" id="modelName1" name="mn1name"  required>
                                                    <input type="text" class="form-control modelInput" id="modelName1Id" style="display: none">
                                                </div>
                                                <div class="col-md-1"></div>
                                                <div class="col-md-3">
                                                    <label for="name">Model Name 2:</label>
                                                    <input type="text" class="form-control modelInput" id="modelName1" name="mn2name"  required>
                                                </div>
                                                <div class="col-md-2"></div>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-md-2"></div>
                                                <div class="col-md-3">
                                                    <label for="name">specialCategory Name:</label>
                                                    <input type="text" class="form-control modelInput" id="modelName1" name="sName" pattern="[a-zA-Z ]*$" required>
                                                </div>
                                                <div class="col-md-1"></div>
                                                <div class="col-md-3">
                                                    <label for="name">Model YEAR:</label>
                                                    <input type="text" class="form-control modelInput" id="modelName1"  name="myname" pattern="[0-9]{4}"  required>
                                                </div>
                                                <div class="col-md-2"></div>
                                            </div>

                                        </div>

                                        <br>
                                        <br>


                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-md-3"></div>
                                                <div class="col-md-2">
                                                    <div class="input-group">
                                                        <span class="input-group-btn">
                                                            <span class="btn btn-primary btn-file">
                                                                Browse&hellip; <input type="file" name="file" single>
                                                            </span>
                                                        </span>
                                                        <input type="text" class="form-control" readonly>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="input-group">
                                                        <span class="input-group-btn">
                                                            <span class="btn btn-primary btn-file">
                                                                Browse&hellip; <input type="file" name="file" single>
                                                            </span>
                                                        </span>
                                                        <input type="text" class="form-control" readonly>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="input-group">
                                                        <span class="input-group-btn">
                                                            <span class="btn btn-primary btn-file">
                                                                Browse&hellip; <input type="file" name="file" single>
                                                            </span>
                                                        </span>
                                                        <input type="text" class="form-control" readonly>
                                                    </div>
                                                </div>
                                                <div class="col-md-2"></div>
                                            </div>
                                        </div>

                                        <br>
                                        <hr>
                                        <div class="row" id="buttonSet">
                                            <div class="col-md-3"></div>
                                            <div class="col-md-2">
                                                <button type="submit"  class="btn btn-primary" id="add-btn">Add</button>
                                            </div>
                                            <div class="col-md-2">
                                                <button type="submit"  class="btn btn-primary" id="update-btn">Update</button>
                                            </div>
                                            <div class="col-md-2">
                                                <button type="submit"  class="btn btn-primary" id="delete-btn">Delete</button>
                                            </div>
                                            <div class="col-md-2"></div>
                                        </div>
                                    </form>
                                                                        ${ans}
                                </div>

                            </div>



                            <div class="row" id="model-table">
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr role="row">
                                                <th class="" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" style="text-align: center">Model Id</th>
                                                <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" style="text-align: center" aria-label="Browser: activate to sort column ascending">Model Name</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>

                                    </table>
                                </div>
                            </div>






                        </div>
                    </div>
                </section>

            </div>
            <!-- /.content-wrapper -->
            <footer class="main-footer">

                <strong>© 2017 ashan tharuka. All rights reserved </strong> 
            </footer>

            <!-- Control Sidebar -->

            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->


        <script>
            function SpecificationType() {
                document.forms[0].action = "SpecificationType";
                document.forms[0].submit();
            }
            function Pendding() {
                document.forms[0].action = "Pendding";
                document.forms[0].submit();
            }
            function Brand() {
                document.forms[0].action = "Brand";
                document.forms[0].submit();
            }
            function Model() {
                document.forms[0].action = "Model";
                document.forms[0].submit();
            }
            function Specification() {
                document.forms[0].action = "Specification";
                document.forms[0].submit();
            }
            function Advertiesment() {
                document.forms[0].action = "Advertiesment";
                document.forms[0].submit();
            }
            function Shop() {
                document.forms[0].action = "Shop";
                document.forms[0].submit();
            }
            function Admin() {
                document.forms[0].action = "Admin";
                document.forms[0].submit();
            }
            function MainCategory() {
                document.forms[0].action = "MainCategory";
                document.forms[0].submit();
            }

            function Dashbord() {
                document.forms[0].action = "Dashbord";
                document.forms[0].submit();
            }
        </script>

        <script src="static/js/jquery.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/jquery.dataTables.min.js"></script>
        <script src="static/js/dataTables.bootstrap.min.js"></script>
        <script src="static/js/adminlte.min.js"></script>
        <script src="static/js/model.js"></script>
        <!--<script src="static/js/handlebars.js"></script>-->
        <script src="static/js/typeahead.bundle.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.9.1/sweetalert2.min.js"></script>
        <script src="static/js/sessionDelete.js"></script>
        
    </body>
</html>
