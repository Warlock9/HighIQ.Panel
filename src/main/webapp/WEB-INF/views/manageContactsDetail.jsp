<!-- Add contact -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@page isELIgnored="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
<title>HighIQ.ai - Purcahse Order Details</title>
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

<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
<script type="text/javascript">
    $('.selectpicker').selectpicker({
      });
</script>
 -->
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/dist/css/icons/font-awesome/css/font-awesome.min.css">

<%-- <link href="${contextPath}/resource/dist/css/style.min.css" rel="stylesheet">
    <link href="${contextPath}/resource/assets/libs/toastr/build/toastr.min.css" rel="stylesheet"> --%>
<!-- Custom CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="http://momentjs.com/downloads/moment.js"></script>

<script src="${contextPath}/resources/jquery/customerDetails.js"></script>
<!-- Custom CSS -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<style>

.tab-content {
overflow: hidden;
}
</style>
<body>


	<!-- ============================================================== -->
<!-- Main wrapper - style you can find in pages.scss -->
<!-- ============================================================== -->
<div id="main-wrapper" class="invoice_wrapper">
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

<%-- <%@include file="sideBar.jsp"%> --%>

<!-- including Sidebar - style you can find in sidebar.scss  -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Page wrapper  -->
<!-- ============================================================== -->
<div class="page-wrapper invoicedetails">
	<!-- ============================================================== -->
<!-- Bread crumb and right sidebar toggle -->
<!-- ============================================================== -->
<div class="page-breadcrumb container-fluid" id="blockPage">
	<div class="row">
		<div class="col-12 d-flex no-block align-items-center">
			<h4 class="page-title">
				<!-- PO Header -->
		</h4>
		<div class="ml-auto text-right">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="dashboard">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Purchase
						Order Details</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<div class="row">

	<div class="col-sm-12 col-xs-12">
		<nav>
			<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
				<a class="nav-item nav-link active" id="nav-about-tab"
					data-toggle="tab" href="#nav-about" role="tab"
					aria-controls="nav-about" aria-selected="true">Header
					Information</a> <a class="nav-item nav-link" id="nav-profile-tab"
					data-toggle="tab" href="#nav-profile" role="tab"
					aria-controls="nav-profile" aria-selected="false"> Site
					Details</a>
				<!-- <a class="nav-item nav-link " id="nav-poAddress-tab"
data-toggle="tab" href="#nav-poAddress" role="tab"
aria-controls="nav-poAddress" aria-selected="false">Vender
Site </a> -->


		<!-- <a class="nav-item nav-link" id="nav-audit-tab1"
data-toggle="tab" href="#nav-auditTrail" role="tab"
aria-controls="nav-auditTrail" aria-selected="false">Audit
Trail </a> -->


	</div>
</nav>

