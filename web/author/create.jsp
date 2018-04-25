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
    <title>Create new author</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
    <h1>Create new author</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/authors">Back to author list</a>
    </p>
    <form method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Category information</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td><input type="text" name="description" id="description"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create author"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
