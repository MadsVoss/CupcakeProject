/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 * Contains a list of the Toppings table from the database.
 * @author Jonatan
 */
public class Topping {
    private String name;
    private float price;

    public Topping(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
    
}
