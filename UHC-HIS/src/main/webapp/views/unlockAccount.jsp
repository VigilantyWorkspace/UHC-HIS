<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HIS-App</title>

</head>
<body>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">

	<script src="resources/js/jquery-3.4.1.slim.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">

	<script type="text/javascript">
		function validatesPwd(){
			let val1=$("#newPwd").val();
			let val2=$("#confirmPwd").val();
			if(val1 != val2){
					$("#error").text('Passwords Not Matched');
					return false;
			}
			else{
					return true;
			}
		};
	</script>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">UHC-HIS APP</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">HOME
						<span class="sr-only">(current)</span>
				</a></li>

				<!-- one option start-->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> ACCOUNTS </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="addUser">CREATE ACCOUNT</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="viewUsers">VIEW ACCOUNT'S DETAILS</a>
					</div></li>
				<!-- one option end -->

			</ul>
		</div>
	</nav>
	<div class="container"
		style="background-color: rgba(205, 220, 57, 0.1);">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>USER UNLOCK FORM</H3>
			</div>

			<div class="card-body">
				<form:form class="login100-form validate-form" action="unlockUserAcc" method="POST" modelAttribute="unLockBind">
					
		
					
					<h3 style="color: red;"> ${errorMsg}</h3>
					<div class="col-4">
						<label for="email">Email-id</label>
					</div>
					<div >
						<form:input  type="text" path="email"  value="${mail}" readonly="true"/>
					</div>

					<div class="col-4">
						<label for="tempPwd">OTP RECIEVED</label>
					</div>
					<div class="wrap-input100 " data-validate = "Enter password">
						<form:input class="input100" type="text" path="tempPwd" value="${otp}"/>
						 <span class="focus-input100" data-placeholder="&#xf191;"></span> 
					</div>


					<div class="col-4">
						<label for="newPwd">Enter New Password</label>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<form:input class="input100" type="password" path="newPwd" placeholder="Password"/>
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="col-4">
						<label for="confirmPwd">Confirm Password</label>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<form:input class="input100" type="password" path="confirmPwd" placeholder="ConfirmPassword"/>
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>
		
		
					<div class="container-login100-form-btn">
						<button class="btn btn-primary" onclick="return validatesPwd()">
							UNLOCK
						</button>
					</div>
		
				</form:form>
			</div>
			
			<!-- end of body -->
			<!-- Message-->
			<div>
				<font color='green'>${msg}</font>
			</div>
			<div>
				<font color='red'>${errorMsg}</font>
			</div>
		</div>
		<!-- End of card -->
	</div>
	<!-- container end -->
</body>
</html>