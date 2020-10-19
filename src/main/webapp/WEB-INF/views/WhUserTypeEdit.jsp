<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>

	<H3>WELCOME TO WH USER TYPE REGISTRATION PAGE</H3>
	<form:form action="update" method="post" modelAttribute="whusertype">
		<pre>
User Id:
<form:input path="whId" readOnly="true" />

User Type:
<form:radiobutton path="userType" value="Vendor" />Vendor
<form:radiobutton path="userType" value="Customer" />Customer

User Code:
<form:input path="userCode" />

User For:
<form:input path="userFor" />

User Email:
<form:input path="mail" />

User Contact:
<form:input path="uomContact" />

User ID Type:
<form:select path="userIDType">
	<form:option value="">-select-</form:option>
	<form:option value="PAN Card">PAN Card</form:option>
	<form:option value="Aadhar">Aadhar</form:option>
	<form:option value="Voter ID">Voter ID</form:option>
	<form:option value="Other">Other</form:option>
</form:select>

*If Other:
<form:input path="ifOther" />

ID Number:
<form:input path="idNumber" />

<input type=submit value="UPDATE USER" />
</pre>
	</form:form>
</body>
</html>