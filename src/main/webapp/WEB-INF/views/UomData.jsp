<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>

	<H3>WELCOME TO UOM DATA PAGE</H3>

	<c:choose>
		<c:when test="${!empty list }">

			<table border="1">
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>MODEL</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>

				<!-- 	for(Uom ob;list){} -->
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.uomId}</td>
						<td>${ob.uomType}</td>
						<td>${ob.uomModel}</td>
						<td>${ob.uomModel}</td>
						<td><a href="delete?uid=${ob.uomId}">Delete</a></td>
						<td><a href="edit?uid=${ob.uomId}">Edit</a></td>
						<td><a href="view?uid=${ob.uomId}">View</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<H4>NO DATA FOUND!</H4>
		</c:otherwise>
	</c:choose>
</body>
</html>