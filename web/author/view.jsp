<%--
  Created by IntelliJ IDEA.
  User: nhat
  Date: 4/20/18
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View author</title>
</head>
<body>
    <h1>Category details</h1>
    <p>
        <a href="/authors">Back to authors list</a>
    </p>
    <table>
        <tr>
            <td>Name: </td>
            <td>${requestScope["author"].getName()}</td>
        </tr>
        <tr>
            <td>Description: </td>
            <td>${requestScope["author"].getDescription()}</td>
        </tr>
    </table>
</body>
</html>
