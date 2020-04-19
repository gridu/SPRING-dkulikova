<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty form.name && empty form.phone}">
        <title>Add new record</title>
    </c:if>
    <c:if test="${!empty form.name && !empty form.phone}">
        <title>Edit record</title>
    </c:if>
    <c:if test="${!empty form.name && empty form.phone}">
        <title>Add new phone</title>
    </c:if>
    <style>
    .error {
        color: #ff0000;
        font-style: italic;
        font-weight: bold;
    }
    </style>
</head>
<body>
<c:if test="${empty form.name && empty form.phone}">
    <c:url value="/phonebook/addRecord" var="var"/>
</c:if>
<c:if test="${!empty form.name && !empty form.phone}">
    <c:url value="/phonebook/updatePhone" var="var"/>
</c:if>
<c:if test="${!empty form.name && empty form.phone}">
    <c:url value="/phonebook/addPhone" var="var"/>
</c:if>
<style>
    .error {
        color: #ff0000;
    }
    .errorblock{
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
</style>

<form action="${var}" method="POST">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    <label for="name">Name</label>
    <c:if test="${!empty form.name}">
        <input type="text" name="name" id="name"  readonly="true" value = "${form.name}">
    </c:if>
    <c:if test="${empty form.name}">
        <input type="text" name="name" id="name" path ="name" value = "${form.name}">
    </c:if>
    <c:if test="${!empty oldPhone}">
        <label for="oldPhone">Old Phone</label>
        <input type="text" name="oldPhone" id="oldPhone" readonly="true" value = "${oldPhone}">
    </c:if>
    <label for="phone">New Phone</label>
    <input type="text" name="phone" id="phone" value = "${form.phone}">

    <c:if test="${empty form.name && empty form.phone}">
        <input type="submit" value="Add new record">
    </c:if>
    <c:if test="${!empty form.name && !empty form.phone}">
        <input type="submit" value="Edit record">
    </c:if>
    <c:if test="${!empty form.name && empty form.phone}">
        <input type="submit" value="Add new phone">
    </c:if>
</form>

</body>
</html>
