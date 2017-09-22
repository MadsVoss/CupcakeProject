/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Mads Voss
 */
public class Cupcake {
    private String toppingName;
    private String bottomName;
    private float toppingPrice;
    private float bottomPrice;
    
    
    public Cupcake(String toppingName, String bottomName, float toppingPrice, float bottomPrice) {
        this.toppingName = toppingName;
        this.bottomName = bottomName;
        this.toppingPrice = toppingPrice;
        this.bottomPrice = bottomPrice;
        
    }

    public String getToppingName() {
        return toppingName;
    }

    public String getBottomName() {
        return bottomName;
    }

    public float getToppingPrice() {
        return toppingPrice;
    }

    public float getBottomPrice() {
        return bottomPrice;
    }

    public float getTotalPrice() {
        return toppingPrice + bottomPrice;
    }
    
    
    
    
}

