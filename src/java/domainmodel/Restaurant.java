/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;

/**
 *
 * @author 718205
 */
public class Restaurant implements Serializable,Comparable{

    private String name;
    private int totalCapacity;
    private int noRestriction;
    private int vegetarian;
    private int nutFree;
    private int glutenFree;
    private int fishFree;
    private int rating;
    
    public Restaurant(){
    
    }

    public Restaurant(String name, int noRestriction, int vegetarian, int nutFree, int glutenFree, int fishFree, int rating) {
        this.name = name;
        this.noRestriction = noRestriction;
        this.vegetarian = vegetarian;
        this.nutFree = nutFree;
        this.glutenFree = glutenFree;
        this.fishFree = fishFree;
        this.rating = rating;
        totalCapacity=noRestriction+vegetarian+nutFree+glutenFree+fishFree;
    }
    
    public int getTotalCapacity() {
        totalCapacity=noRestriction+vegetarian+nutFree+glutenFree+fishFree;
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getNoRestriction() {
        return noRestriction;
    }

    public void setNoRestriction(int noRestriction) {
        this.noRestriction = noRestriction;
    }

    public int getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(int vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getNutFree() {
        return nutFree;
    }

    public void setNutFree(int nutFree) {
        this.nutFree = nutFree;
    }

    public int getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(int glutenFree) {
        this.glutenFree = glutenFree;
    }

    public int getFishFree() {
        return fishFree;
    }

    public void setFishFree(int fishFree) {
        this.fishFree = fishFree;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
     
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object t) {
        Restaurant r  = (Restaurant)t;
        return r.getRating()-rating;
    }
    
    
    

}
