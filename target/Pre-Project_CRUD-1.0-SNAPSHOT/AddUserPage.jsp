<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 09.04.2020
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<h2>${result}</h2>

<style>
    .w3-button {width:100px;}
</style>

<form action="/addUser" method="POST">
    Name :<input type="text" name="name" required>
    Password :<input type="text" name="password" required>
    <div class="w3-container">
        <p><button class="w3-button w3-cyan" type="submit">Accept</button></p>
    </div>
</form>

</body>
</html>