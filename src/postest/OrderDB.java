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
public class OrderDB {

    ArrayList ar = new ArrayList();

    class ItemList {

        ArrayList arr = new ArrayList();

        ArrayList addItem(Order or) {
            arr.add(or);
            return arr;
        }
    }
    ArrayList ref;
    ItemList i = new ItemList();

    public void save(Order ob) {
        ref = i.addItem(ob);
    }

    public void update(Order ob, String code, String qty) {
        ob.setCode(code);
        ob.setQty(qty);
    }

    public void remove(Order or) {
        i.arr.remove(or);
    }

    public void confirmOrder(PlaseOrder or, String cusId, String orderId) {
        or.setCutomerID(cusId);
        or.setOrderID(orderId);
        or.setDate();

        ArrayList n = new ArrayList();
        n.add(or);
        n.add(ref);

        ar.add(n);
        i = new ItemList();
    }
}
