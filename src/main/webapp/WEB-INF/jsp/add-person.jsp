<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
<%@ include file="/WEB-INF/css/footer.css"%>
</style>
<title>Add employee</title>
</head>
<body>
    <!-- include header -->
    <%@ include file="/WEB-INF/jsp/share/header.jsp" %>
    <!-- include navbar -->
    <%@ include file="/WEB-INF/jsp/share/navbar.jsp"%>
	<h3>Add Employee</h3>
	<form:form action="addPerson" modelAttribute="person" method="POST" enctype="multipart/form-data">
		<label>Name :</label>
		<form:input path="name" class="form-control" placeholder="Enter full name"/>
		<br />
		<label>Age :</label>
		<form:input path="age" class="form-control" placeholder="Enter age"/>
		<br />
		<label>Sex :</label>
		<br/>
		<form:select path="sex" name="sex">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Otther">Other</option>
		</form:select>
		<br />
		<br />
		<label>TypeCode:</label>
		<br />
		<form:select path="typecode">
			<option value="CT">Cau Thu</option>
			<option value="HLV">Huan Luyen Vien</option>
			<option value="NV">Nhan Vien</option>
		</form:select>
		<br />
		<br />
		<label>Avatar</label>
		<br />
		<input type="file" name="file">
		<br />
		<br />
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	<!-- include footer -->
	<%@ include file="/WEB-INF/jsp/share/footer.jsp" %>
</body>
</html>