/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBC {

    private Connection connection = null;

    
    // Connected to Jonatans database
    private static final String IP = "46.101.243.239";
    private static final String PORT = "3306";
    private static final String DATABASE = "CupcakeProject";
    private static final String USERNAME = "jmb";
    private static final String PASSWORD = "bakke";

    /**
     * Connects to the database
     */
    public DBC() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }
    /**
     * 
     * @return 
     * Returns the database connection
     */
    public Connection getConnection() {
        return this.connection;
    }
}