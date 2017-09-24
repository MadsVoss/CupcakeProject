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
    private int qty;
    
    
    public Cupcake(Bottom bottom, Topping topping, int qty) {
        this.toppingName = topping.getName();
        this.bottomName = bottom.getName();
        this.toppingPrice = topping.getPrice();
        this.bottomPrice = bottom.getPrice();
        this.qty = qty;
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
    
    public float getCupcakePrice(){
        return toppingPrice + bottomPrice;
    }

    public float getTotalPrice() {
        return (toppingPrice + bottomPrice) * qty;
    }
    
    public int getQty() {
        return qty;
    }
}

