package JavaCode;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart 
{
    private List<LineItems> lineItems = new ArrayList();

    public List<LineItems> getLineItems() {
        return lineItems;
    }
    
    public void addLineItem(LineItems lineItem){
        lineItems.add(lineItem);
    }
}
