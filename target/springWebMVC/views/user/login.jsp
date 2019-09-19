<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<fieldset>
		<legend>Login</legend>
		<form:form action="/springWebMVC/user/authenticate" modelAttribute="userForm" method="post" >
		
		<table class="bordered">
			
			<tbody>
			     <tr>
                <td>User Id</td> 
                <td><form:input type="text" path="userId" placeholder="Enter the user id"/></td>
               </tr>
               <tr>
                <td>password</td>
                 <td><form:input type="password" path="password" placeholder="Enter the password"/></td>
               </tr>         
               
			</tbody>
		</table>
		<td colspan="2">
		 <button type="submit" >login</button>
		 </td>
		</form:form>
	</fieldset>
</body>
</html>