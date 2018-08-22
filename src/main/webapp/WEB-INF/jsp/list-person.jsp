<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of person</title>
<c:url value="/resources/js/pagination.js" var="pagination" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<!-- include file listpersionContrller.js -->
<script src="${pagination}"></script>
<style>
<%@ include file="/WEB-INF/css/footer.css"%>
</style>
</head>
<body>
    <!-- include header -->
    <%@ include file="/WEB-INF/jsp/share/header.jsp" %>
    <!-- include navbar -->
    <%@ include file="/WEB-INF/jsp/share/navbar.jsp"%>
	<div id=paging-pages>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th id="hName">Name</th>
					<th id="hAge">Age</th>
					<th>Sex</th>
					<th>Type Code</th>
					<th>View Detail</th>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody id="rows">
			</tbody>
		</table>
		<ul id="pages" class="pagination">
			<li class="pageInfo" style="font-size: 20">Page 1 of 10</li>
			<li id="goPrevios"><button class="btn">Previous</button></li>
			<li><input class="form-control" type="text" id="currentPage" /></li>
			<li id="goNext"><button class="btn">Next</button></li>
		</ul>
	</div>
	<!-- include footer -->
	<%@ include file="/WEB-INF/jsp/share/footer.jsp" %>
</body>
</html>