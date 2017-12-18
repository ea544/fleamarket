<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of vendors so far :)</h1>
	<c:url var="addVendorFunction" value="/event/eventAddVendor" ></c:url>
	<c:url var="deleteVendorFunction" value="/event/eventDeleteVendor" ></c:url>
	<table>
		<tbody>
			<tr>
				<th>Id</th>
			</tr>
			<tr><td>Vendor List</td></tr>
			<c:forEach var="vendor" items="${vendors}">
				<tr>
					<td>${vendor.id}</td>
					<td> <a href="${addVendorFunction}/${eventId}/${vendor.id}">Add</a> </td>
				</tr>
			</c:forEach>
			
			<tr><td>Selected Vendors List</td></tr>
			<c:forEach var="selectedVendor" items="${selectedVendors}">
				<tr>
					<td>${selectedVendor.id}</td>
					<td> <a href="${deleteVendorFunction}/${eventId}/${selectedVendor.id}">Delete</a> </td>
				</tr>
			</c:forEach>
		</tbody>

	</table>


</body>
</html>