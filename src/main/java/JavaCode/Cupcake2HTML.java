/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCode;

import Database.Cupcake;
import java.util.List;

/**
 *
 * @author Mads Voss
 */
public class Cupcake2HTML {
    public String cupcakeList2HTML(List<Cupcake> list){
        String out = "<h1>All Cupcakes</h1>";
        for(int i = 0; i< list.size();i++){
            out += "<h2>" + list.get(i).getToppingName() +"     "+ list.get(i).getBottomName() + "</h2>";
        }
        return out;
    }
    
    
}
