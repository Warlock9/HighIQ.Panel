
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% 
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>

<!DOCTYPE html>
<html dir="ltr">

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
<title>HighIQ.ai - User Login</title>
<!-- Custom CSS -->
<link href="${contextPath}/resources/dist/css/style.min.css"
	rel="stylesheet">
<link
	href="${contextPath}/resources/assets/libs/toastr/build/toastr.min.css"
	rel="stylesheet">

</head>

<body>
	<div class="main-wrapper">

		<!-- ============================================================== -->
		<!-- Preloader - style you can find in spinners.css -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Login box.scss -->
		<!-- ============================================================== -->
		<div
			class="auth-wrapper d-flex no-block justify-content-center align-items-center bg-dark">
			<div class="auth-box bg-dark border-top border-secondary">
				<div id="loginform">
					<div class="text-center p-t-20 p-b-20">
					<a class="navbar-brand" href="dashboard"> <b
						class="logo-icon p-l-10"> <img
							src="${contextPath}/resources/assets/images/logo-icon.png"
							alt="homepage" class="light-logo" />
					</b> <span class="logo-text"> <img
							src="${contextPath}/resources/assets/images/logo-text.png"
							alt="homepage" class="light-logo" />
					</span>
					</a>
					</div>
					<!-- Form -->
					<form class="form-horizontal m-t-20" id="loginform"
						action="userLogin.do" method="POST">
						<div class="row p-b-30">
							<div class="col-12">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text bg-success text-white"
											id="basic-addon1"><i class="ti-user"></i></span>
									</div>
									<input type="text" name="userName"
										class="form-control form-control-lg" placeholder="User Name Here"
										aria-label="Username" aria-describedby="basic-addon1"
										required>
								</div>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text bg-warning text-white"
											id="basic-addon2"><i class="ti-pencil"></i></span>
									</div>
									<input type="password" name="password"
										class="form-control form-control-lg" placeholder="Password"
										aria-label="Password" aria-describedby="basic-addon1"
										required>
								</div>
							</div>
						</div>
						<div class="row border-top border-secondary">
							<div class="col-12">
								<div class="form-group">
									<div class="p-t-20">
										<!-- 										<button class="btn btn-info" id="to-recover" type="button">
											<i class="fa fa-lock m-r-5"></i> Lost password?
										</button> -->
										<button class="btn btn-success float-right" type="submit"
											name="action" value="save">Login</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div id="recoverform">
					<div class="text-center">
						<span class="text-white">Enter your e-mail address below
							and we will send you instructions how to recover a password.</span>
					</div>
					<div class="row m-t-20">
						<!-- Form -->
						<form class="col-12" action="index.html">
							<!-- email -->
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text bg-danger text-white"
										id="basic-addon1"><i class="ti-email"></i></span>
								</div>
								<input type="text" class="form-control form-control-lg"
									placeholder="Email Address" aria-label="Username"
									aria-describedby="basic-addon1">
							</div>
							<!-- pwd -->
							<div class="row m-t-20 p-t-20 border-top border-secondary">
								<div class="col-12">
									<a class="btn btn-success" href="#" id="to-login" name="action">Back
										To Login</a>
									<button class="btn btn-info float-right" type="button"
										name="action">Recover</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- Login box.scss -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper scss in scafholding.scss -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper scss in scafholding.scss -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Right Sidebar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Right Sidebar -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- All Required js -->
	<script
		src="${contextPath}/resources/assets/libs/jquery/dist/jquery.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/popper.js/dist/umd/popper.min.js"></script>
	<script
		src="${contextPath}/resources/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>

	<script
		src="${contextPath}/resources/assets/libs/toastr/build/toastr.min.js"></script>
	<c:choose>
		<c:when test="${userCredentials== 'incorrect'}">
        	<script>
				toastr.error('', 'Email Id or Password is Incorrect !');
			</script>
		</c:when>
	</c:choose>

	<script>
		$('[data-toggle="tooltip"]').tooltip();
		$(".preloader").fadeOut();
		// ============================================================== 
		// Login and Recover Password 
		// ============================================================== 
		$('#to-recover').on("click", function() {
			$("#loginform").slideUp();
			$("#recoverform").fadeIn();
		});
		$('#to-login').click(function() {

			$("#recoverform").hide();
			$("#loginform").fadeIn();
		});
		$('#ts-error').on('click', function() {
			toastr.error('', 'Email Id or Password is Incorrect !');
		});
	</script>

</body>

</html>