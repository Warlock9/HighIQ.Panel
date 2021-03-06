

<!-- Add contact -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% 
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>


<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="${contextPath}/resources/assets/images/favicon.png">
<title>HighIQ.ai - Manage User Roles</title>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/libs/select2/dist/css/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/libs/jquery-minicolors/jquery.minicolors.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/libs/quill/dist/quill.snow.css">
<link
	href="${contextPath}/resources/assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.css"
	rel="stylesheet">

<link href="${contextPath}/resources/dist/css/style.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/dist/css/icons/font-awesome/css/font-awesome.min.css">

<!-- Custom CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/extra-libs/multicheck/multicheck.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${contextPath}/resources/jquery/UsersRole.js"></script>
<!-- Custom CSS -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>

	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin5">
					<!-- This is for the sidebar toggle which is visible on mobile only -->
					<a class="nav-toggler waves-effect waves-light d-block d-md-none"
						href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<a class="navbar-brand" href="dashboard"> <b
						class="logo-icon p-l-10"> <img
							src="${contextPath}/resources/assets/images/logo-icon.png"
							alt="homepage" class="light-logo" />
					</b> <span class="logo-text"> <img
							src="${contextPath}/resources/assets/images/logo-text.png"
							alt="homepage" class="light-logo" />
					</span>
					</a>
					<!-- ============================================================== -->
					<!-- End Logo -->
					<!-- ============================================================== -->
					<!-- ============================================================== -->
					<!-- Toggle which is visible on mobile only -->
					<!-- ============================================================== -->
					<a class="topbartoggler d-block d-md-none waves-effect waves-light"
						href="javascript:void(0)" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation"><i class="ti-more"></i></a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent"
					data-navbarbg="skin5">
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-left mr-auto">
						<li class="nav-item d-none d-md-block"><a
							class="nav-link sidebartoggler waves-effect waves-light"
							href="javascript:void(0)" data-sidebartype="mini-sidebar"><i
								class="mdi mdi-menu font-24"></i></a></li>
					</ul>
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-right"><li class="nav-item dropdown"><a class="nav-link dropdown-toggle waves-effect waves-dark"> Welcome - ${userFirstName} ${userLastName}</a></li>
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic"
							href="" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"><img
								src="${contextPath}/resources/assets/images/users/1.jpg"
								alt="user" class="rounded-circle" width="31"></a>
							<div class="dropdown-menu dropdown-menu-right user-dd animated">
							
									
								 
								<a href="logOut.do?logOut=logOut" class="dropdown-item"
									href="javascript:void(0)"><i
									class="fa fa-power-off m-r-5 m-l-5"></i> Logout</a>
							</div></li>
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
					</ul>
				</div>

			</nav>
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- including Sidebar - style you can find in sidebar.scss  -->

		<%@include file="sideBar.jsp"%>

		<!-- including Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-12 d-flex no-block align-items-center">
						<h4 class="page-title">Manage User Roles</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="dashboard">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Manage User Roles</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-12">
						<div class="card">

							<form class="form-horizontal" action="usersRoleSelect.do" method="POST">

								<div class="card-body">
									<h4 class="card-title">Select User Role</h4>

									<div class="form-group row">

										<label for="fname"
											class="col-sm-2 text-right control-label col-form-label">Select
											Role</label>
										<div class="col-sm-3">
											<select name="role[]" class="select1 form-control custom-select rolDropDown" onchange="this.form.submit()" required>								
												<option value="">Select Role</option>
												<c:forEach items="${distinctRoleDist}" var="dl">
													<option  data-value="${dl}" value="${dl}" ${selectedRole == dl ? 'selected' : ''} >${dl}</option>
												</c:forEach>
											</select>
										</div>

										<div class="col-sm-3">
										<c:if test="${deleteAccess=='1'}">
											<button type="button" class="btn btn-danger btn-submit" data-toggle="modal" data-target="#updateDeleteModal">Delete</button>
										</c:if>
										</div>
									</div>
								</div>
									<!-- Start Of Modal  -->
													<div class="modal fade" id="updateDeleteModal${bd.botId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
						                                    <div class="modal-dialog" role="document ">
						                                        <div class="modal-content">
						                                            <div class="modal-header">
						                                                <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
						                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						                                                    <span aria-hidden="true ">&times;</span>
						                                                </button>
						                                            </div>
						                                            <div class="modal-body">
																		<div class="card-body col-sm-12 text-center">Do you really want to delete ?</div>
																		<div class="card-body col-sm-12 text-center">						
																			<button type="submit" name="role[]" value="${selectedRole}" class="btn btn-sm btn-primary">Yes</button>
																			<button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">No</button>																		
																		</div>
																	</div>
						                                        </div>
						                                    </div>
						                                </div>
								<!-- End Of Modal -->
							</form>
						</div>
					</div>
					
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title card-title1">Add User Role</h5>
								<form class="form-horizontal" action="usersRole.do" method="POST">
									<div class="form-group row">

										<label for="fname" class="col-sm-1 text-right control-label col-form-label">User Role</label>
										<div class="col-sm-3">
											<input type="text" name="role" class="form-control role" value="${selectedRole}"  ${selectedRole != null? 'readonly' : ''} placeholder="Enter Role Here" required>
											
										</div>
										
										<%-- <label for="fname"
											class="col-sm-2 text-right control-label col-form-label">Special Access</label>
										<div class="col-sm-3">
											<select name="specialAccess" class="select1 form-control custom-select specialAccessDropDown" required>
												<option value="">Select Special Access</option>
													<option value="None" ${selectedSpecialAccess == 'None' ? 'selected' : ''} >None</option>
													<option value="Cost Center Manager" ${selectedSpecialAccess == 'Cost Center Manager' ? 'selected' : ''} >Cost Center Manager</option>
													<option value="Bot Manager" ${selectedSpecialAccess == 'Bot Manager' ? 'selected' : ''} >Bot Manager</option>
											</select>
										</div> --%>
									</div>

									<div class="table-responsive">
										<table id=""
											class="table table-striped table-bordered myTable text-center">
											<thead>
												<tr>
													<th><b>Access Name</b></th>
													<th><b>View Access</b></th>
													<th><b>Create Access</b></th>
													<th><b>Edit Access</b></th>
													<th><b>Delete Access</b></th>
													<!-- <th><b>Approve Access</b></th> -->
												</tr>
											</thead>
											<tbody class="dynamicDiv">
												<c:set var="count" value="0" scope="page" />
												<c:forEach items="${retrievedRoles}" var="al">
												<c:set var="count" value="${count + 1}" scope="page"/>
													<tr>
														<td>${al.accessName}
															<input type="hidden" name="accessName[]" value="${al.accessName}" />
															<input type="hidden" name="id[]" value="${al.id}" />
														</td>
														<td>
															<label class="customcheckbox"> 
															<c:choose>
	  															<c:when test="${al.viewAccess==1}">
	  																<input type="checkbox" class="listCheckbox hidCheckBox" name="viewAccess[]" value="1" id="viewAccess${count}" checked>
	 																<input type="hidden" name="viewAccess[]" size="viewAccess${count}" value="0" disabled/>
	 															</c:when>
	 															<c:otherwise>
	 															  	<input type="checkbox" class="listCheckbox hidCheckBox" name="viewAccess[]" value="1" id="viewAccess${count}" > 													
	    															<input type="hidden" name="viewAccess[]" size="viewAccess${count}" value="0" />
	  															</c:otherwise>
															</c:choose>
																<span class="checkmark" style="margin-left:60px"></span>
															</label>														
														</td>
														
														
														<td>
															<label class="customcheckbox">
															<c:choose>
	  															<c:when test="${al.createAccess==1}">
	  																<input type="hidden" name="createAccess[]" size="createAccess${count}" value="0" disabled/>
																	<input type="checkbox" class="listCheckbox hidCheckBox"name="createAccess[]" value="1" id="createAccess${count}" checked>
	 															</c:when>
	 															<c:otherwise>
	 															  	<input type="hidden" name="createAccess[]" size="createAccess${count}" value="0" />
																	<input type="checkbox" class="listCheckbox hidCheckBox"name="createAccess[]" value="1" id="createAccess${count}">
	  															</c:otherwise>
															</c:choose>																													
																<span class="checkmark" style="margin-left:60px"></span>
															</label>
														
														</td>
														
														<td>
															<label class="customcheckbox">
															<c:choose>
	  															<c:when test="${al.editAccess==1}">
	  																<input type="hidden" name="editAccess[]" size="editAccess${count}" value="0" disabled/>
																	<input type="checkbox" class="listCheckbox hidCheckBox" name="editAccess[]" value="1" id="editAccess${count}" checked>
	 															</c:when>
	 															<c:otherwise>
	 															  	<input type="hidden" name="editAccess[]" size="editAccess${count}" value="0" />
																	<input type="checkbox" class="listCheckbox hidCheckBox" name="editAccess[]" value="1" id="editAccess${count}">
	  															</c:otherwise>
															</c:choose>																													
																<span class="checkmark" style="margin-left:60px"></span>												
															</label>														
														</td>
																												
														<td>
															<label class="customcheckbox"> 
															<c:choose>
	  															<c:when test="${al.deleteAccess==1}">
	  																<input type="hidden" name="deleteAccess[]" size="deleteAccess${count}" value="0" disabled/>
																<input type="checkbox" class="listCheckbox hidCheckBox" name="deleteAccess[]" value="1" id="deleteAccess${count}" checked>
	 															</c:when>
	 															<c:otherwise>
	 															  	<input type="hidden" name="deleteAccess[]" size="deleteAccess${count}" value="0" />
																<input type="checkbox" class="listCheckbox hidCheckBox" name="deleteAccess[]" value="1" id="deleteAccess${count}">
	  															</c:otherwise>
															</c:choose>																													
																<span class="checkmark" style="margin-left:60px"></span>
															</label>
														</td>
														
														<%-- <td>
															<label class="customcheckbox"> 														
															<c:choose>
	  															<c:when test="${al.approveAccess==1}">
	  																<input type="hidden" name="approveAccess[]" size="approveAccess${count}" value="0" disabled/>
																	<input type="checkbox" class="listCheckbox hidCheckBox" name="approveAccess[]" value="1" id="approveAccess${count}" checked>
	 															</c:when>
	 															<c:otherwise>
	 															  	<input type="hidden" name="approveAccess[]" size="approveAccess${count}" value="0" />
																	<input type="checkbox" class="listCheckbox hidCheckBox" name="approveAccess[]" value="1" id="approveAccess${count}">
	  															</c:otherwise>
															</c:choose>																													
															<span class="checkmark" style="margin-left:60px"></span>
															</label>
														</td> --%>
													</tr>

												</c:forEach>

											</tbody>
										</table>
									</div>
									<div class="form-group row">
										<div class="card-body">	
										<c:choose>		
											<c:when test="${selectedRole==null}">
												<button type="submit" name="action" value="save" class="btn btn-success" id="btn-success" >Save</button>
											</c:when>
											<c:otherwise>
										      	 <button type="submit" name="action" value="save" class="btn btn-info btn-update" data-toggle="modal" data-target="#updateConfirmModal">Update</button>
											</c:otherwise>
										</c:choose>	
												<button type="reset" onclick="location.href='usersRole';" class="btn btn-primary btn-reset">Reset</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- End PAge Content -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Right sidebar -->
				<!-- ============================================================== -->
				<!-- .right-sidebar -->
				<!-- ============================================================== -->
				<!-- End Right sidebar -->
				<!-- ============================================================== -->
			</div>
					<!-- Modal -->
                                <div class="modal fade" id="duplicateConfirmModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
                                    <div class="modal-dialog" role="document ">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true ">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
												<div class="card-body col-sm-12 text-center"><span id="duplicateIdSpan"></span></div>
												<div class="card-body col-sm-12 text-center">
													<button type="button" class="btn btn-sm btn-primary" data-dismiss="modal">Ok</button>
												</div>
											</div>
                                        </div>
                                    </div>
                                </div>
                   <!-- Modal --
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<footer class="footer text-center">
					All Rights Reserved by <a href="dashboard">HighIQ.ai</a>
			</footer>
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script
		src="${contextPath}/resources/assets/libs/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="${contextPath}/resources/assets/libs/popper.js/dist/umd/popper.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- slimscrollbar scrollbar JavaScript -->
	<script
		src="${contextPath}/resources/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
	<script
		src="${contextPath}/resources/assets/extra-libs/sparkline/sparkline.js"></script>
	<!--Wave Effects -->
	<script src="${contextPath}/resources/dist/js/waves.js"></script>
	<!--Menu sidebar -->
	<script src="${contextPath}/resources/dist/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="${contextPath}/resources/dist/js/custom.min.js"></script>
	<!-- This Page JS -->
	<script
		src="${contextPath}/resources/assets/libs/inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
	<script src="${contextPath}/resources/dist/js/pages/mask/mask.init.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/select2/dist/js/select2.full.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/select2/dist/js/select2.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/jquery-asColor/dist/jquery-asColor.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/jquery-asGradient/dist/jquery-asGradient.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/jquery-asColorPicker/dist/jquery-asColorPicker.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/jquery-minicolors/jquery.minicolors.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/quill/dist/quill.min.js"></script>
	<script
		src="${contextPath}/resources/assets/extra-libs/DataTables/datatables.min.js"></script>
	<script>
		//***********************************//
		// For select 2
		//***********************************//
		$(".select2").select2();

		/*colorpicker*/
		$('.demo').each(function() {
			//
			// Dear reader, it's actually very easy to initialize MiniColors. For example:
			//
			//  $(selector).minicolors();
			//
			// The way I've done it below is just for the demo, so don't get confused
			// by it. Also, data- attributes aren't supported at this time${contextPath}/resources.they're
			// only used for this demo.
			//
			$(this).minicolors({
				control : $(this).attr('data-control') || 'hue',
				position : $(this).attr('data-position') || 'bottom left',

				change : function(value, opacity) {
					if (!value)
						return;
					if (opacity)
						value += ', ' + opacity;
					if (typeof console === 'object') {
						console.log(value);
					}
				},
				theme : 'bootstrap'
			});

		});
		/*datwpicker*/
		jQuery('.mydatepicker').datepicker();
		jQuery('#datepicker-autoclose').datepicker({
			autoclose : true,
			todayHighlight : true
		});
		var quill = new Quill('#editor', {
			theme : 'snow'
		});
	</script>
	<script>
		/****************************************
		 *       Basic Table                   *
		 ****************************************/
		$('#zero_config').DataTable();
	</script>
</body>

</html>