<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

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
<title>HighIQ.ai - Home</title>
<!-- Custom CSS -->

<!-- Custom CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${contextPath}/resources/jquery/AddContact.js"></script>

<!-- Custom CSS -->


<!-- Custom CfSS -->
<link href="${contextPath}/resources/dist/css/style.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/assets/extra-libs/multicheck/multicheck.css">

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/assets/libs/select2/dist/css/select2.min.css">
	
<style type="text/css">
.multiselect {
	width: 200px;
}

.selectBox {
	position: relative;
}

.selectBox select {
	width: 100%;
	font-weight: bold;
}

.overSelect {
	position: relative;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
}

#checkboxes {
	display: none;
	border: 1px #dadada solid;
}

#checkboxes label {
	display: block;
}

#checkboxes label:hover {
	background-color: #1e90ff;
}
.col-form-label {
   
    font-size: 11px;
}
</style>
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
									class="fa fa-power-off m-r-5 m-l-5"></i>Logout</a>
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
		<!-- including side-bar.jsp  -->

		<%@include file="sideBar.jsp"%>

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
						<h4 class="page-title">Dashboard</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="dashboard">Home</a></li>
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
				<%-- <!-- ============================================================== -->
				<h1 align="center">Welcome To HighIQ.ai</h1>

				<div
					class="container-fluid col-sm-6 text-center control-label col-form-label">
					<img src="${contextPath}/resources/assets/images/HighIq.png" alt="user">
				</div>
 --%>
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="d-md-flex align-items-center">
									<div>
										<h4 class="card-title">Site Analysis</h4>
									</div>
								</div>
								<div class="dynamicForms">
									<div class="form-group row dynamicDiv">
										<div class="col-sm-4">
											<div class="bg-dark p-10 text-white text-center">
												<i class="mdi mdi-clipboard-text m-b-5 font-16"></i>
											<h4 class="m-b-0 m-t-5">${totalRegisterCustomer}</h4>
												 <small class="font-light">No of register customer </small>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="bg-dark p-10 text-white text-center">
												<i class="mdi mdi-account-card-details m-b-5 font-16"></i>
												<h4 class="m-b-0 m-t-5">${totalActiveLicense}</h4>
												<small class="font-light">No of active license  </small>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="bg-dark p-10 text-white text-center">
												<!-- <i class="mdi mdi-account-card-details m-b-5 font-16"></i> -->
												<h4 class="m-b-0 m-t-5">${totalActiveLicense}</h4>
												<!-- <small class="font-light">Total Valid Vendors </small> -->
											</div>
										</div>
										<!-- <div class="col-sm-2">
											<div class="bg-dark p-10 text-white text-center">
												<i class="mdi mdi-file-delimited m-b-5 font-16"></i>
												<h4 class="m-b-0 m-t-5"></h4>
												<small class="font-light">Invoices Pending Approval</small>
											</div>
										</div>
										<div class="col-sm-2">
											<div class="bg-dark p-10 text-white text-center">
												<i class="mdi mdi-camera-timer m-b-5 font-16"></i>
												<h4 class="m-b-0 m-t-5"></h4>
												<small class="font-light">Average Time For Approval
													(dd:hh:mm)</small>
											</div>
										</div>
										<div class="col-sm-2">
											<div class="bg-dark p-10 text-white text-center">
												<i class="mdi mdi-timetable m-b-5 font-16"></i>
												<h4 class="m-b-0 m-t-5"></h4>
												<small class="font-light">Invoices Pending Data
													Correction</small>
											</div>
										</div>
										<div class="col-sm-2">
											<div class="bg-dark p-10 text-white text-center">
												<i class="mdi mdi-av-timer m-b-5 font-16"></i>
												<h4 class="m-b-0 m-t-5"></h4>
												<small class="font-light">Average Time For Data
													Correction (dd:hh:mm)</small>
											</div>
										</div> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			<!-- 	<div class="row">
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
								<h5 class="page-title">Break Up Of Invoice Status Over a
									Time Period</h5>
								<div class="form-group row">
									<div class="input-group date col-md-5" id="datepicker-autoclose">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">From</label>
										<input type="text" class="form-control dateStatusFrom"
											 placeholder="yyyy-mm-dd"
											autocomplete="off">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
									<div class="input-group date col-md-5" id="datepicker-autoclose1">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">To</label>
										<input type="text" class="form-control dateStatusTo"
											 placeholder="yyyy-mm-dd"
											autocomplete="off">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
								</div>
								<div class="statusPie" style="height: 314px"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
								<h5 class="page-title">Break Up Of PO vs Non PO Invoices
									Over a Time Period</h5>
								<div class="form-group row">
									<div class="input-group date col-md-5"id="datepicker-autoclosePo">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">From</label>
										<input type="text" class="form-control datepickerFromPoPie"
											 placeholder="yyyy-mm-dd"
											autocomplete="off">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
									<div class="input-group date col-md-5"id="datepicker-autoclose1Po">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">To</label>
										<input type="text" class="form-control datepickerToPoPie"
											 placeholder="yyyy-mm-dd"
											autocomplete="off">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
								</div>
								<div class="PoNonPoPie" style="height: 314px"></div>
							</div>
						</div>
					</div>

				</div> -->
				<!-- End Charts -->
				<!-- Line Chart -->
				<%-- <div class="row">
					<div class="col-md-6">
						<div class="card">
							<div class="card-body myCharts">
								<h5 class="page-title">Top 5 Vendors By Invoice Received
									Count</h5>
								<div class="form-group row">
									<div class="input-group date col-md-5" id="datepicker-autoclose">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">From</label>
										<input type="text" class="form-control dateVendorFrom"
											 placeholder="yyyy-mm-dd">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
									<div class="input-group date col-md-5" id="datepicker-autoclose1">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">To</label>
										<input type="text" class="form-control dateVendorTo"
											 placeholder="yyyy-mm-dd">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
								</div>

								<canvas  id="myChart"></canvas>
															
								<div class="form-group row">
									<div class="input-group">
										<label for="fname" class="col-sm-3 text-right control-label col-form-label">&nbsp;</label>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="card">
							<div class="card-body myErrorCharts">
								<h5 class="page-title">Top 5 Breakup of rejection reasons</h5>
								<div class="form-group row">

									<div class="input-group date col-md-5" id="datepicker-autoclose">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label" style="text-align: center !important;">From</label>
										<input type="text" class="form-control dateErrorFrom"
											 placeholder="yyyy-mm-dd">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
									<div class="input-group date col-md-5" id="datepicker-autoclose1">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">To</label>
										<input type="text" class="form-control dateErrorTo"
											 placeholder="yyyy-mm-dd">
										<div class="input-group-append">
											<span class="input-group-text input-group-addon"><i
												class="fa fa-calendar"></i></span>
										</div>
									</div>
								</div>

								<div class="form-group row">
									<div class="input-group" style=" padding-left: 10px;">
										<label style="text-align: left !important;"    for="fname" class="col-sm-2 text-right control-label col-form-label">Vendor Filter</label>

										<div class="multiselect">
											
											<div class="selectBox" onclick="showCheckboxes()" >
												<input type="text" class="form-control form-control selectVemdorType select2"  placeholder="Search..." style="-webkit-appearance: menulist;">								
											</div>
											
											<div id="checkboxes" style="display: block;position: absolute;background-color: white;/* background-color: lightblue; */width: 200px;height: 192px;overflow: scroll;">
												<c:forEach items="${vendorList}" var="vdList">
												<c:if test="${vdList!=null && vdList!=''}">
												
												<label class="customcheckbox1"> <input
													type="checkbox" value="${vdList}"
													class="listCheckbox hidCheckBox" > ${vdList}
												</label> 
												</c:if>
												</c:forEach>
											</div>
										</div>
										
										<div class="col-sm-4">
										<button type="reset" class="btn btn-primary btn-sm btn-submit"
											onclick="button()" style="line-height: 1.6;">Apply</button>
											<button type="reset" class="btn btn-primary btn-sm btn-reset"
											onclick="button()" style="line-height: 1.6;">Clear</button>
										</div>
									</div>
								</div>

								<canvas id="myChartError"></canvas>
							</div>
						</div>
					</div>

				</div> --%>
				<!--End Of Line Chart  -->
			</div>
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
	<script
		src="${contextPath}/resources/assets/libs/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="${contextPath}/resources/assets/libs/popper.js/dist/umd/popper.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
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
	<!--This page JavaScript -->
	<!-- Charts js Files -->
	<script src="${contextPath}/resources/assets/libs/flot/excanvas.js"></script>
	<script src="${contextPath}/resources/assets/libs/flot/jquery.flot.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/flot/jquery.flot.pie.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/flot/jquery.flot.time.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/flot/jquery.flot.stack.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/flot/jquery.flot.crosshair.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
	<script
		src="${contextPath}/resources/dist/js/pages/chart/chart-page-init.js"></script>
	<script src="${contextPath}/resources/assets/libs/chart/Chart.min01.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script src="${contextPath}/resources/jquery/graph.js"></script>
	
	<script>
	
		jQuery('.mydatepicker').datepicker();
		jQuery(
				'#datepicker-autoclose,#datepicker-autoclose1,#datepicker-autoclosePo,#datepicker-autoclose1Po')
				.datepicker({
					autoclose : true,
					todayHighlight : true
				});
		var quill = new Quill('#editor', {
			theme : 'snow'
		});
	</script>
	<script>
	
		var expanded = false;
		checkboxes.style.display = "none";
		
		function showCheckboxes() {
			var checkboxes = document.getElementById("checkboxes");
			if (!expanded) {
				checkboxes.style.display = "block";
				expanded = true;
			} else {
				checkboxes.style.display = "none";
				expanded = false;
			}
		}
		//search filter on vendor name
		$(document).ready(function(){
			  $(".selectVemdorType").on("keyup", function() {
				  checkboxes.style.display = "block";
			    var value = $(this).val().toLowerCase();
			    $("#checkboxes label").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
		});
		
		//for uncheck checkboxes on reset buttons
		$(document).ready(function(){
			$(".btn-reset").on("click", function() {
				var divControl = document.getElementById('checkboxes');
				$('input:checkbox:checked', divControl).each(function(){
					$(this).prop('checked',false); 
				});
				clearAll();
			});
			
		});
		
		$('body').click(function(evt){    
		       if($(evt.target).closest('.multiselect').length){
		          return;             
		       }
		       checkboxes.style.display = "none";
		});
		
	</script>
</body>
</html>