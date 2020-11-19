<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

        <link rel="shortcut icon" href="assets/dist/img/favicon.png">
        <!--Global Styles(used by all pages)-->
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="assets/plugins/fontawesome/css/all.min.css" rel="stylesheet">
        <link href="assets/plugins/typicons/src/typicons.min.css" rel="stylesheet">
        <link href="assets/plugins/themify-icons/themify-icons.min.css" rel="stylesheet">
        <link href="assets/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="assets/dist/css/style.css" rel="stylesheet">
</head>
<body class="fixed">
   <div class="wrapper">
            <!-- Sidebar  -->
            <nav class="sidebar sidebar-bunker">
                <div class="sidebar-header">
                    <!--<a href="index.html" class="logo"><span>bd</span>task</a>-->
                    <a><h3 style="text-align:center;color:white;">Rooster-App</h3></a>
                </div><!--/.sidebar header-->
                
                <%@ include file="/template/sidebar.jsp" %> 
            </nav>
            <!-- Page Content  -->
            <div class="content-wrapper">
                <div class="main-content">
                    <nav class="navbar-custom-menu navbar navbar-expand-lg m-0">
                        <div class="sidebar-toggle-icon" id="sidebarCollapse">
                            sidebar toggle<span></span>
                        </div><!--/.sidebar toggle icon-->
                    </nav><!--/.navbar-->
                    <div class="body-content">
                        <div class="card mb-4">
                            <div class="card-header">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <h6 class="fs-17 font-weight-600 mb-0">Tus colectivos</h6>
                                    </div>
                                </div>
                            </div>
							<div class="card-body">
                                <div class="table-responsive">
                                	<table class="table display table-bordered table-striped table-hover language-options" id="tableCollectives">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Organizador</th>
                                                <th>Participantes</th>
                                                <th>Localizacion</th>
                                                <th>Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tblCollectivesBody">
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <button type="button" class="btn btn-success mb-2" data-toggle="modal" data-target="#exampleModal1">Agreagar un colectivo
                        </button>
						<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel4" aria-hidden="true">
	                        <div class="modal-dialog" role="document">
	                            <div class="modal-content">
	                                <div class="modal-header">
	                                    <h5 class="modal-title font-weight-600" id="exampleModalLabel4">Nuevo colectivo</h5>
	                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                                        <span aria-hidden="true">&times;</span>
	                                    </button>
	                                </div>
	                                <div class="modal-body">
										<div class="form-group">
											<label style="font-weight: bold;">Nombre:</label>
											<input type="text" class="form-control" id="txtName">
										</div>
										<div class="form-group">
											<label style="font-weight: bold;">Organizador:</label>
											<input type="text" class="form-control" id="txtOrganizator">
										</div>
										<div class="form-group">
											<label style="font-weight: bold;">Localizacion:</label>
											<input type="text" class="form-control" id="txtLocation">
										</div>
	                                </div>
	                                <div class="modal-footer">
	                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
	                                    <button type="button" class="btn btn-success" id="bttnGuardar">Guardar</button>
	                                </div>
	                            </div>
	                        </div>
                    	</div>
                    </div><!--/.body content-->
                </div><!--/.main content-->
				<%@ include file="/template/footer.jsp" %> 
                <div class="overlay"></div>
            </div><!--/.wrapper-->
        </div>
	
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="assets/dist/js/popper.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugins/metisMenu/metisMenu.min.js"></script>
	<script src="assets/plugins/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
	<script src="assets/dist/js/sidebar.js"></script>
   	<script src="js/collective/collective.js"></script>
</body>
</html>