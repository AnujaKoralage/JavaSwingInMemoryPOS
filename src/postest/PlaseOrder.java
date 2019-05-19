/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class PlaseOrder {
    String orderID;
    String cutomerID;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCutomerID() {
        return cutomerID;
    }

    public void setCutomerID(String cutomerID) {
        this.cutomerID = cutomerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat. format(date);
        this.date = formattedDate;
    }
    String date;
    
}
