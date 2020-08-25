<%@include file="pageHeader.jsp"%>
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