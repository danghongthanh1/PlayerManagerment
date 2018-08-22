<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>login</title>
</head>
<body>
  <h1>Spring MVC-Security Login Form</h1>
  <h2>${message}</h2>
  <form name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
    <table>
      <tr>
        <td>User:</td>
        <td><input type='text' name='username'></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type='password' name='password' /></td>
      </tr>
      <tr>
        <td colspan='2'><input name="submit" type="submit" value="login" /></td>
      </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</body>
</html>