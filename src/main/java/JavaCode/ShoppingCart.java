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
        if(lineItems.contains(lineItem))
        {
            for(int i = 0; i < lineItems.size(); i++)
            {
                if(lineItems.get(i).equals(lineItem))
                {
                    lineItems.get(i).addQty(lineItem.getQty());
                }
            }
        }
    }
    
    
}
