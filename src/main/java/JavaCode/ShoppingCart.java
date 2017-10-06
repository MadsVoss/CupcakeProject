package JavaCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains a list of LineItems.
 * @author Mads Voss
 */

public class ShoppingCart {

    private List<LineItems> lineItems = new ArrayList();

    public List<LineItems> getLineItems() {
        return lineItems;
    }
    
    public LineItems getLineItem(int i)
    {
        return lineItems.get(i);
    }

    /**
     * Adds an item to the Line Items/Shopping Cart.
     * @param lineItem 
     */
    public void addLineItem(LineItems lineItem) {
        boolean found = false;

        for (int i = 0; i < lineItems.size(); i++) {
            if (lineItems.get(i).equals(lineItem)) {
                lineItems.get(i).addQty(lineItem.getQty());
                found = true;
            }
        }
        if (!found) {
            lineItems.add(lineItem);
        }
    }
    
    /**
     * Returns the total price of the Line Items/Shopping cart.
     * @return 
     */
    public float getTotalPrice(){
        float totalPrice = 0;
        for(int i = 0; i < lineItems.size(); i++){
            totalPrice += lineItems.get(i).getCupcake().getTotalPrice() * lineItems.get(i).getQty();
        }
        return totalPrice;
    }
    /**
     * Clears the Line Items/Shopping Cart.
     */
    public void emptyCart(){
        lineItems.clear();
    }
    
    public void removeLineItem(int i)
    {
        lineItems.remove(i);
    }

}
