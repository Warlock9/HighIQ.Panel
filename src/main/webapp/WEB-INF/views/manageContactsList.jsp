<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<!--  -->

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
<title>HighIQ.ai - Manage Contact</title>
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

<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/extra-libs/multicheck/multicheck.css">

<!-- Custom CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="${contextPath}/resources/jquery/AddCustomerContact.js"></script>
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
					<ul class="navbar-nav float-right">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle waves-effect waves-dark">
								Welcome - ${userFirstName} ${userLastName}</a></li>

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
						<h4 class="page-title">Manage Contacts</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="dashboard">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Manage Contacts</li>
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
							<div class="card-body">
								<h4 class="card-title"> Contact List</h4>
								<div class="table-responsive">
									
										<table id="zero_config" id="myTable"
											class="table table-striped table-bordered myTable">
											<thead>
												<tr>
													<!-- <th>
														<label class="customcheckbox m-b-20"> <input
															type="checkbox" id="mainCheckbox"> <span
															class="checkmark"></span>
													</label>
													</th> -->
													<th><b>Client Company Name</b></th>
													<th><b>Address Line 1</b></th>
													<th><b>Address Line 2</b></th>
													<th><b>Address Line 3</b></th>
													<th><b>Address Line 4</b></th>
													<th><b>City</b></th>
													<th><b>State</b></th>
													<th><b>Zip Code</b></th>
													<th><b>Country</b></th>
													<th><b>Contact Person</b></th>
													<th><b>Contact Number</b></th>
													<th><b>Email ID</b></th>
													<th><b>Created Date</b></th>
													<th><b>Updated Date</b></th>
													<th><b>Status</b></th>
													
													<th><b></b></th>
														
												
												</tr>
											</thead>
											<tbody>
											 	<c:forEach items="${customerDetailList}" var="cd"
													varStatus="rowCounter">
													<tr>
														<%-- <td><label class="customcheckbox"> <input
																type="checkbox" class="listCheckbox hidCheckBox"
																name="checkBoxId[]" value="${cd.clientId}"> <span
																class="checkmark"></span>
														</label></td> --%>
														<td><a href="contactDetails?clientId=${cd.clientId}" target="_blank">${cd.clientCompanyName}</a></td>
														<td>${cd.addressLine1}</td>	
														<td>${cd.addressLine2}</td>	
														<td>${cd.addressLine3}</td>	
														<td>${cd.addressLine4}</td>
														<td>${cd.city}</td>												
														<td>${cd.state}</td>
														<td>${cd.zipCode}</td>
														<td>${cd.country}</td>
														<td>${cd.contactPerson}</td>
														<td>${cd.contactNumber}</td>
														<td>${cd.emailID}</td>
														<td>${cd.createdDate}</td>
														<td>${cd.updatedDate}</td>
														<td>${cd.status}</td>
														
													<td>
														<button type="button" class="btn btn-danger btn-sm"
															data-toggle="modal"
															data-target="#updateDeleteModal${cd.clientId}">Delete</button>

													</td>
												</tr>
												<!-- Start Of Modal  -->
													<div class="modal fade" id="updateDeleteModal${cd.clientId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
						                                    <div class="modal-dialog" role="document ">
						                                        <div class="modal-content">
						                                            <div class="modal-header">
						                                                <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
						                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						                                                    <span aria-hidden="true ">&times;</span>
						                                                </button>
						                                            </div>
						                                            <form action="deleteContactSiteList" method="POST">
						                                            <div class="modal-body">
																		<div class="card-body col-sm-12 text-center">Do you really want to delete...?</div>
																		<input type="hidden" name="contactId" value="${cd.clientId}"/>
																		<%-- <input type="hidden" name="contactCompanyNumber" value="${cd.contactCompanyNumber}"/> --%>
																		<div class="card-body col-sm-12 text-center">						
																			<button type="submit" name="action"
																				value="delete" class="btn btn-sm btn-primary">Yes</button>
																			<button type="button"
																				class="btn btn-sm btn-secondary"
																				data-dismiss="modal">No</button>
																		</div>
																	</div>
																	</form>
						                                        </div>
						                                    </div>
						                                </div>
												<!-- End Of Modal -->
												</c:forEach>
												
											</tbody>
										</table>
										<form target="_blank" class="form-horizontal" action="manageContactForNewContact">
										
										<button type="submit" class="btn btn-success" >Add New Contact</button>
														
									</form>
								
								</div>

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
			<div class="modal fade" id="duplicateConfirmModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true ">
				<div class="modal-dialog" role="document ">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Alert</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true ">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="card-body col-sm-12 text-center">
								<span id="duplicateIdSpan"></span>
							</div>
							<div class="card-body col-sm-12 text-center">
								<button type="button" class="btn btn-sm btn-primary"
									data-dismiss="modal">Ok</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Modal -->


			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<footer class="footer text-center">
				All Rights Reserved by <a href="dashboard">HighIQ.ai</a>.

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

	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="${contextPath}/resources/assets/libs/jquery/dist/jquery.min.js"></script>
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

	<script
		src="${contextPath}/resources/assets/extra-libs/multicheck/datatable-checkbox-init.js"></script>
	<script
		src="${contextPath}/resources/assets/extra-libs/multicheck/jquery.multicheck.js"></script>

	<!-- 	scripts libs for extracting excel data   -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.13.5/xlsx.full.min.js"></script>
	<!-- 	scripts libs for extracting excel data   -->

	<script>
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
		
		function setDomainNameValue()
		{ 
		 	//var currentRowDiv = $(this).closest(".dynamicDiv");
			        
		//	$(currentRowDiv).find("#contactDomainName").val(domainName[1]);
			 $(".dynamicDiv").each(function(){
				 var emailId = $(this).find("input[type=email]").val();
					var currentRow = $(this).closest(".dynamicDiv");
					var domainName=emailId.split("@");
					var currentRowDiv = $(this).closest(".dynamicDiv");
					currentRowDiv.find("input[name='contactDomainName[]']").val(domainName[1]);
			 });
 			 
		}
	</script>
	<script>
	
	
	
/*close model for Vendor*/
$('#closemodal').click(function() {
    $('#addNewContactModal').modal('hide');
});

/*close model for Customer*/
$('#closemodal1').click(function() {
    $('#addNewContactModal').modal('hide');
});
		/****************************************
		 *       Basic Table                   *
		 ****************************************/
		$('#zero_config').DataTable();
		
		$('.uploadVendorSheetBtn').click(function(){
			
			$('#excelfileVendor').click();
			
		});
        $('.uploadCustomerSheetBtn').click(function(){
			
			$('#excelfileCustomer').click();
			
		});
      $('.downloadVendorSheetBtn').click(function(e) {
    e.preventDefault();  //stop the browser from following
    location.reload(true);
    window.location.href = 'resources/jquery/VendorTemplate.xlsx';
});
$('.downloadCustomerSheetBtn').click(function(e) {
    e.preventDefault();  //stop the browser from following
    location.reload(true);
    window.location.href = 'resources/jquery/CustomerTemplate.xlsx';
});
		$("body").on("change", "#excelfileCustomer", function () {
			
			$('.submitCustomer').click();
		});
        $("body").on("change", "#excelfileVendor", function () {
			
			$('.submitVendor').click();
		});
	</script>
</body>

</html>