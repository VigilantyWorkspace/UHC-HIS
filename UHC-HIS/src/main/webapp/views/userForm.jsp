<%@include file="pageHeader.jsp"%>
	<div class="container"
		style="background-color: rgba(205, 220, 57, 0.1);">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>USER FORM</H3>
			</div>

			<div class="card-body" style="background-color: #e4bc838c;">
				<form:form action="storeUser" method="POST"
												 modelAttribute="user">
					<form:hidden path="user_id"/>
					<div class="row">
						<div class="col-4">
							<label for="firstName">First Name</label>
						</div>

						<div class="col-4">
							<form:input path="firstName"/>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="lastName">Last Name</label>
						</div>

						<div class="col-4">
							<form:input path="lastName"/>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="gender">Gender</label>
						</div>

						<div class="col-4">
							<form:radiobutton path="gender" value="male"/>Male
							<form:radiobutton path="gender" value="female"/>Fe-Male
							<form:radiobutton path="gender" value="others"/>Others
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="email">User Email Address</label>
						</div>

						<div class="col-4">
							<form:input path="email" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<label for="contact_no">Contact Number</label>
						</div>

						<div class="col-4">
							<form:input path="contact_no" />
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="roleName">Account Role</label>
						</div>

						<div class="col-4">
							<form:select path="roleName">
								<form:option value="">Select Role</form:option>
								<form:option value="ADMIN">ADMIN</form:option>
								<form:option value="CASE-WORKER">CASE-WORKER</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<input type="submit" value="Save" class="btn btn-primary" /> 
							<input type="reset" value="Reset" class="btn btn-danger" />
						</div>
					</div>

				</form:form>
			</div>
			
			<!-- end of body -->
			<!-- Message-->
			<div>
				
				<c:if test="${!empty msg}">
				<div class="card-footer bg-info text-white text-center p-1">
					<h3><font color='green'>${msg}</font></h3>
					<!-- <h3>
						<a
							href="send?url=https://accounts.google.com/AccountChooser/signinchooser?flowName=GlifWebSignIn&flowEntry=AccountChooser/">click
							here to Check your Mail...</a>
					</h3> -->
				</div>
			</c:if>
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