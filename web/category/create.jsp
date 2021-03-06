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
    <title>Create new category</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
    <h1>Create new category</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/categories">Back to category list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Category information</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create category"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
