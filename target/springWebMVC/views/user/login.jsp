<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<fieldset>
		<legend>Login</legend>
		<form action="/springWebMVC/user/authenticate">
		<table class="bordered">
			
			<tbody>
			     <tr>
                <td>username</td> <td><input type="text" name="username"/></td>
               </tr>
               <tr>
                <td>password</td> <td><input type="text" name="password"/></td>
               </tr>         
               
			</tbody>
		</table>
		<td colspan="2">
		 <button type="submit" >login</button>
		 </td>
		</form>
	</fieldset>
</body>
</html>