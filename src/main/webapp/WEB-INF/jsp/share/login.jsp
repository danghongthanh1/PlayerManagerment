<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="${loginUrl}" method="post">
	<c:if test="${param.error != null}">
		<p>Invalid username and password.</p>
	</c:if>
	<c:if test="${param.logout != null}">
		<p>You have been logged out.</p>
	</c:if>
	<p>
		<label for="username">Username</label> 
		<input type="text" id="username" name="username" />
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password" />
	</p>
	<input type="hidden" 
	 	name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<button type="submit" class="btn">Log in</button>
</form>