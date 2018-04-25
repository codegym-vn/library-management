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
    <title>Deleting reader</title>
</head>
<body>
<h1>Delete reader</h1>
<p>
    <a href="/readers">Back to reader list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Category information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["reader"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["reader"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${requestScope["reader"].getAddress()}</td>
            </tr>
            <tr>
                <td>Phone: </td>
                <td>${requestScope["reader"].getPhone()}</td>
            </tr>
            <tr>
                <td>Avatar: </td>
                <td><img src="/images/reader/${requestScope["reader"].getAvatar()}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete reader"></td>
                <td><a href="/readers">Back to reader list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
