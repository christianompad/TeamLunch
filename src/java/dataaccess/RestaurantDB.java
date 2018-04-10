/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;


import domainmodel.Restaurant;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author 718205
 */
public class RestaurantDB {

    private String toWrite;
    private String path;

    public RestaurantDB() {

    }

    public boolean addRestaurant(String toWrite,String path, boolean append) {
        boolean isWritten = false;
        
        try {
            File file = new File(path, "files");
            if (!file.exists()) {
                file.mkdir();
            }
            file = new File(file, "restaurants.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toWrite);
//            bw.newLine();
            bw.close();
            isWritten = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isWritten;
    }

    public List<Restaurant> getAll(String path) {
        List<Restaurant> lr = new ArrayList<>();
        try {
            path=path+"\\files\\restaurants.txt";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            String splitter[]=null;
            Restaurant resto = null;

            while ((line=br.readLine())!=null) {
                splitter = line.split(",");
                String name = splitter[0];
                int noRestriction = Integer.parseInt(splitter[1]);
                int vegetarian = Integer.parseInt(splitter[2]);
                int nutFree =Integer.parseInt(splitter[3]);
                int glutenFree =Integer.parseInt(splitter[4]) ;
                int fishFree=Integer.parseInt(splitter[5]); 
                int rating = Integer.parseInt(splitter[6]);
                resto = new Restaurant(name,noRestriction,vegetarian,nutFree,glutenFree,fishFree,rating);
                lr.add(resto);

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lr;
    }

}
