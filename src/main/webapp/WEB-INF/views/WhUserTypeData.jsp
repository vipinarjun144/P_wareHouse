<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<H3>WELCOME TO WH USER TYPE DATA</H3>
	<c:choose>
		<c:when test="${!empty list }">
			<a href="excel"><img src="../resources/images/Excel.png"
				height="40" width="40"></a>
			<a href="pdf"><img src="../resources/images/pdf.png" height="40"
				width="40" /></a>
			<a href="charts"><img src="../resources/images/chart.png"
				height="40" width="40" /></a>
			<table border="1">
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>CODE</th>
					<th>FOR</th>
					<th>EMAIL</th>
					<th>CONTACT</th>
					<th>ID TYPE</th>
					<th>IF OTHER</th>
					<th>ID NUMBER</th>
					<th colspan="3">OPERATIONS</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.whId }</td>
						<td>${ob.userType }</td>
						<td>${ob.userCode }</td>
						<td>${ob.userFor }</td>
						<td>${ob.mail }</td>
						<td>${ob.uomContact }</td>
						<td>${ob.userIDType }</td>
						<td>${ob.ifOther }</td>
						<td>${ob.idNumber }</td>
						<td><a href="delete?wid=${ob.whId}">Delete</a></td>
						<td><a href="edit?wid=${ob.whId}">Edit</a></td>
						<td><a href="view?wid=${ob.whId}">View</a></td>
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