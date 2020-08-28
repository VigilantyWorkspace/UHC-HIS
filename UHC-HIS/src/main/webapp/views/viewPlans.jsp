<%@include file="pageHeader.jsp"%>
<script>
	function confirmDelete() {
		return confirm("Are you sure ,U want to Change?");
	}

	function confirmActive() {
		return confirm("Are you sure, U want to Active?");
	}

	/* $(document).ready(function() {
	    $('#contact_table').DataTable( {
	        "pagingType": "full_numbers"
	    } );
	} ); */
</script>
<div class="container"
	style="background-color: rgba(205, 220, 57, 0.1);">
	<div class="card">
		<div class="card-header bg-primary text-white text-center">
			<H3>All Plan Details</H3>
		</div>
		<div class="card-body">

			<c:choose>
				<c:when test="${!empty planDetailsList }">
					<table class="table table-bordered table-hover display"
						id="contact_table" style="width: 100%">
						<tr class="bg-success text-white">
							<th>Sl.No.</th>
							<th>Plan Name</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th colspan="2">Action</th>

						</tr>
						<c:forEach items="${planDetailsList}" var="planDetailsList"
							varStatus="index">
							<tr>
								<td>${index.count}</td>
								<td>${planDetailsList.planName}</td>
								<td>${planDetailsList.plan_start_date}</td>
								<td>${planDetailsList.plan_end_date}</td>

								<td><a class="btn btn-warning"
									href="editPlan?plan_id=${planDetailsList.plan_id}">EDIT</a> | <%-- <c:choose>
                               	<c:when test="${'TRUE' eq userDetailsList.isActive() }">
									<a class="btn btn-warning"  href="deleteUser?user_id=${userDetailsList.user_id}" onclick="return confirmSoftDelete()">
										<b class="text-success">ACTIVE</b>
									</a>
								</c:when>
							
								<c:when test="${'FALSE' eq userDetailsList.isActive() }">
									<a class="btn btn-warning" href="deleteUser?user_id=${userDetailsList.user_id}" onclick="return confirmActive()">
										<b class="text-danger">DE-ACTIVATED</b>
									</a>
								</c:when>
                            </c:choose> --%> <c:choose>
										<c:when test="${planDetailsList.deleteStatus eq 'N'}">

											<button class="btn btn-warning">
												<a href="deletePlan?plan_id=${planDetailsList.plan_id}"
													onClick="return confirmDelete()">DELETE</a>
											</button>
										</c:when>
										<c:otherwise>
											<button class="btn btn-light">
												<a href="activePlan?plan_id=${planDetailsList.plan_id}"
													onClick="return confirmActive()">ACTIVATE</a>
											</button>

										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</table>


					<div th:if="${totalPages > 1}">
						<div class="row col-sm-10">
							<div class="col-sm-2">Total Rows: [[${totalItems}]]</div>
							<div class="col-sm-1">
								<span th:each="i: ${#numbers.sequence(1, totalPages)}"> <a
									th:if="${currentPage != i}" th:href="@{'/planpage/' + ${i}}">[[${i}]]</a>
									<span th:unless="${currentPage != i}">[[${i}]]</span> &nbsp;
									&nbsp;
								</span>
							</div>
							<div class="col-sm-1">
								<a th:if="${currentPage < totalPages}"
									th:href="@{'/planpage/' + ${currentPage + 1}}">Next</a> <span
									th:unless="${currentPage < totalPages}">Next</span>
							</div>

							<div class="col-sm-1">
								<a th:if="${currentPage < totalPages}"
									th:href="@{'/planpage/' + ${totalPages}}">Last</a> <span
									th:unless="${currentPage < totalPages}">Last</span>
							</div>
						</div>
					</div>


				</c:when>
				<c:otherwise>
					<H4>
						<font color='red'>NO DATA FOUND!!</font>
					</H4>
				</c:otherwise>
			</c:choose>
		</div>

	</div>
	<!-- card end -->
</div>
<!-- container end -->

</body>
</html>