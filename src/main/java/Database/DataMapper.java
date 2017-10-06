/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import JavaCode.LineItems;
import JavaCode.ShoppingCart;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 * @author Mads Voss
 * Handles all traffic to the database.
 */
public class DataMapper {

    private DBC conn;

    public DataMapper() {
        try {
            this.conn = new DBC();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * 
     * @param username
     * @return 
     * Fetches a user from the database.
     */
    public User getUser(String username) {
        Statement stm;
        try {
            stm = conn.getConnection().createStatement();
            String sql = "select * from User where User_username = '" + username + "';";
            ResultSet rs = stm.executeQuery(sql);
            //Tries to find a user which matches the previous search, if found it gives the info about the users. Otherwise it returns null.
            if (rs.next()) {
                User user = new User(rs.getInt("User_id"), rs.getString("User_username"), rs.getString("User_password"), rs.getString("User_email"), rs.getFloat("User_balance"), rs.getString("User_role"));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 
     * @param username
     * @param password
     * @param email 
     * Adds a user to the database.
     */
    public void addUser(String username, String password, String email) {
        try {
            String sql = "insert into User set User_username = ?, User_password = ?, User_email = ?";
            PreparedStatement userPstmt = conn.getConnection().prepareStatement(sql);
            userPstmt.setString(1, username);
            userPstmt.setString(2, password);
            userPstmt.setString(3, email);
            userPstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * 
     * @return 
     * Returns a list of toppings from the database.
     */
    public List<Topping> getToppings()
    {
        List<Topping> toppingsList = new ArrayList();
        Statement stm;
        try {
            stm = conn.getConnection().createStatement();
            String sql = "SELECT Topping_name, Topping_price FROM Topping;";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                toppingsList.add(new Topping(rs.getString("Topping_name"), rs.getFloat("Topping_price")));
            }
            return toppingsList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 
     * @param toppingString
     * @return 
     * Returns a single topping from the database.
     */
    private Topping getTop(String toppingString){
        Statement stm;
        try {
            stm = conn.getConnection().createStatement();
            String sql = "SELECT Topping_name, Topping_price FROM Topping WHERE Topping_name = '"+toppingString+"';";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                Topping top = new Topping(rs.getString("Topping_name"), rs.getFloat("Topping_price"));
                return top;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
}
    
    /**
     * 
     * @param bottomString
     * @return 
     * Returns a single bottom from the database.
     */
     private Bottom getBot(String bottomString) {
        Statement stm;
        try {
            stm = conn.getConnection().createStatement();
            String sql = "SELECT Bottom_name, Bottom_price FROM Bottom WHERE Bottom_name = '"+bottomString+"';";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                Bottom bot = new Bottom(rs.getString("Bottom_name"), rs.getFloat("Bottom_price"));
                return bot;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 
     * @return 
     * Returns a list of bottoms from the database.
     */
    public List<Bottom> getBottoms()
    {
        List<Bottom> bottomsList = new ArrayList();
        Statement stm;
        try {
            stm = conn.getConnection().createStatement();
            String sql = "SELECT Bottom_name, Bottom_price FROM Bottom;";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                bottomsList.add(new Bottom(rs.getString("Bottom_name"), rs.getFloat("Bottom_price")));
            }
            return bottomsList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * 
     * @param lineItems
     * @param Invoice_id 
     * Adds product to the database.
     */
    public void addProduct(LineItems lineItems, int Invoice_id) {
        
        try {
            String sql = "insert into Product set Product_name = '"+lineItems.getCupcake().getName()+"', Product_quantity = "+lineItems.getQty()+", Product_price = "+lineItems.lineItemsPrice()+", Invoice_id = "+Invoice_id+";";
            PreparedStatement userPstmt = conn.getConnection().prepareStatement(sql);
            userPstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    /**
     * If there is an open invoice the customer gets it otherwise it will create a new one.
     * @param user
     * @return 
     * 
     */
    public int checkInvoice(User user){
        Statement stm;
        
        try {
            stm = conn.getConnection().createStatement();
            String sql = "select Invoice_id from oDetails where CurrentStatus = 'Open' and User_id ='"+user.getId()+"';";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                int Invoiceid = rs.getInt("Invoice_id");
                return Invoiceid;
            } else{
                sql = "insert into oDetails set oDate='"+java.time.LocalDate.now()+"', User_id = '"+user.getId()+"', CurrentStatus = 'Open';";
            PreparedStatement userPstmt = conn.getConnection().prepareStatement(sql);
            
            userPstmt.executeUpdate();
            return checkInvoice(user);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    public static void main(String[] args) {
        DataMapper dataMapper = new DataMapper();
        ShoppingCart list = dataMapper.fillShoppingCart(11);
        List<LineItems> lisst = list.getLineItems();

    }
    
    /**
     * Closes the invoice for the current user.
     * @param user 
     */
    private void closeInvoice(User user){
        try {
            String sql = "update oDetails set CurrentStatus = 'Closed' where User_id = "+user.getId()+";";
            PreparedStatement userPstmt = conn.getConnection().prepareStatement(sql);
            userPstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Updates the balance after a purchase.
     * @param user
     * @param totalPrice 
     */
    public void makePurchase(User user, float totalPrice) {
        try {
            float newBalance = user.getBalance() - totalPrice;
            String sql = "update User set User_balance = "+newBalance+" where User_id = "+user.getId()+";";
            PreparedStatement userPstmt = conn.getConnection().prepareStatement(sql);
            userPstmt.executeUpdate();
            closeInvoice(user);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   
    /**
     * 
     * @param Invoiceid
     * @return 
     * Returns a shoppingcart object with all the cupcakes that were in the session when the user logged out.
     */
    public ShoppingCart fillShoppingCart(int Invoiceid){
        ShoppingCart shoppingCart = new ShoppingCart();
        try {
            Statement stm;
            stm = conn.getConnection().createStatement();
            String sql = "select * from Product where Invoice_id = "+Invoiceid+";";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String productName = rs.getString("Product_name");
                int product_quantity = rs.getInt("Product_quantity");
                String[] name = productName.split("-");
                Topping top = getTop(name[0]);
                Bottom bot = getBot(name[1]);
                Cupcake cupcake = new Cupcake(bot, top);
                shoppingCart.addLineItem(new LineItems(cupcake, product_quantity));
                
                //lineItems.add(new LineItems(productName, product_quantity, product_price, Invoice_id));
            }
            return shoppingCart;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * Deletes a product from the invoice.
     * @param Invoice_id 
     */
    public void deleteInvoicedProducts(int Invoice_id){
        try {
            String sql = "delete from Product where Invoice_id = "+Invoice_id+";";
            PreparedStatement userPstmt = conn.getConnection().prepareStatement(sql);
            userPstmt.executeUpdate();
//            sql = "delete from oDetails where Invoice_id = "+Invoice_id+";";
//            userPstmt = conn.getConnection().prepareStatement(sql);
//            userPstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }/**
     * Returns a list of the order details.
     * @return 
     */
    
    public List<ODetails> adminPageData(){
        List<ODetails> list = new ArrayList();
        try {
            Statement stm;
            stm = conn.getConnection().createStatement();
            String sql = "select * from oDetails;";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                
                list.add(new ODetails(rs.getInt("Invoice_id"), rs.getInt("User_id"), rs.getString("CurrentStatus")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

   

    

    
}
