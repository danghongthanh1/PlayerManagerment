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
<title>Add Person by file excel</title>
</head>
<body>
    <!-- include header -->
    <%@ include file="/WEB-INF/jsp/share/header.jsp" %>
    <!-- include navbar -->
    <%@ include file="/WEB-INF/jsp/share/navbar.jsp"%>
    <form:form action="uploadExcelFile" method="POST" enctype="multipart/form-data">
    <br />
    <label>Excel File</label>
    <br />
    <input type="file" name="file" accept=".xls,.xlsx">
		<br />
		<br />
		<button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
    <!-- include footer -->
	<%@ include file="/WEB-INF/jsp/share/footer.jsp" %>
</body>
</html>