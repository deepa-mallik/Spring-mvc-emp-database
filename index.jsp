<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee details</title>
</head>
<body>
	<form action = "empdb.html"  method = "post">
		<table>

	<tr>
		<td>Enter a id<td><input type=number name=t1 size=20 required>
	</tr> 
	
	<tr>
		<td>Enter a name<td><input type=text name=t2 size=20 required>
	</tr>
	
	<tr>
		<td>Enter a address<td><input type=text name=t3 size=20 required>
	</tr>
			
	<tr>
		<td>
			<td><input type=submit value=insert name=b1>
				<input type=submit value=update name=b1>
				<input type=submit value=delete name=b1>
				<input type=submit value=select name=b1>
	</tr>
</table>
</form>
</body>
</html>