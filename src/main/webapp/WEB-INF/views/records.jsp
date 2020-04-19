<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Phonebook</title>
</head>
<body>
    <h1>Phonebook</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Phones</th>
            <th>Action</th>
        </tr>
        <c:forEach var="record" items="${records}">
            <tr>
                <td>${record.name}</td>
                <td>
                    <c:forEach var="phone" items="${record.phones}">
                        <ul>
                            <li>${phone}</li>
                        </ul>
                        <a href="/phonebook/editPhoneForm/${record.name}/${phone}">edit phone</a> | <a href="/phonebook/deletePhone/${record.name}/${phone}">delete phone</a>
                    </c:forEach>
                </td>
                <td>
                    <a href="/phonebook/addPhoneForm/${record.name}">add phone</a> | <a href="/phonebook/deleteRecord/${record.name}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2>Add</h2>
    <c:url var="add" value="/phonebook/addRecordForm"/>
    <a href="${add}">Add new record</a>
</body>
</html>