<c:choose>
	<c:when test="${Type=='Customer'}">
		<%-- <form class="form-horizontal"> --%>

			<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">

				<!-- starts invoice Information -->
				<div class="tab-pane fade show active" id="nav-about"
					role="tabpanel" aria-labelledby="nav-contact-tab">

					<div class="col-12">
						<div class="card">

							<div class="card-body">
								<h4 class="card-title">Contact Information</h4>
								
								 <div class="form-group row">
									<!-- <label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										ID</label> -->
									<div class="col-sm-4">

										<input type="text" class="form-control contactId"
											id="ContactID" value="${contactDetails.contactId}" style="display:none;"
											placeholder="Contact ID" />

									</div>

								</div>
								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Type </label>
									<div class="col-sm-4">
										<input type="text" disabled class="form-control contactType"
											id="ContactType" value="Customer"
											placeholder="Contact Type">
									</div>
									
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										First Name</label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactFirstName"
											id="ContactFirstName"
											value="${contactDetails.contactFirstName}"
											placeholder="Contact First Name">
									</div>
								
								</div>

							

								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Middle Name</label>
									<div class="col-sm-4">
										<input type="text"
											class="form-control contactMiddleName"
											id="ContactMiddleName"
											value="${contactDetails.contactMiddleName}"
											placeholder="Contact Middle Name">
									</div>

									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Last Name</label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactlastName"
											id="ContactLastName"
											value="${contactDetails.contactlastName}"
											placeholder="Contact Last Name">
									</div>
								</div>

								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Company Number</label>
									<div class="col-sm-4">
										<input type="text"
											class="form-control contactCompanyNumber" id="contactCompanyNumber"
											value="${contactDetails.contactCompanyNumber}"
											placeholder="Contact Company Number">
									</div>

									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Company</label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactCompany"
											id="ContactCompany"
											value="${contactDetails.contactCompany}"
											placeholder="Contact Company">
									</div>

								
									
									
									</div>
                       	<div class="form-group row">
                 	           <label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Email ID </label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactEmailId"
											id="ContactEmailID"
											value="${contactDetails.contactEmailId}"
											placeholder="Contact Email ID">
									</div>
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label ">Contact
										Phone </label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactPhone"
											id="ContactPhone"
											value="${contactDetails.contactPhone}"
											placeholder="Contact Phone">
									</div>
                 	         </div>

								

								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">
										Bot ID</label>
									<div class="col-sm-4">
										<%-- <input type="text" class="form-control botId" id=""
											value="${contactDetails.botId}" placeholder="Bot ID"> --%>
											<select class="form-control botId" >
											<option value="">SELECT</option>
											<c:forEach items="${botDetails}" var="botDetails">
											<option value="${botDetails.botId}" <c:if test="${botDetails.botId == contactDetails.botId}">Selected</c:if>>${botDetails.botId}</option>
											</c:forEach>
											</select>
									</div>
								

									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">
										Default Payment Terms</label>
									<div class="col-sm-4">
										<input type="text"
											class="form-control defaultPaymentTerms"
											id="DefaultPaymentTerms"
											value="${contactDetails.defaultPaymentTerms}"
											placeholder="Default Payment Terms">
									</div>
						</div>


								<div class="form-group row">
								
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Default
										Transaction Type </label>
									<div class="col-sm-4">
										<input type="text"
											class="form-control defaultTranscationType"
											id="DefaultTransactionType"
											value="${contactDetails.defaultTransactionType}"
											placeholder="Default Transaction Type">
									</div>
								
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">
										Default Ware House</label>
									<div class="col-sm-4">
										<input type="text" class="form-control defaultWarehouse"
											id="DefaultWareHouse"
											value="${contactDetails.defaultWareHouse}"
											placeholder="Default Ware House">
									</div>
									</div>


								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Default
										Price List </label>
									<div class="col-sm-4">
										<input type="text" class="form-control defaultPriceList"
											id="DefaultPriceList"
											value="${contactDetails.defaultPriceList}"
											placeholder="Default Price List">
									</div>
									
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">
										Default FOB Point</label>
									<div class="col-sm-4">
										<input type="text" class="form-control defaultFobPoint"
											id="DefaultFOBPoint"
											value="${contactDetails.defaultFobPoint}"
											placeholder="Default FOB Point">
									</div>
								</div>


							</div>
						</div>
					</div>

				</div>
				<!-- ends of start invoice information -->
				<div class="tab-pane fade" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Site Details</h5>
								<div class="table-responsive tableFixHead">

									<table id=""
										class="e-table table table-striped table-bordered myTable1 ">

										<thead>
											<tr>
												<th><b>Site Type</b></th>
												<th><b>Site Use ID</b></th>
												<th style="display: none;"><b>Contact Company Number</b></th>
												<th><b>Bill To Site Use ID</b></th>
												<th><b>Location ID</b></th>
											<!-- 	<th>Operation Unit Id</th> -->
												<th><b>Address Line1</b></th>
												<th><b>Address Line2</b></th>
												<th><b>Address Line3 </b></th>
												<th><b>Address Line4</b></th>
												<th><b>Address City</b></th>
												<th><b>Address State</b></th>
												<th><b>Address Postal Code</b></th>
												<th><b>Address Country</b></th>
												<th><b>Operation Unit</b></th>
												<th><b>Default Payment Terms</b></th>
												<th><b>Default Transaction Type</b></th>
												<th><b>Default Ware House</b></th>
												<th><b>Default Price List</b></th>
												<th><b>Default FOB Point</b></th>
												<th><b></b></th>


											</tr>

										</thead>

										<tbody class="alignmentp" id="tableBody" >
											<c:forEach items="${cSites}" var="il">

												<tr class="dynamicRowLine">
													<td>													
														<select onchange="showBillToId()">
															 <option value="">SELECT</option>
															 <option value="BILL_TO" <c:if test="${il.siteType=='BILL_TO'}">selected</c:if>>BILL_TO</option>
															 <option value="SHIP_TO" <c:if test="${il.siteType=='SHIP_TO'}">selected</c:if>>SHIP_TO</option>
														</select>																									
													</td> 
													<td contenteditable='true'>${il.siteUseId}</td>
													<td contenteditable='true' style="display: none;">${il.contactCompanyNumber}</td>
													<td>
														<c:choose>
														  <c:when test="${il.siteType=='BILL_TO'}">
														    
														  </c:when>
														  <c:otherwise>
														  	<select>
														  		<option value="">SELECT</option>
																<c:forEach items="${distinctBillToSiteId}" var="billToList">																						
															 	<option value="${billToList}" <c:if test="${billToList==il.billToSiteUseId}">selected</c:if>> ${billToList} </option>
																</c:forEach> 
															</select>	
														  </c:otherwise>
														</c:choose>																									
													</td>
													<td contenteditable='true'>${il.locationId}</td>
													<%-- <td contenteditable='true'><select>
														  		<option value="">SELECT</option>
																<c:forEach items="${RegionDetailList}" var="operatingUnitID">																						
															 	<option value="${operatingUnitID.operatingUnitId}" > ${operatingUnitID.operatingUnit} </option>
																</c:forEach>
															</select>	</td> --%>
													<td contenteditable='true'>${il.addressLine1}</td>
													<td contenteditable='true'>${il.addressLine2}</td>
													<td contenteditable='true'>${il.addressLine3}</td>
													<td contenteditable='true'>${il.addressLine4}</td>
													<td contenteditable='true'>${il.addressCity}</td>
													<td contenteditable='true'>${il.addressState}</td>
													<td contenteditable='true'>${il.addressPostalCode}</td>
													<td contenteditable='true'>${il.addressCountry}</td>
													
													<td contenteditable='true'><select>
														  		<option value="">SELECT</option>
																<c:forEach items="${RegionDetailList}" var="operatingUnitID">																						
															 	<option value="${operatingUnitID.operatingUnitId}" <c:if test="${il.operatingUnit == operatingUnitID.operatingUnitId}">selected</c:if>> ${operatingUnitID.operatingUnit}</option>
																</c:forEach>
															</select></td>
													<td contenteditable='true'>${il.defaultPaymentTerms}</td>
													<td contenteditable='true'>${il.defaultTransactionType}</td>
													<td contenteditable='true'>${il.defaultWareHouse}</td>
													<td contenteditable='true'>${il.defaultPriceList}</td>
													<td contenteditable='true'>${il.defaultFOBPoint}</td>

													<td>
														<button type="button" class="btn btn-danger btn-sm"
															data-toggle="modal"
															data-target="#updateDeleteModal${il.siteUseId}">Delete</button>

													</td>
												</tr>
												<!-- Start Of Modal  -->
													<div class="modal fade" id="updateDeleteModal${il.siteUseId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
						                                    <div class="modal-dialog" role="document ">
						                                        <div class="modal-content">
						                                            <div class="modal-header">
						                                                <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
						                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						                                                    <span aria-hidden="true ">&times;</span>
						                                                </button>
						                                            </div>
						                                            <form action="deleteContactSite" method="POST">
						                                            <div class="modal-body">
																		<div class="card-body col-sm-12 text-center">Do you really want to delete...?</div>
																		<input type="hidden" name="siteUseId" value="${il.siteUseId}"/>
																		<input type="hidden" name="contactCompanyNumber" value="${il.contactCompanyNumber}"/>
																		<input type="hidden" name="siteType" value="${il.siteType}"/>
																		<input type="hidden" name="contactId" value="${contactDetails.contactId}"/>
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
									<span style="margin-left: 20px;"><button
											type="button" class="btn btn-danger btn-sm btnAddCustomer">Add
											Line</button></span>

								</div>

							</div>
						</div>
					</div>

				</div>

			</div>


			<div class="border-top">
				<div class="card-body">
					<c:if test="${editAccess=='1'}">
						<button type="button" class="btn btn-info "
							data-toggle="modal" data-target="#updateConfirmModal">Update</button>
					</c:if>
					<c:if test="${approveAccess=='1' || approval10000=='1'}">

						<button type="button" class="btn btn-info"
							data-toggle="modal" data-target="#approveConfirmModal">Approve</button>
					</c:if>
					<c:if test="${editAccess=='1' && approveAccess=='1'}">

						<button type="button" class="btn btn-info btn-reject"
							data-toggle="modal" data-target="#rejectConfirmModal">Reject</button>
					</c:if>

				</div>
			</div>
		<%-- </form> --%>

	</c:when>
	
	<c:when test="${Type=='Vendor'}">
		<%-- <form class="form-horizontal"> --%>
			<%-- action="managecontact" method="POST" --%>
			<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">

				<!-- starts invoice Information -->
				<div class="tab-pane fade show active" id="nav-about"
					role="tabpanel" aria-labelledby="nav-contact-tab">

					<div class="col-12">
						<div class="card">

							<div class="card-body">
								<h4 class="card-title">Contact Information</h4>
								
								 <div class="form-group row">
									<!-- <label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										ID</label> -->
									<div class="col-sm-4">

										<input type="text" class="form-control contactId"
											id="ContactID" value="${contactDetails.contactId}" style="display:none;"
											placeholder="Contact ID" />

									</div>

								</div>
								
								
								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Type </label>
									<div class="col-sm-4">
										<input type="text" disabled class="form-control contactType"
											id="ContactType" value="Vendor"
											placeholder="Contact Type">
									</div>
									
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										First Name</label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactFirstName"
											id="ContactFirstName"
											value="${contactDetails.contactFirstName}"
											placeholder="Contact First Name">
									</div>
								
								</div>


								

								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Middle Name</label>
									<div class="col-sm-4">
										<input type="text"
											class="form-control contactMiddleName"
											id="ContactMiddleName"
											value="${contactDetails.contactMiddleName}"
											placeholder="Contact Middle Name">
									</div>

									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Last Name</label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactlastName"
											id="ContactLastName"
											value="${contactDetails.contactlastName}"
											placeholder="Contact Last Name">
									</div>
								</div>

								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label" >Contact
										Company Number</label>
									<div class="col-sm-4" >
										<input type="text"
											class="form-control contactCompanyNumber" id="fname"
											value="${contactDetails.contactCompanyNumber}"
											placeholder="Contact Company Number">
									</div>

									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Company</label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactCompany"
											id="ContactCompany"
											value="${contactDetails.contactCompany}"
											placeholder="Contact Company">
									</div>

								
									
								</div>
								<div class="form-group row">
								    <label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Contact
										Email ID </label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactEmailId"
											id="ContactEmailID"
											value="${contactDetails.contactEmailId}"
											placeholder="Contact Email ID">
									</div>
								  
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label ">Contact
										Phone </label>
									<div class="col-sm-4">
										<input type="text" class="form-control contactPhone"
											id="ContactPhone"
											value="${contactDetails.contactPhone}"
											placeholder="Contact Phone">
									</div>
								</div>


								<div class="form-group row"> 

                                      <label for="fname"
										class="col-sm-2 text-right control-label col-form-label">
										Bot ID</label>
									<div class="col-sm-4">
										<%-- <input type="text" class="form-control botId" id=""
											value="${contactDetails.botId}" placeholder="Bot ID"> --%>
											
											<select class="form-control botId" >
											<option value="">SELECT</option>
											<c:forEach items="${botDetails}" var="botDetails">
											<option value="${botDetails.botId}" <c:if test="${botDetails.botId == contactDetails.botId}">Selected</c:if>>${botDetails.botId}</option>
											</c:forEach>
											</select>
											
											
									</div>
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">Bank
										Account Code </label>
									<div class="col-sm-4">
										<input type="text" class="form-control bankAccountCode"
											id="BankAccountCode"
											value="${contactDetails.bankAccountCode}"
											placeholder="Bank Account Code">
									</div>
								</div>


								<div class="form-group row">
									<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">
										Bank Account</label>
									<div class="col-sm-4">
										<input type="text" class="form-control bankAccount"
											id="BankAccount" value="${contactDetails.bankAccount}"
											placeholder="Bank Account">
									</div>
								<label for="fname"
										class="col-sm-2 text-right control-label col-form-label">
										Bank Account Number</label>
									<div class="col-sm-4">
										<input type="text"
											class="form-control bankaccountNumber"
											id="BankAccountNumber"
											value="${contactDetails.bankaccountNumber}"
											placeholder="Bank Account Number">
									</div>
									
									
									</div>


								<div class="form-group row">
									
                                  <label for="fname"
										class="col-sm-2 text-right control-label col-form-label">VAT
										Reg No </label>
									<div class="col-sm-4">
										<input type="text" class="form-control vatRegno"
											id="VATRegNo" value="${contactDetails.vatRegno}"
											placeholder="VAT Reg No">
									</div>

								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- ends of start invoice information -->
				<div class="tab-pane fade" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Site Details</h5>
								<div class="table-responsive tableFixHead">

									<table id=""
										class="table table-striped table-bordered myTable2">

										<thead>
											<tr>
                                                <th><b>Site Type</b></th>
												<th><b>Site Use ID</b></th>
												<th style="display: none"><b>Contact Company Number</b></th> 
                                                <th><b>Location ID</b></th>
                                                <th><b>Operation Unit</b></th>
												<th><b>Address Line1</b></th>
												<th><b>Address Line2</b></th>
												<th><b>Address Line3 </b></th>
												<th><b>Address Line4</b></th>
												<th><b>Address City</b></th>
												<th><b>Address State</b></th>
												<th><b>Address Postal Code</b></th>
												<th><b>Address Country</b></th>
												<th><b></b></th>
                                               	</tr>

										</thead>

										<tbody id="tableBody">
									     <c:forEach items="${cSites}" var="il">
                                                	<tr class="dynamicRowLine">
                                                    <td contenteditable='true'>${il.siteType}</td>
													<td contenteditable='true'>${il.siteUseId}</td>
													<td style="display: none" contenteditable='true'>${il.contactCompanyNumber}</td>
													<td contenteditable='true'>${il.locationId}</td>
													<td contenteditable='true'><select>
														  		<option value="">SELECT</option>
																<c:forEach items="${RegionDetailList}" var="operatingUnitID">																						
															 	<option value="${operatingUnitID.operatingUnitId}" <c:if test="${il.operatingUnit == operatingUnitID.operatingUnitId}">selected</c:if>> ${operatingUnitID.operatingUnit}   </option>
																</c:forEach>
															</select>
														
															</td>
													<td contenteditable='true'>${il.addressLine1}</td>
													<td contenteditable='true'>${il.addressLine2}</td>
													<td contenteditable='true'>${il.addressLine3}</td>
													<td contenteditable='true'>${il.addressLine4}</td>
													<td contenteditable='true'>${il.addressCity}</td>
													<td contenteditable='true'>${il.addressState}</td>
													<td contenteditable='true'>${il.addressPostalCode}</td>
													<td contenteditable='true'>${il.addressCountry}</td>
													<td>
														<button type="button" class="btn btn-danger btn-sm"
															data-toggle="modal"
															data-target="#updateDeleteModal${il.siteUseId}">Delete</button>

													</td>
												</tr>
												
												<!-- Start Of Modal  -->
													<div class="modal fade" id="updateDeleteModal${il.siteUseId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
						                                    <div class="modal-dialog" role="document ">
						                                        <div class="modal-content">
						                                            <div class="modal-header">
						                                                <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
						                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						                                                    <span aria-hidden="true ">&times;</span>
						                                                </button>
						                                            </div>
						                                            <form action="deleteContactSite" method="POST">
						                                            <div class="modal-body">
																		<div class="card-body col-sm-12 text-center">Do you really want to delete...?</div>
																		<input type="hidden" name="siteUseId" value="${il.siteUseId}"/>
																		<input type="hidden" name="contactCompanyNumber" value="${il.contactCompanyNumber}"/>
																		<input type="hidden" name="siteType" value="${il.siteType}"/>
																		<input type="hidden" name="contactId" value="${contactDetails.contactId}"/>
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
									<span style="margin-left: 20px;"><button
											type="button"
											class="btn btn-danger btn-sm btnAddVendor">Add
											Line</button></span>

								</div>

							</div>
						</div>
					</div>

				</div>

			</div>


			<div class="border-top">
				<div class="card-body">
					<c:if test="${editAccess=='1'}">
						<button type="button" class="btn btn-info "
							data-toggle="modal" data-target="#updateConfirmModal">Update</button>
					</c:if>
					<c:if test="${approveAccess=='1' || approval10000=='1'}">

						<button type="button" class="btn btn-info"
							data-toggle="modal" data-target="#approveConfirmModal">Approve</button>
					</c:if>
					<c:if test="${editAccess=='1' && approveAccess=='1'}">

						<button type="button" class="btn btn-info btn-reject"
							data-toggle="modal" data-target="#rejectConfirmModal">Reject</button>
					</c:if>

				</div>
			</div>
		<%-- </form> --%>


	</c:when>
