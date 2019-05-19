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

public class CustomerInterface extends StartInterface {

    static DefaultTableModel d = null;
    static JTable t = null;

    public void run() {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(600, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        JLabel customerLable = new JLabel();
        customerLable.setText("Customer Form");
        customerLable.setFont(new Font("Ubuntu", 0, 30));
        customerLable.setForeground(new Color(2, 125, 197));
        customerLable.setBounds(10, 10, 400, 50);
        mainFrame.add(customerLable);

        JLabel cusNameLabel = new JLabel();
        cusNameLabel.setText("Customer Name");
        cusNameLabel.setBounds(10, 60, 400, 50);
        mainFrame.add(cusNameLabel);

        JTextField txtCustomerName = new JTextField();
        txtCustomerName.setBounds(10, 100, 400, 30);
        mainFrame.add(txtCustomerName);

        JLabel cusAddressLabel = new JLabel();
        cusAddressLabel.setText("Customer Address");
        cusAddressLabel.setBounds(10, 120, 400, 50);
        mainFrame.add(cusAddressLabel);

        JTextField txtCustomerAddress = new JTextField();
        txtCustomerAddress.setBounds(10, 160, 400, 30);
        mainFrame.add(txtCustomerAddress);

        JLabel customerID = new JLabel();
        customerID.setText("Customer ID");
        customerID.setBounds(10, 180, 400, 50);
        mainFrame.add(customerID);

        JTextField txtCustomerID = new JTextField();
        txtCustomerID.setBounds(10, 220, 400, 30);
        mainFrame.add(txtCustomerID);

        //create table and scroll pan
        t = new JTable();
        JScrollPane pane = new JScrollPane();
        t.setModel(new DefaultTableModel(null, new String[]{"id", "address", "name", "addressOfObject"}));
        t.getColumnModel().getColumn(3).setMinWidth(0);
        t.getColumnModel().getColumn(3).setMaxWidth(0);
        pane.setViewportView(t);                               //data null , colum
        pane.setBounds(30, 300, 300, 100);
        mainFrame.add(pane);
        d = (DefaultTableModel) t.getModel();

        JButton save = new JButton();
        save.setText("Save Customer");
        save.setBounds(120, 260, 140, 30);
        save.setVisible(true);

        //add values in table
        save.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String a = txtCustomerName.getText();
                String b = txtCustomerAddress.getText();
                String c = txtCustomerID.getText();
                Customer c1 = new Customer();

                //add row
                d = (DefaultTableModel) t.getModel();
                Object[] row = {c, b, a, c1};
                d.addRow(row);

                c1.setAddress(b);
                c1.setId(c);
                c1.setName(a);
                cdb.saveDB(c1);
            }

        });
        mainFrame.add(save);

        //  remove selected row
        JButton remove = new JButton();
        remove.setText("Remove");
        remove.setBounds(270, 260, 140, 30);
        remove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = t.getSelectedRow();
                d.removeRow(row);
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
                update.setText("Update Customer");
                update.setBounds(120, 260, 140, 30);

                //add values in table
                update.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String a = txtCustomerName.getText();
                        String b = txtCustomerAddress.getText();
                        String c = txtCustomerID.getText();
                        d = (DefaultTableModel) t.getModel();

                        //update row
                        Object cus = t.getValueAt(t.getSelectedRow(), 3);
                        cdb.updateDB((Customer) cus, a, b, c);
                        //for (int i = 0; i < cdb.ar.size(); i++) {
                            Customer z = (Customer) cdb.ar.get(t.getSelectedRow());
                            String name = z.getName();
                            String address = z.getAddress();
                            String id = z.getId();

                            Object[] row = {id, address, name, z};
                            d.removeRow(t.getSelectedRow());
                            d.addRow(row);
                        //}
                    }

                });
                mainFrame.add(update);

                txtCustomerID.setText((String) d.getValueAt(row, 0));
                txtCustomerAddress.setText((String) d.getValueAt(row, 1));
                txtCustomerName.setText((String) d.getValueAt(row, 2));
                update.setVisible(true);
            }

        });

        mainFrame.setVisible(true);
    }
}
