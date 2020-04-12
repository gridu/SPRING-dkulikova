<%--
  Created by IntelliJ IDEA.
  User: dkulikova
  Date: 12.04.2020
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add phone</title>
</head>
<body>
<div>
    <form:form action="addphone" method="post" modelAttribute="record">

        <form:hidden path="id"/>
        <div >
            <label for="name">Name</label>
            <div>
                <form:input readonly="true"  path="name"/>
            </div>
        </div>
        <div>
            <label for="phone">Phone</label>
            <div>
                <form:input path="phone"/>
            </div>
        </div>
        <div>
            <div>
                <form:button >Add</form:button>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>
