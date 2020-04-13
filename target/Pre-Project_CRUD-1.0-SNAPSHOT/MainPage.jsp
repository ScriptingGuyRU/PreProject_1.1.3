<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="services.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="entities.User" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 09.04.2020
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Main_Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>
    <div class="w3-container">
         <h2>List Users</h2>
    <table class="w3-table w3-striped">
         <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Password</th>
         </tr>

      <c:forEach var="usersList" items="${users}" >

        <tr>
            <td>${usersList.id}</td>
            <td>${usersList.name}</td>
            <td>${usersList.password}</td>
        </tr>
        </c:forEach>

    </table>
    </div>

    <style>
        .w3-button {width:100px;}
    </style>



<form class="your-form-selector" >
    <fieldset>
        <legend >Действия:</legend>

        <form method="get" action="/addUser"> <!--Костыль, без которого метод добавления не будет работать. Почему так - хз. -->
            <div class="w3-container">
            </div>
        </form>

        <form method="get" action="/addUser">
            <div class="w3-container">
                <button class="w3-button w3-cyan" type="submit">New</button>
            </div>
        </form>

        <form method="get" action="/deleteUser">
            <div class="w3-container">
                <p></p>
                <button class="w3-button w3-cyan" type="submit">Delete</button>
            </div>
        </form>

        <form method="get" action="/editUser">
            <div class="w3-container">
                <button class="w3-button w3-cyan" type="submit">Edit</button>
            </div>
        </form>
</fieldset>
</form>

</body>
</html>
