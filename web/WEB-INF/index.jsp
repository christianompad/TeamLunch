<%-- 
    Document   : index
    Created on : Apr 5, 2018, 12:12:22 PM
    Author     : 718205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Lunch</title>
    </head>
    <body>
        <h1>Team Lunch</h1>
        <form action="Restaurant?action=restaurant" method="post">
            <input type="submit" value="Restaurants"/>
        </form>
        
        
        <form action="Order?action=placeorder" method="post">
            <input type="submit" value="Place Order"/>
        </form>
        
        
        
    </body>
</html>
