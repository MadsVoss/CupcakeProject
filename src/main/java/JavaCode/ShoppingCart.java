package JavaCode;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<LineItems> lineItems = new ArrayList();

    public List<LineItems> getLineItems() {
        return lineItems;
    }

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
    
    public float getTotalPrice(){
        float totalPrice = 0;
        for(int i = 0; i < lineItems.size(); i++){
            totalPrice += lineItems.get(i).getCupcake().getTotalPrice() * lineItems.get(i).getQty();
        }
        return totalPrice;
    }

}
