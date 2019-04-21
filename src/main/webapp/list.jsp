<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinh
  Date: 21/04/2019
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center"> List products </h1>
<a href="/products?action=create">Create new product</a>
<table border="1">
    <tr>
        <td>name</td>
        <td>description</td>
        <td>price</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach  items='${requestScope["products"]}' var='product' >
    <tr>
        <td>${product.getName()}</td>
        <td>${product.getDescription()}</td>
        <td>${product.getPrice()}</td>
        <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/products?action=remove&id=${product.getId()}">delete</a></td>

    </tr>
    </c:forEach>
</table>


</body>
</html>
