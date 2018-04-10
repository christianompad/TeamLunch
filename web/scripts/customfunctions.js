/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function showBreakDown(){
    var msg ="";
    var meals=document.getElementById("meals").value;
    var totalMeals=meals;
    var nutFree=document.getElementById("nf").value;
    var vegetarian=document.getElementById("veg").value;
    var glutenFree=document.getElementById("gf").value;
    var fishFree=document.getElementById("ff").value;
    
    if(nutFree>0 && nutFree<=meals){
        meals=meals-nutFree;
        msg = msg+" Nut Free "+"("+nutFree+")";
    }
    if(vegetarian>0 && vegetarian<=meals){
        meals=meals-vegetarian;
        msg = msg+" Vegetarian "+"("+vegetarian+")";
    }
    if(glutenFree>0 && glutenFree<=meals){
        meals=meals-glutenFree;
        msg=msg+" Gluten Free "+"("+glutenFree+")";
    }
    if(fishFree>0 && fishFree<=meals){
        meals=meals-fishFree;
        msg=msg+" Fish Free "+"("+fishFree+")";
    }
    
    var msgHead ="Total("+totalMeals+") Breakdown: No restrictions("+meals+") "+msg;
    document.getElementById("breakdown").innerHTML=msgHead;
    
}