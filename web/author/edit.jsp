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
    <title>Edit author</title>
</head>
<body>
<h1>Edit author</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/authors">Back to author list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Category information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["author"].getName()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="description" value="${requestScope["author"].getDescription()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update author"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
