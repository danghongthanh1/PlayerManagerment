<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<title>List Employee</title>
<style>

</style>
</head>
<body>
	<table id="myTable">
		<tr>
			<th>ID</th>
			<th onclick="sortTableByName()">Name</th>
			<th onclick="sortTable()">Age</th>
			<th>Sex</th>
			<th>Type Code</th>
			<th>Avatar</th>
		</tr>
		<c:if test="${not empty ListEmployee}">
			<c:forEach var="employee" items="${ListEmployee}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.getName()}</td>
					<td>${employee.getAge()}</td>
					<td>${employee.getSex()}</td>
					<td>${employee.getTypeCode()}</td>
					<td><a href="viewAvatar/${employee.id}">ViewAvatar</a></td>
					<td><a href="employee/edit/${employee.id}">Edit</a></td>
					<td><a href="delete/${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<script>
		
	</script>
</body>
</html>