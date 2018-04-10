<%-- 
    Document   : index
    Created on : Apr 5, 2018, 12:12:22 PM
    Author     : 718205
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/includes.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Lunch</title>
    </head>
    <div class="row">
        <%@include file="/WEB-INF/jspf/header.jspf" %>
    </div>
    <body style="background-color: #4C95FF;">
        <div class="row">
            <div class="col s4 offset-s4 center-align z-depth-3" style="margin-top: 10%;color: whitesmoke; background-color: #0068FF;">
                <h1>Team Lunch</h1>
                <div class="row">
                    <div class="col s6 right-align">
                        <form action="Restaurant?action=restaurant" id="restaurants" method="post">
                            <button class="waves-effect waves-light btn-large purple" form="restaurants">Restaurants</button>
                        </form>
                    </div>

                    <div class="col s6 left-align">
                        <form action="Order?action=placeorder" method="post" id="placeorder">
                            <button class="waves-effect waves-light btn-large cyan" form="placeorder">Place Order</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>


     <%@include file="/WEB-INF/jspf/footer.jspf" %>   
    </body>

            

</html>
