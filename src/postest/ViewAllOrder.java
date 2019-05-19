/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postest;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static postest.ItemInterface.t;

/**
 *
 * @author User
 */
public class ViewAllOrder extends StartInterface{

    public void run() {
        DefaultTableModel d =null;
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(600, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        
        JTable t = new JTable();
        JScrollPane pane = new JScrollPane();
        t.setModel(new DefaultTableModel(null, new String[]{"Order ID", "Customer ID", "Date"}));
        pane.setViewportView(t);                               //data null , colum
        pane.setBounds(0, 0, 600, 500);
        mainFrame.add(pane);
        
        mainFrame.setVisible(true);
        
        for (int i = 0; i < odb.ar.size(); i++) {
            d = (DefaultTableModel) t.getModel();
            ArrayList a = (ArrayList) odb.ar.get(i);
            PlaseOrder p = (PlaseOrder) a.get(0);
            Object[] row = {p.getOrderID(),p.getCutomerID(),p.getDate()};
            d.addRow(row);
        }
    }
}
