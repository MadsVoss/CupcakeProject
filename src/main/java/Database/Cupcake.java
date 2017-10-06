/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.Objects;

/**
 * Class that combines the bottom and topping to a cupcake. When combined shows you the names and price.
 * @author Mads Voss
 */
public class Cupcake {
    private String toppingName;
    private String bottomName;
    private float toppingPrice;
    private float bottomPrice;
    
    
    public Cupcake(Bottom bottom, Topping topping) {
        this.toppingName = topping.getName();
        this.bottomName = bottom.getName();
        this.toppingPrice = topping.getPrice();
        this.bottomPrice = bottom.getPrice();
    }

    public String getToppingName() {
        return toppingName;
    }

    public String getBottomName() {
        return bottomName;
    }
    
    public String getName(){
        return toppingName + "-" + bottomName;
    }

    public float getToppingPrice() {
        return toppingPrice;
    }

    public float getBottomPrice() {
        return bottomPrice;
    }
    
    public float getTotalPrice(){
        return toppingPrice + bottomPrice;
    }
    /**
     * 
     * @param obj
     * @return 
     * Compares two cupcakes.
     */
    public boolean equals(Cupcake obj) {
        if(bottomName.equals(obj.getBottomName()) && toppingName.equals(obj.toppingName))
            return  true;
        else
            return false;
    }
}

