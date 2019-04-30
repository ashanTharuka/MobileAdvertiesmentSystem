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
        <link rel="stylesheet" href="static/css/_all-skins.min.css">
        <link rel="stylesheet" href="static/css/customerShop.css">
        <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <%

            String shop = (String) session.getAttribute("shop");
            String path = (String) session.getAttribute("path");
            String url = (String) session.getAttribute("url");
            String email = (String) session.getAttribute("email");
            String id=(String) session.getAttribute("id");
            if (shop == null) {

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
                    <span class="logo-lg"><b>Seller</b>Console</span>
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
                                    <img src="${path}" class="user-image" alt="">
                                    <span class="hidden-xs"><%=shop%></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="${path}" class="img-circle" alt="User Image">

                                        <p>
                                            <%=shop%>
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

                        <li class="active treeview">
                            <a href="#"  onclick='Shop()'>
                                <i class="fa fa-th"></i>
                                <span>Shop</span>

                            </a>
                        </li>

                        <li class="treeview">

                            <a href="#" onclick='Branch()'>
                                <i class="fa fa-pie-chart"></i>
                                <span>Branch </span>

                            </a>


                        </li>



                        <li class="treeview">
                            <a href="#" onclick='Advertiesment()'>
                                <i class="fa fa-laptop"></i>
                                <span>Advertiesment</span>

                            </a>

                        </li>
                        <li class="treeview">
                            <a href="#" >
                                <i class=""></i>
                                <span></span>

                            </a>

                        </li>
                        <li class="treeview">
                            <a href="#" >
                                <i class=""></i>
                                <span></span>

                            </a>

                        </li>
                        <li>
                            <a href="#" >
                                <i class=""></i> 
                                <span></span>

                            </a>
                        </li>
                        <li>
                            <a href="#" >
                                <i class=""></i> 
                                <span></span>

                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#" >
                                <i class=""></i> 
                                <span></span>
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
                        Shop
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Shop</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="box">
                        <!-- /.box-header -->
                        <div class="box-body"  id="specificationTypeForm">
                            <div class="row" >
                                <div class="col-md-12">
                                    <form style="display: none">

                                    </form>

                                </div>

                            </div>


                            <div class="row" >
                                <div class="col-md-4"></div>
                                <div class="col-md-4">

                                    <img src="${path}" class="img-responsive" width="100px" style="margin:0 auto" >
                                    <form id="adminForm"  action="update-shop" method="POST" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-btn">
                                                    <span class="btn btn-primary btn-file">
                                                        Browse&hellip; <input type="file" name="image" single>
                                                    </span>
                                                </span>
                                                <input type="text" value="" class="form-control" readonly>
                                            </div>                                            
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control"id="email" value="<%=id%>"  name="id" Style="display: none" >
                                            <label for="adminName">Shop Name:</label>
                                            <input type="text" value="${shop}" class="form-control"id="name" name="shopName" pattern="[a-zA-Z ]*$" required >
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Shop Url</label>
                                            <input type="text" class="form-control"id="email" value="${url} "  name="url" required >
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Shop Email</label>
                                            <input type="email" class="form-control"id="email" value=" ${email}"  name="email" required >
                                        </div>
                                        <div class="form-group">
                                            <label for="pwd">Password</label>
                                            <input type="password" name="pass" class="form-control collectes-ville text-center" id="password1" placeholder="Enter password" required="">
                                        </div>
                                        <div class="form-group">
                                            <label for="password">Re-enter password</label>
                                            <input type="password" class="form-control collectes-ville text-center" id="password2" name="password" placeholder="Re-enter password" required="">
                                        </div>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-primary " value="submit" id="btn-update" style="width: 100%">Update</button>
                                        </div>   

                                    </form>  </div>
                                <div class="col-md-4"></div>


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

            function Shop() {
                document.forms[0].action = "Customer_Shop";
                document.forms[0].submit();
                my();
            }
            function Advertiesment() {
                document.forms[0].action = "Customer_Advertiesment";
                document.forms[0].submit();
            }

            function Branch() {
                document.forms[0].action = "Customer_Branch";
                document.forms[0].submit();
            }
            function Dashbord() {
                document.forms[0].action = "Customer_Dashbord";
                document.forms[0].submit();
            }



        </script>


        <script src="static/js/jquery.min.js"></script>
        <script src="static/js/pendding.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
        <script src="static/js/jquery.dataTables.min.js"></script>
        <script src="static/js/dataTables.bootstrap.min.js"></script>
        <script src="static/js/adminlte.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.9.1/sweetalert2.min.js"></script>
        <script src="static/js/sessionDeleteShop.js"></script>
        <script src="static/js/customer_dashboard.js"></script>

    </body>
</html>
