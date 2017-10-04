/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCode;

import Database.DataMapper;
import Database.User;

/**
 * @author Mads Voss
 * Validates the form input.
 */
public class Validate {
    public boolean ValidateLogin(String username, String password) {
        DataMapper dataMapper = new DataMapper();
        User user = dataMapper.getUser(username);
        if(user == null) {
            return false;
        }
        if(user.passwordCheck(password)) {
            return true;
        }
        
        return false;
    }
    
}
