package JavaCode;

import Database.Cupcake;
import java.util.Objects;

public class LineItems 
{
    private int invoiceId;
    private int qty;
    private Cupcake cupcake;

    public LineItems(Cupcake cupcake, int qty) {
        this.qty = qty;
        this.cupcake = cupcake;
    }

    public void addQty(int qty) {
        this.qty += qty;
    }

    public int getQty() {
        return qty;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public boolean equals(LineItems obj) {
        if(cupcake.equals(obj.getCupcake()))
            return true;
        else
            return false;
    }
    
}


