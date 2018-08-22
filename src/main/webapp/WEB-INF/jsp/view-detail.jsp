<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <title>View Avatar of ${person.name}</title> --%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<!-- include file listpersionContrller.js -->
<style>
img {
	width: 290px;
	height: auto;
}
<%@ include file="/WEB-INF/css/footer.css"%>
</style>
</head>
<body>
    <!-- include header -->
    <%@ include file="/WEB-INF/jsp/share/header.jsp" %>
    <!-- include navbar -->
    <%@ include file="/WEB-INF/jsp/share/navbar.jsp"%>
	<br />
	<div>
<%-- 	Full Name: ${person.name} --%>
	</div>
	<br />
	<div>
	 Age: ${person.age}
	 </div>
	<br />
	<div>
	Sex: ${person.sex}
	</div>
	<div>
		<img src="data:image/png;base64,${person.avatar}" alt="Avatar" />
	</div>
	<!-- include footer -->
	<%@ include file="/WEB-INF/jsp/share/footer.jsp" %>
</body>
</html>