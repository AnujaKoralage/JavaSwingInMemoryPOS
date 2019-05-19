/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postest;

/**
 *
 * @author User
 */
public class OrderDataRetriver extends StartInterface{
    public String customerNameRetriver(String cusID){
        Customer c;
        int i;
        for (i = 0; i < cdb.ar.size(); i++) {
            c = (Customer) cdb.ar.get(i);
            if(c.getId().equals(cusID)){
                break;
            }
        }
        c = (Customer) cdb.ar.get(i);
        return c.getName();
    }
    public String descriptionRetriver(String code){
        Item i;
        int j;
        for (j = 0; j < idb.ar.size(); j++) {
            i = (Item) idb.ar.get(j);
            if(i.getCode().equals(code)){
                break;
            }
        }
        i = (Item) idb.ar.get(j);
        return i.getDescription();
    }
    
    public String quantityRetriver(String code){
        Item i;
        int j;
        for (j = 0; j < idb.ar.size(); j++) {
            i = (Item) idb.ar.get(j);
            if(i.getCode().equals(code)){
                break;
            }
        }
        i = (Item) idb.ar.get(j);
        return i.getQty();
    }
    
    public String priceRetriver(String code){
        Item i;
        int j;
        for (j = 0; j < idb.ar.size(); j++) {
            i = (Item) idb.ar.get(j);
            if(i.getCode().equals(code)){
                break;
            }
        }
        i = (Item) idb.ar.get(j);
        return i.getPrice();
    }
}
