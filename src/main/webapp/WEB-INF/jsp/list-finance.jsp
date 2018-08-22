<%@ page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8">
<spring:url value="/resources/js/financeController.js" var="financeController" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="${financeController}"></script>
<style>
<%@ include file="/WEB-INF/css/footer.css"%>
</style>
</head>
<body>
	<!-- include header -->
	<%@ include file="/WEB-INF/jsp/share/header.jsp"%>
	<!-- include navbar -->
	<%@ include file="/WEB-INF/jsp/share/navbar.jsp"%>
	<br />
	<select id="mySelect">
		<option value="pw">Trả lương</option>
		<option value="tax">Thuế</option>
		<option value="bonus">Thưởng</option>
		<option value="pb">Hóa đơn</option>
	</select>
	<button id="btnSearch" class="btn-primary" >Search</button>
	<br />
	<br />
	<table id="myTable" class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Type</th>
				<th>Person ID</th>
				<th>Description</th>
				<th>Money</th>
			</tr>
		</thead>
		<tbody id="rows"></tbody>
	</table>
	<br />
	<span id="val"></span>
	<br />
	<button id="btnSum" class="btn">Sum Money</button>
	<br />
	<!-- include footer -->
	<%@ include file="/WEB-INF/jsp/share/footer.jsp" %>
</body>
</html>