</c:choose>

</div>

<%-- <div class="col-sm-5 col-xs-5">
	<iframe class="embed-responsive-item" src="${filePath}"></iframe>
</div>
<div class="col-sm-5"></div>
<label for="fname"
	class="col-sm-2 text-right control-label col-form-label">
</label> --%>
<%-- <div class="col-sm-5">
	<input style="margin-top: -35px;" type="text"
		class="form-control fileName" id="fname" value="${fileName}"
		placeholder="File Name Here" disabled>
</div> --%>
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
<!-- <div class="row">
	<div class="col-12">
		<div class="card"></div>
	</div>
</div> -->
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


	<div class="modal fade" id="approveConfirmModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
					<div class="card-body col-sm-12 text-center">Do you really
						want to approve ?</div>
					<div class="card-body col-sm-12 text-center">
						<button type="button" name="action" data-dismiss="modal"
							class="btn btn-sm btn-primary btn-approved">Yes</button>
						<button type="button" class="btn btn-sm btn-secondary"
							data-dismiss="modal">No</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
		<div class="modal fade" id="approveConfirmModaljquery" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
						<span id="duplicateIdSpanApprove"></span>
					</div>
					<div class="card-body col-sm-12 text-center">
						<button type="button" class="btn btn-sm btn-primary"
							data-dismiss="modal"  onclick="location.reload();">Ok</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade " id="updateConfirmModaljquery" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
		<div class="modal-dialog" role="document ">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Alert</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" >
						<span aria-hidden="true ">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="card-body col-sm-12 text-center">
						<span id="duplicateIdSpanUpdate"></span>
					</div>
					<div class="card-body col-sm-12 text-center">
						<button type="button" class="btn btn-sm btn-primary"
							data-dismiss="modal" onclick="location.reload();">Ok</button>
					</div>
				</div>
			</div>
		</div>
	</div>




	<div class="modal fade" id="updateConfirmModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
					<div class="card-body col-sm-12 text-center">Do you really
						want to update ?</div>
					<div class="card-body col-sm-12 text-center">
						<button type="button" name="action" data-dismiss="modal"
							class="btn btn-sm btn-primary btn-update">Yes</button>
						<button type="button" class="btn btn-sm btn-secondary"
							data-dismiss="modal">No</button>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="rejectConfirmModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
					<div class="card-body col-sm-12 text-center">Do You Really
						Want To Reject ? If Yes Please Enter Rejection Comments Below</div>
					<div class=" col-sm-12 text-center">
						<!-- <input type="text" id="reason" class="form-control"
							id="fname" placeholder="Enter Reason Here"> -->

						<textarea id="reason" class="form-control "></textarea>
					</div>

					<div class="card-body col-sm-12 text-center">
						<button type="button" name="action" data-dismiss="modal"
							class="btn btn-sm btn-primary btnReject">Yes</button>
						<button type="button" class="btn btn-sm btn-secondary"
							data-dismiss="modal">No</button>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="duplicateConfirmModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
	<!-- Modal for update -->


	<div class="modal fade " id="updateConfirmModaljquery" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
						<span id="duplicateIdSpanUpdate"></span>
					</div>
					<div class="card-body col-sm-12 text-center">
						<button type="button" class="btn btn-sm btn-primary"
							data-dismiss="modal" onclick="location.reload();">Ok</button>
					</div>
				</div>
			</div>
		</div>
	</div>





	<div class="modal fade" id="approveConfirmModaljquery" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
						<span id="duplicateIdSpanApprove"></span>
					</div>
					<div class="card-body col-sm-12 text-center">
						<button type="button" class="btn btn-sm btn-primary"
							data-dismiss="modal" onclick="location.reload();">Ok</button>
					</div>
				</div>
			</div>
		</div>
	</div>




	<div class="modal fade" id="rejectConfirmModaljquery" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true ">
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
						<span id="duplicateIdSpanReject"></span>
					</div>
					<div class="card-body col-sm-12 text-center">
						<button type="button" class="btn btn-sm btn-primary"
							data-dismiss="modal" onclick="location.reload();">Ok</button>
					</div>
				</div>
			</div>
		</div>
	</div>


<!-- ============================================================== -->
<!-- End Wrapper -->


<!-- Model -->
<!-- Modal -->
<!-- Modal -->
<!-- Start Of Progress  -->
<div id="loader"></div>
<!-- End Of Progress
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
$('#zero_config_audit').DataTable();
//$('#zero_config_poLine').DataTable();
</script>
</body>

</html>