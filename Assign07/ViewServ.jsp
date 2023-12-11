
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Register</title>
<style>
/* Basic styling for table */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

h2 {
	text-align: center;
}

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #fff;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ccc;
}

th {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #f9f9f9;
}
</style>
</head>
<body>
	<h2>Registered Users</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
		</tr>
		<c:forEach var="register" items="${requestScope.list}">
			<tr>
				<td>${register.id}</td>
				<td>${register.name}</td>
				<td>${register.address}</td>
				<td>${register.email_id}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>