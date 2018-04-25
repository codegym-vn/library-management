<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nhat
  Date: 4/20/18
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories List</title>
</head>
<body>
    <h1>Categories</h1>
    <p>
        <a href="/readers?action=create">Create new reader</a>
    </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Phone</td>
            <td>Avatar</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["readers"]}' var="reader">
            <tr>
                <td><a href="/readers?action=view&id=${reader.getId()}">${reader.getName()}</a></td>
                <td><a href="/readers?action=view&id=${reader.getId()}">${reader.getEmail()}</a></td>
                <td><a href="/readers?action=view&id=${reader.getId()}">${reader.getAddress()}</a></td>
                <td><a href="/readers?action=view&id=${reader.getId()}">${reader.getPhone()}</a></td>
                <td><a href="/readers?action=view&id=${reader.getId()}"><img src="/images/reader/${reader.getAvatar()}"/></a></td>
                <td><a href="/readers?action=edit&id=${reader.getId()}">edit</a></td>
                <td><a href="/readers?action=delete&id=${reader.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
