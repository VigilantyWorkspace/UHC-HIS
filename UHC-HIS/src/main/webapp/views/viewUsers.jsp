<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>UHC-HIS-APP</title>
</head>
<body>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/jquery.dataTables.min.css">

	<script src="resources/js/jquery-3.4.1.slim.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.dataTables.min.js"></script>
	<script src="resources/js/jquery-3.5.1.js"></script>
	<script>
		function confirmSoftDelete(){
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

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">UHC-HIS App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="viewUsers">HOME
						<span class="sr-only">(current)</span>
				</a></li>

				<!-- one option start-->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="addUser" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> ACCOUNTS </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="addUser">ADD ACCOUNT</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="viewUsers">VIEW ACCOUNT'S DETAILS</a>
					</div></li>
				<!-- one option end -->

			</ul>
		</div>
	</nav>

	<div class="container" style="background-color: rgba(205, 220, 57, 0.1);">
		<div class="card">
			<div class="card-header bg-primary text-white text-center">
				<H3>All Account Details</H3>
			</div>
			<div class="card-body">
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
								<c:when test="${obj.deleteStatus eq 'null'}">
		
									<button class="btn btn-danger"><a href="delete?cid=${obj.regId}"
										onClick="return confirmDelete()">DElETE</a></button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-light"><a href="active?cid=${obj.regId}" onClick="return confirmActive()">ACTIVATE</a></button>
									
									
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