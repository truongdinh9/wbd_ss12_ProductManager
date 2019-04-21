<%--
  Created by IntelliJ IDEA.
  User: dinh
  Date: 21/04/2019
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/products">Back to products list</a>
<h1>Edit product </h1>
<form method="post">
    <table border="1">
        <tr>
            <td>Product name</td>
            <td> <input type="text" value="${product.getName()}" name="name"></td>
        </tr><tr>
        <td>Product description </td>
        <td> <input type="text" value="${product.getDescription()}"  name="description"></td>
    </tr><tr>
        <td>Product price</td>
        <td> <input type="number" value="${product.getPrice()}" name="price"></td>
    </tr>
    </table>
    <input type="submit" value="Edit product">
</form>

</body>
</html>
