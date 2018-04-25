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
    <title>Edit reader</title>
</head>
<body>
<h1>Edit reader</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/readers">Back to reader list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Category information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["reader"].getName()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope["reader"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address" value="${requestScope["reader"].getAddress()}"></td>
            </tr>
            <tr>
                <td>Phone: </td>
                <td><input type="text" name="phone" id="phone" value="${requestScope["reader"].getPhone()}"></td>
            </tr>
            <tr>
                <td>Avatar: </td>
                <td><img src="/images/reader/${requestScope["reader"].getAvatar()}"/>
                    <input type="file" name="avatar" id="avatar"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update reader"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
