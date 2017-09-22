/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mads Voss
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

    public User getUser(String username) {
        Statement stm;
        try {
            stm = conn.getConnection().createStatement();
            String sql = "select * from User where User_username = '" + username + "';";
            ResultSet rs = stm.executeQuery(sql);
            //Tries to find a user which matches the previous search, if found it gives the info about the users. Otherwise it returns null.
            if (rs.next()) {
                User user = new User(rs.getInt("User_id"), rs.getString("User_username"), rs.getString("User_password"), rs.getString("User_email"), rs.getFloat("User_balance"));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

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

    public static void main(String[] args) {
        DataMapper dataMapper = new DataMapper();
        User user;
        user = dataMapper.getUser("Mads");
        System.out.println(user.getBalance());
        //dataMapper.addUser("Ronnie", "Wizard", "RonnieDungeonKeeper@Wizard.net");
        User user1;
        user1 = dataMapper.getUser("Ronnie");
        System.out.println(user1.getUsername());

    }
}
