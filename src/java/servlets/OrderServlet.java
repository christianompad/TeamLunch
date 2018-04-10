/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.RestaurantDB;
import domainmodel.Restaurant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext SC = getServletContext();
        String PATH = SC.getRealPath("/WEB-INF");
        String action = request.getParameter("action");

        if (action.equals("placeorder")) {
            RestaurantDB rdb = new RestaurantDB();
            List<Restaurant> lr = rdb.getAll(PATH);
            Collections.sort(lr);

            request.setAttribute("restaurants", lr);
            getServletContext().getRequestDispatcher("/WEB-INF/placeorder.jsp").forward(request, response);
        }
        if (action.equals("calculate")) {
            RestaurantDB rdb = new RestaurantDB();
            List<Restaurant> lr = rdb.getAll(PATH);
            Collections.sort(lr);

            String meals = request.getParameter("mealnum");
            String veggie = request.getParameter("vegetarian");
            String nut = request.getParameter("nutfree");
            String gluten = request.getParameter("glutenfree");
            String fish = request.getParameter("fishfree");
            request.setAttribute("restaurants", lr);
            if (meals != null && veggie != null && nut != null && gluten != null && fish != null) {

                int mealsInt = Integer.parseInt(meals);
                int veggieInt = Integer.parseInt(veggie);
                int nutInt = Integer.parseInt(nut);
                int glutenInt = Integer.parseInt(gluten);
                int fishInt = Integer.parseInt(fish);

                int mGet = 0;
                int vGet = 0;
                int nGet = 0;
                int gGet = 0;
                int fGet = 0;

                mealsInt = mealsInt - veggieInt - nutInt - glutenInt - fishInt;
                List<String> logList = new ArrayList<>();
                String log = "";
                for (int i = 0; i < lr.size(); i++) {

                    if (mealsInt > lr.get(i).getNoRestriction()) {
                        mGet = lr.get(i).getNoRestriction();
                    } else {
                        mGet = mealsInt;
                    }
                    mealsInt = mealsInt - mGet;

                    if (veggieInt > lr.get(i).getVegetarian()) {
                        vGet = lr.get(i).getVegetarian();
                    } else {
                        vGet = veggieInt;
                    }
                    veggieInt = veggieInt - vGet;

                    if (nutInt > lr.get(i).getNutFree()) {
                        nGet = lr.get(i).getNutFree();
                    } else {
                        nGet = nutInt;
                    }
                    nutInt = nutInt - nGet;

                    if (glutenInt > lr.get(i).getGlutenFree()) {
                        gGet = lr.get(i).getGlutenFree();
                    } else {
                        gGet = glutenInt;
                    }
                    glutenInt = glutenInt - gGet;

                    if (fishInt > lr.get(i).getFishFree()) {
                        fGet = lr.get(i).getFishFree();
                    } else {
                        fGet = fishInt;
                    }

                    fishInt = fishInt - fGet;

                    if (mGet >= 0 && vGet >= 0 && nGet >= 0 && gGet >= 0 && fGet >= 0) {
                        log = lr.get(i).getName() + "\n No restrictions: " + mGet + "\n Vegetarian: " + vGet + "\n Nut-free: " + nGet + "\n Gluten-free: " + gGet + "\n Fish-free: " + fGet;
                        logList.add(log);
                    }

                }
                if (mealsInt > 0 || veggieInt > 0 || nutInt > 0 || glutenInt > 0 || fishInt > 0) {
                    String unordered = "Unordered Meals: ";
                    if (mealsInt > 0) {
                        unordered = unordered + "No restriction (" + mealsInt + ") ";
                    }
                    if (veggieInt > 0) {
                        unordered = unordered + "Vegetarian (" + veggieInt + ") ";
                    }
                    if (nutInt > 0) {
                        unordered = unordered + "Nut-free (" + nutInt + ") ";
                    }

                    if (glutenInt > 0) {
                        unordered = unordered + "Gluten-free (" + glutenInt + ") ";
                    }

                    if (fishInt > 0) {
                        unordered = unordered + "Vegetarian (" + fishInt + ") ";
                    }

                    logList.add(unordered);
                }

                request.setAttribute("logs", logList);
                getServletContext().getRequestDispatcher("/WEB-INF/placeorder.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Input contains invalid values.");
            }

            getServletContext().getRequestDispatcher("/WEB-INF/placeorder.jsp").forward(request, response);
        }

    }

}
