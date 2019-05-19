/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ItemInterface extends StartInterface{
    static DefaultTableModel d1 = null;
    static JTable t = null;

    public void run() {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(600, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        JLabel customerLable = new JLabel();
        customerLable.setText("Item Form");
        customerLable.setFont(new Font("Ubuntu", 0, 30));
        customerLable.setForeground(new Color(2, 125, 197));
        customerLable.setBounds(10, 10, 400, 50);
        mainFrame.add(customerLable);

        JLabel cusNameLabel = new JLabel();
        cusNameLabel.setText("Code");
        cusNameLabel.setBounds(10, 60, 400, 50);
        mainFrame.add(cusNameLabel);

        JTextField txtCode = new JTextField();
        txtCode.setBounds(10, 100, 400, 30);
        mainFrame.add(txtCode);

        JLabel cusAddressLabel = new JLabel();
        cusAddressLabel.setText("Description");
        cusAddressLabel.setBounds(10, 120, 400, 50);
        mainFrame.add(cusAddressLabel);

        JTextField txtDescription = new JTextField();
        txtDescription.setBounds(10, 160, 400, 30);
        mainFrame.add(txtDescription);

        JLabel customerID = new JLabel();
        customerID.setText("Quantity");
        customerID.setBounds(10, 180, 400, 50);
        mainFrame.add(customerID);

        JTextField txtQty = new JTextField();
        txtQty.setBounds(10, 220, 400, 30);
        mainFrame.add(txtQty);
        
        JLabel customerp = new JLabel();
        customerp.setText("Unit Price");
        customerp.setBounds(10, 240, 400, 50);
        mainFrame.add(customerp);

        JTextField txtPrice = new JTextField();
        txtPrice.setBounds(10, 280, 400, 30);
        mainFrame.add(txtPrice);

        //create table and scroll pan
        t = new JTable();
        JScrollPane pane = new JScrollPane();
        t.setModel(new DefaultTableModel(null, new String[]{"code", "description", "quantity", "unitprice","ref"}));
        t.getColumnModel().getColumn(4).setMinWidth(0);
        t.getColumnModel().getColumn(4).setMaxWidth(0);
        pane.setViewportView(t);                               //data null , colum
        pane.setBounds(30, 430, 300, 100);
        mainFrame.add(pane);
        d1 = (DefaultTableModel) t.getModel();

        JButton save = new JButton();
        save.setText("Save Item");
        save.setBounds(120, 390, 140, 30);
        save.setVisible(true);

        //add values in table
        save.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String a = txtCode.getText();
                String b = txtDescription.getText();
                String c = txtQty.getText();
                String d = txtPrice.getText();
                Item i = new Item();

                //add row
                d1 = (DefaultTableModel) t.getModel();
                Object[] row = {a,b,c,d,i};
                d1.addRow(row);

                i.setCode(a);
                i.setDescription(b);
                i.setPrice(d);
                i.setQty(c);
                idb.ar.add(i);
            }

        });
        mainFrame.add(save);

        //  remove selected row
        JButton remove = new JButton();
        remove.setText("Remove");
        remove.setBounds(270, 390, 140, 30);
        remove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = t.getSelectedRow();
                d1.removeRow(row);
            }

        });

        mainFrame.add(remove);

        // selected row set texfeilds
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                save.setVisible(false);

                int row = t.getSelectedRow();
                JButton update = new JButton();
                update.setText("Update Item");
                update.setBounds(120, 390, 140, 30);

                //add values in table
                update.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String a = txtCode.getText();
                        String b = txtDescription.getText();
                        String c = txtPrice.getText();
                        String d = txtQty.getText();
                        d1 = (DefaultTableModel) t.getModel();

                        //update row
                        Object cus = t.getValueAt(t.getSelectedRow(), 4);
                        idb.updateDB((Item) cus, a, b, c, d);
                        //for (int i = 0; i < cdb.ar.size(); i++) {
                            Item z = (Item) idb.ar.get(t.getSelectedRow());
                            String code = z.getCode();
                            String description = z.getDescription();
                            String price = z.getPrice();
                            String qty = z.getQty();

                            Object[] row = {code, description, price, qty, z};
                            d1.removeRow(t.getSelectedRow());
                            d1.addRow(row);
                        //}
                    }

                });
                mainFrame.add(update);

                txtCode.setText((String) d1.getValueAt(row, 0));
                txtDescription.setText((String) d1.getValueAt(row, 1));
                txtPrice.setText((String) d1.getValueAt(row, 2));
                txtQty.setText((String) d1.getValueAt(row, 2));
                update.setVisible(true);
            }

        });

        mainFrame.setVisible(true);
    }
}
