<%@include file="pageHeader.jsp"%>
<script>
		function confirmDelete(){
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
	<div class="container" style="background-color: rgba(205, 220, 57, 0.1);">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>All Account Details</H3>
			</div>
			<div class="card-body" >
			<a class="btn btn-outline-primary my-2 my-sm-0" href="filterResult">Filter User By Role</a>
		<c:choose>
			<c:when test="${!empty userDetailsList }">
			<table  class="table table-bordered table-hover display" id="contact_table" style="width:100%">
				<tr class="bg-success text-white">
					<th>Sl.No.</th>
					<th>Joining Date</th>
                     <th>First Name</th>
                     <th>Last Name</th>
                     <th>Contact No.</th>
                     <th>Email-Id</th>
                     <th>Role</th>
                     <th colspan="2">Action</th>
					 
				</tr>
				<c:forEach items="${userDetailsList}" var="userDetailsList" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${userDetailsList.createdDate}</td>
						<td>${userDetailsList.firstName}</td>
						<td>${userDetailsList.lastName}</td>
						<td>${userDetailsList.contact_no}</td>
						<td>${userDetailsList.email}</td>
						<td>${userDetailsList.roleName}</td>
						
						<td>
							<a class="btn btn-warning" href="editUser?user_id=${userDetailsList.user_id}">EDIT</a>
						|
							<%-- <c:choose>
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
                            </c:choose> --%>
                            <c:choose>
								<c:when test="${userDetailsList.deleteStatus eq 'N'}">
		
									<button class="btn btn-warning"><a href="deleteUser?user_id=${userDetailsList.user_id}"
										onClick="return confirmDelete()">DELETE</a></button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-light"><a href="activeUser?user_id=${userDetailsList.user_id}" onClick="return confirmActive()">ACTIVATE</a></button>
									
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			</c:when>
			<c:otherwise>
				<H4><font color='red'>NO DATA FOUND!!</font></H4>
			</c:otherwise>
		</c:choose>
		</div>
			
		</div> <!-- card end -->	
	</div><!-- container end -->
	
</body>
</html>