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
        <%@include file="/WEB-INF/jspf/includes.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurants</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <div class="row">
            <div class="col s6">
                <h1>Add Restaurant</h1>
                <a href="Home">&lt Home</a>

                <form action="Restaurant?action=addrestaurant" method="post" id="addrestaurant">
                    Name: <input type="text" name="name"><br>
                    Any: <input type="number" name="any" min="0"><br> 
                    Vegetarian: <input type="number" name="veggie" min="0"><br>
                    Nut Free: <input type="number" name="nut" min="0"><br>
                    Gluten Free: <input type="number" name="gluten" min="0"><br>
                    Fish Free: <input type="number" name="fish" min="0"><br>
                    Rating: <input type="number" max="5" name="rating" min="0">/5<br>
                    <button class="waves-effect waves-light btn-large green" form="addrestaurant">Add Restaurant</button>
                </form>
                
                ${message}
            </div>
            <div class="col s6">
                <h1>Restaurant List</h1>
                <table class="striped">
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
                                    <form action="Restaurant?action=delete&value=${r.name}" method="post" id="deleterestaurant">
                                        <button class="waves-effect waves-light btn-large red" form="deleterestaurant">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>



        <%@include file="/WEB-INF/jspf/footer.jspf" %>   
    </body>
</html>
