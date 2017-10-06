/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 * Contains the logged in users invoice.
 * @author Jonatan
 */
public class ODetails {
    private int Invoiceid;
    private int Userid;
    private String CurrentStatus;

    public ODetails(int Invoiceid, int Userid, String CurrentStatus) {
        this.Invoiceid = Invoiceid;
        this.Userid = Userid;
        this.CurrentStatus = CurrentStatus;
    }

    public int getInvoiceid() {
        return Invoiceid;
    }

    public int getUserid() {
        return Userid;
    }

    public String getCurrentStatus() {
        return CurrentStatus;
    }

    @Override
    public String toString() {
        return "Invoiceid=" + Invoiceid + ", Userid=" + Userid + ", CurrentStatus=" + CurrentStatus;
    }
    
    
    
}
