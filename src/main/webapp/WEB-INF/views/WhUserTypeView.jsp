<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<H3>WELCOME TO WH USER TYPE VIEW PAGE</H3>
	<a href="excel?id=${ob.whId}"><img
		src="../resources/images/Excel.png" height="40" width="40"></a>
	<a href="pdf?id=${ob.whId}"><img src="../resources/images/pdf.png"
		height="40" width="40"></a>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.whId}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.userType}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.userCode}</td>
		</tr>
		<tr>
			<th>FOR</th>
			<td>${ob.userFor}</td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td>${ob.mail}</td>
		</tr>
		<tr>
			<th>CONTACT</th>
			<td>${ob.uomContact}</td>
		</tr>
		<tr>
			<th>ID TYPE</th>
			<td>${ob.userIDType}</td>
		</tr>
		<tr>
			<th>IF OTHER</th>
			<td>${ob.ifOther}</td>
		</tr>
		<tr>
			<th>ID NUM</th>
			<td>${ob.idNumber}</td>
		</tr>
	</table>
</body>
</html>