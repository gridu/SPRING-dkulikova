<%--
  Created by IntelliJ IDEA.
  User: dkulikova
  Date: 12.04.2020
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Phonebook</title>
</head>
<body>
    <input type="button" value="Add record"
       onclick="window.location.href='showForm'; return false;"/>
    <h1>Phonebook</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Phones</th>
            <th>Action</th>
        </tr>
        <c:forEach var="record" items="${records}">

            <c:url var="deleteLink" value="/phonebook/delete">
                <c:param name="name" value="${record.name}"/>
            </c:url>

            <c:url var="updateLink" value="/phonebook/showPhoneFrom">
                <c:param name="name" value="${record.name}"/>
            </c:url>

            <tr>
                <td>${record.name}</td>
                <td>${record.phones}</td>
                <td>
                <a href="${updateLink}">Add Phone</a> | <a href="${deleteLink}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
