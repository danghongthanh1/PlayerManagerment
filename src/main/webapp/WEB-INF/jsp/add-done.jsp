<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
</style>
</head>
<body>
<div class=header>
		<h1 class=header>Employee Manangement</h1>
	</div>
	<div class="topnav">
		<a class="active" href="${pageContext.request.contextPath}/">Home</a>
		<div class="dropdown">
			<button class="dropbtn" onclick="showLinkE()">
				Employee <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content" id="myDropdwnE">
				<a href="employee/view-list">View list of employee</a> <a
					href="employee/search-employee">Search employee</a> <a
					href="employee/add-employee">Add employee</a> <a
					href="employee/add-avatar">Add avatar</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn" onclick="showLinkF()">
				Finance <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content" id="myDropdwnF">
				<a href="employee/manange-finance">Manage Finance</a>
			</div>
		</div>
		<a href="#about">About</a>
	</div>
	<div class="footer">
		<p>Design by Dang Hong Thanh in Vietnam</p>
		<a href="https://www.facebook.com/danghongthanh.hust">Contact Us</a>
	</div>
	<script>
		/* When the user clicks on the button, 
		 toggle between hiding and showing the dropdown content */
		function showLinkE() {
			document.getElementById("myDropdwnE").classList.toggle("show");
			
		}
		function showLinkF() {
			document.getElementById("myDropdwnF").classList.toggle("show");
			
		}

		// Close the dropdown if the user clicks outside of it
		window.onclick = function(event) {
			if (!event.target.matches('.dropbtn')) {

				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}
	</script>
	<h1>Congeturation!,You have Susesfully added ${name}</h1>
	<p><a href="view-list">View List of Employee</a></p>
</body>
</html>