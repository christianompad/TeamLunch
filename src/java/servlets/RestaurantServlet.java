/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.RestaurantDB;
import domainmodel.Restaurant;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 718205
 */
public class RestaurantServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext SC = getServletContext();
        String PATH = SC.getRealPath("/WEB-INF");
        RestaurantDB rdb = new RestaurantDB();

        String action = request.getParameter("action");

        if (action.equals("addrestaurant")) {

            String name = request.getParameter("name");
            String any = request.getParameter("any");
            String veggie = request.getParameter("veggie");
            String nut = request.getParameter("nut");
            String gluten = request.getParameter("gluten");
            String fish = request.getParameter("fish");
            String rating = request.getParameter("rating");

            if (name != null && any != null && veggie != null && nut != null && gluten != null && fish!=null && rating != null) {
                int anyInt = Integer.parseInt(any);
                int veggieInt = Integer.parseInt(veggie);
                int nutInt = Integer.parseInt(nut);
                int glutenInt = Integer.parseInt(gluten);
                int fishInt = Integer.parseInt(fish);
                int ratingInt = Integer.parseInt(rating);
                

                String toFile = name + "," + any + "," + veggie + "," + nut + "," + gluten + "," + fish + "," + ratingInt + "\n";

                if (rdb.addRestaurant(toFile, PATH, true)) {
                    List<Restaurant> lr = rdb.getAll(PATH);
                    request.setAttribute("restaurants", lr);
                    request.setAttribute("message", "Restaurant Added!");
                } else {
                    request.setAttribute("message", "Restaurant Not Added");
                }

            } else {
                request.setAttribute("message", "Some of the fields have no value");
            }
            getServletContext().getRequestDispatcher("/WEB-INF/restaurant.jsp").forward(request, response);
        }
        if (action.equals("restaurant")) {
            
            
            rdb = new RestaurantDB();
            List<Restaurant> lr = rdb.getAll(PATH);
            request.setAttribute("restaurants", lr);

            getServletContext().getRequestDispatcher("/WEB-INF/restaurant.jsp").forward(request, response);
        }
        if(action.equals("delete")){
            String name = request.getParameter("value");
            String message=null;
            List<Restaurant> lr = rdb.getAll(PATH);
            
            for(int i=0;i<lr.size();i++){
                if(lr.get(i).getName().equals(name)){
                    if(lr.remove(i)!=null){
                       message="Restaurant deleted."; 
                    }else{
                        message="Restaurant not deleted."; 
                    }
                }
            }
            
            for(int i=0;i<lr.size();i++){
                String toFile = lr.get(i).getName()+","+lr.get(i).getNoRestriction()+","+lr.get(i).getVegetarian()+","+lr.get(i).getNutFree()+","+lr.get(i).getGlutenFree()+","+lr.get(i).getFishFree()+","+lr.get(i).getRating()+"\n";
                rdb.addRestaurant(toFile, PATH, false);
            }
            
            request.setAttribute("restaurants", lr);
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/restaurant.jsp").forward(request, response);
        }
    }

}
