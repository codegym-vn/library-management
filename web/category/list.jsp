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
        <a href="/categories?action=create">Create new category</a>
    </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["categories"]}' var="category">
            <tr>
                <td><a href="/categories?action=view&id=${category.getId()}">${category.getName()}</a></td>
                <td><a href="/categories?action=edit&id=${category.getId()}">edit</a></td>
                <td><a href="/categories?action=delete&id=${category.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
