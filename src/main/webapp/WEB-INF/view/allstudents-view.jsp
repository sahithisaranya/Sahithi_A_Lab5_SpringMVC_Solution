<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>College Fest Debate Registrations</title>
</head>

<body>

	<div class="container">

		<h3 style="color:Purple;font-weight:bold">College-Fest Debate Participation List</h3>
		<hr>

		<!-- Add a search form -->

		<form action="/Lab5_SpringMVC_CollegeFest/" class="form-inline">

			<!-- Add a button -->
			<a href="/Lab5_SpringMVC_CollegeFest/registerStudent"
				class="btn btn-primary btn-sm mb-3"> Register Student </a> 


		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="newStudent">
					<tr>
						<td><c:out value="${newStudent.name}" /></td>
						<td><c:out value="${newStudent.department}" /></td>
						<td><c:out value="${newStudent.country}" /></td>
						<td>
							<!-- Add "update" button/link --> 
							<a href="/Lab5_SpringMVC_CollegeFest/updateStudent?studentId=${newStudent.studentId}" class="btn btn-info btn-sm"> Update </a> 
							<!-- Add "delete" button/link -->
							<a href="/Lab5_SpringMVC_CollegeFest/deleteStudent?studentId=${newStudent.studentId}" class="btn btn-danger btn-sm"
								onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete </a>
						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>



