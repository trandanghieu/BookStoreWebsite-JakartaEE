<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Manage Users - Admin</title>
</head>
<body>

<jsp:directive.include file="header.jsp"/>

<div align="center">
    <h2>User Management</h2>
    <h3><a href=""> Create new User</a></h3>
</div>

<div align="center">
    <table border="1">
        <tr>
            <th>Index</th>
            <th>Id</th>
            <th>Email</th>
            <th>FullName</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUsers}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.id}</td>
                <td>${user.email}}</td>
                <td>${user.fullName}</td>
                <td>
                    <a href="">Edit</a>
                    <a href="">Delete</a>
                </td>
            </tr>
            x </c:forEach>
    </table>
</div>


<div align="center">
    <h2>Administrative Dashboard</h2>
</div>


<jsp:directive.include file="footer.jsp"/>


</body>
</html>
