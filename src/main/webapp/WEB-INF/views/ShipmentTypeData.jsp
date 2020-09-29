<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<h3>Welcome To Shipment Type Data</h3>
<body>
	<c:choose>
		<c:when test="${!empty list}">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>GRADE</th>
					<th>MODE</th>
					<th>ENABLE</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list}"  var="ob">
					<tr>
						<td>${ob.shipId}</td>
						<td>${ob.shipCode}</td>
						<td>${ob.shipGrade}</td>
						<td>${ob.shipMode}</td>
						<td>${ob.enbShip}</td>
						<td>${ob.shipDesc}</td>
						<td><a href="delete?sid=${ob.shipId}">Delete</a></td>
						<td><a href="edit?sid=${ob.shipId}">Edit</a></td>
						<td><a href="view?sid=${ob.shipId}">View</a></td>
					</tr>

				</c:forEach>
			</table>
			${massage} 
		</c:when>
		<c:otherwise>
			<H4>NO DATA FOUND</H4>
		</c:otherwise>
	</c:choose>

</body>
</html>