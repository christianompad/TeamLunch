<%-- 
    Document   : placeorder
    Created on : Apr 9, 2018, 1:52:31 PM
    Author     : 718205
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="scripts/customfunctions.js"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Place Order</title>
    </head>
    <body>
        <h1>Place Order</h1>
        <a href="Home">Home</a>
        <form action="Order?action=calculate" method="post">
            Meals:<input type="number" required min="0" id="meals" name="mealnum"><br>
            <h4>Dietary Restrictions</h4>
            Nut-free:<input type="number" min="0" value="0" id="nf" name="nutfree" onkeyup="showBreakDown()"><br>
            Vegetarian:<input type="number" min="0" value="0" id="veg" name="vegetarian" onkeyup="showBreakDown()"><br>
            Gluten-free:<input type="number" min="0" value="0" id="gf" name="glutenfree" onkeyup="showBreakDown()"><br>
            Fish-free:<input type="number" min="0" value="0" id="ff" name="fishfree" onkeyup="showBreakDown()"><br>
            <p id="breakdown"></p>
            <input type="submit" value="Place order">
        </form>
        ${message}
        <c:forEach var="l" items="${logs}">
            <p>${l}</p>
        </c:forEach>
        <hr>
        <table>
            <thead>
            <th>Name</th>
            <th>Rating</th>
            <th>No Restriction</th>
            <th>Nut-free</th>
            <th>Vegetarian</th>
            <th>Gluten-free</th>
            <th>Fish-free</th>
            <th>Total Capacity</th> 
        </thead>
        <tbody>
            <c:forEach var="r" items="${restaurants}">
                <tr>
                    <td>${r.name}</td>
                    <td>${r.rating}</td>
                    <td>${r.noRestriction}</td>
                    <td>${r.nutFree}</td>
                    <td>${r.vegetarian}</td>
                    <td>${r.glutenFree}</td>
                    <td>${r.fishFree}</td>
                    <td>${r.totalCapacity}</td>
                    
                </tr>

            </c:forEach>  
        </tbody>
    </table>

</body>
</html>
