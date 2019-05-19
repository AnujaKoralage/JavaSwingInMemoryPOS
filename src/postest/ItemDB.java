/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postest;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ItemDB implements DB{

    ArrayList ar = new ArrayList();
    
    @Override
    public void saveDB(Object ob) {
        ar.add(ob);
    }
    
    public void updateDB(Item i,String code, String qty, String price, String description){
        i.setCode(code);
        i.setDescription(description);
        i.setPrice(price);
        i.setQty(qty);
    }
    
    @Override
    public void deleteDB(Object ob){
        ar.remove(ob);
    }
    
}
