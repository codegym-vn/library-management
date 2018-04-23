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
    <title>Deleting category</title>
</head>
<body>
<h1>Delete category</h1>
<p>
    <a href="/categories">Back to category list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Category information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["category"].getName()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete category"></td>
                <td><a href="/categories">Back to category list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
