<%-- 
    Document   : restaurant
    Created on : Apr 5, 2018, 12:32:27 PM
    Author     : 718205
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurants</title>
    </head>
    <body>
        <h1>Restaurants</h1>
        <a href="Home">Home</a>

        <form action="Restaurant?action=addrestaurant" method="post">
            Name: <input type="text" name="name"><br>
            Any: <input type="number" name="any" min="0"><br> 
            Vegetarian: <input type="number" name="veggie" min="0"><br>
            Nut Free: <input type="number" name="nut" min="0"><br>
            Gluten Free: <input type="number" name="gluten" min="0"><br>
            Fish Free: <input type="number" name="fish" min="0"><br>
            Rating: <input type="number" max="5" name="rating" min="0">/5<br>
            <input type="submit" value="Add Restaurant">
        </form>
        ${message}
        <hr>
        <table>
            <thead>
            <th>Name</th>
            <th>Capacity</th>
            <th>Rating</th>
        </thead>
        <tbody>
            <c:forEach var="r" items="${restaurants}">
                <tr>
                    <td>
                        ${r.name} 
                    </td>
                    <td>
                        ${r.totalCapacity}  
                    </td>
                    <td>
                        ${r.rating} 
                    </td>
                    <td>
                        <form action="Restaurant?action=delete&value=${r.name}" method="post">
                           <input type="submit" value="Delete"/> 
                        </form>
                    </td>

                </tr>

            </c:forEach>
        </tbody>
    </table>

</body>
</html>
