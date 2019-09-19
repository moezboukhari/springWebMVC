<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="css" value="/resources/css" />
<!DOCTYPE html>

<html>
<head>

<meta charset="ISO-8859-1">
<title>list</title>
</head>
<link href="${css}/bootstrap.css" rel="stylesheet" />
<body>
	<fieldset>
		<legend>Users</legend>
		<div class="col-md-8">
			<table class="table table-striped table-bordered">
				<thead class="bg-secondary">
					<tr class="text-strong">
						<th>User Id</th>
						<th>User Name</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:choose>
						<c:when test="${fn:length(users) > 0}">
							<c:forEach items="${users}" var="user">

								<tr>
									<td>${user.userId}</td>
									<td>${user.userName}</td>
									<td><a href="/springWebMVC/user/edit/${user.id }"><span
											class="btn btn-outline-warning">Edit</span></a></td>
											
									<td>
										<form:form action="/springWebMVC/user/delete/${user.id }" method="DELETE">
										<input type="hidden" name="_method" value="DELETE"/>
											<button type="submit" class="btn btn-outline-danger">Delete</button>
										</form:form>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td><h3>No Users !!</h3></td>
							</tr>
						</c:otherwise>

					</c:choose>
				</tbody>

				<tfoot>

					<tr class="text-right">

						<th colspan="4" align="right"><a
							href="/springWebMVC/user/add"><span
								class="btn btn-outline-success">Add User</span></a></th>
					</tr>
				</tfoot>
			</table>
		</div>
	</fieldset>
</body>
</html>