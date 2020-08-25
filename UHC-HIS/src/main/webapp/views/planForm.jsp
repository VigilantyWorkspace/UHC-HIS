<%@include file="pageHeader.jsp"%>
	<div class="container"
		style="background-color: rgba(205, 220, 57, 0.1);">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>PLAN FORM</H3>
			</div>

			<div class="card-body" style="background-color: #e4bc838c;">
				<form:form action="storePlan" method="POST"
												 modelAttribute="plan">
					<form:hidden path="plan_id"/>
					<div class="row">
						<div class="col-4">
							<label for="planName">Plan Name</label>
						</div>

						<div class="col-4">
							<form:input path="planName"/>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="planDesc">Plan Description</label>
						</div>

						<div class="col-4">
							<form:textarea path="planDesc" style="overflow:auto;resize:none" rows="6" cols="40"/>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="plan_start_date">Plan Start Date</label>
						</div>

						<div class="col-4">
							<form:input type="date" path="plan_start_date"/>
						</div>
						<div class="col-4">
							<!-- Error Message -->
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="plan_end_date">Plan End Date</label>
						</div>

						<div class="col-4">
							<form:input type="date" path="plan_end_date" />
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
				<font color='green'>${successMsg}</font>
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