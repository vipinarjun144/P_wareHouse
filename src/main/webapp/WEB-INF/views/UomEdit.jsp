<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Welcome To UOM Edit Page</h3>
	<form:form action="update" method="post" modelAttribute="uom">
		<pre>

UOM Id:
	<form:input path="uomId" readOnly="true" />

UOM Type:
<form:select path="uomType">
	<form:option value="">-Select-</form:option>
	<form:option value="Packing">Packing</form:option>
	<form:option value="NoPacking">No Packing</form:option>
	<form:option value="NA">NA</form:option>
</form:select>

UOM Model:
<form:input path="uomModel" />

Description:
<form:textarea path="uomDesc" />

<input type=submit value="Update" />
</pre>

	</form:form>


</body>
</html>