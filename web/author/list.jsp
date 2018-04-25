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
    <title>Authors List</title>
</head>
<body>
    <h1>Authors</h1>
    <p>
        <a href="/authors?action=create">Create new author</a>
    </p>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["authors"]}' var="author">
            <tr>
                <td><a href="/authors?action=view&id=${author.getId()}">${author.getName()}</a></td>
                <td><a href="/authors?action=view&id=${author.getId()}">${author.getDescription()}</a></td>
                <td><a href="/authors?action=edit&id=${author.getId()}">edit</a></td>
                <td><a href="/authors?action=delete&id=${author.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
