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
public class CustomerDB implements DB{
    
    ArrayList ar = new ArrayList();

    @Override
    public void saveDB(Object ob) {
    ar.add(ob);
    }

    public void updateDB(Customer c, String name, String address, String id) {
        c.setAddress(address);
        c.setId(id);
        c.setName(name);
    }

    @Override
    public void deleteDB(Object ob) {
        ar.remove(ob);
    }
    
    
}
