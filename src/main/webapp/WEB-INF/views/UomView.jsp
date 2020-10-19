<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Welcome To UOM View Page</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.uomId}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.uomType}</td>
		</tr>
		<tr>
			<th>MODEL</th>
			<td>${ob.uomModel}</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${ob.uomDesc}</td>
		</tr>
	</table>

</body>
</html>