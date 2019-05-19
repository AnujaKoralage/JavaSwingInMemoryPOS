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

public class PosTest {

    static DefaultTableModel d = null;
    static JTable t = null;

    public static void main(String args[]) {
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
        txtCustomerName.setBounds(10, 100, 400, 20);
        mainFrame.add(txtCustomerName);

        JLabel cusAddressLabel = new JLabel();
        cusAddressLabel.setText("Customer Address");
        cusAddressLabel.setBounds(10, 120, 400, 50);
        mainFrame.add(cusAddressLabel);

        JTextField txtCustomerAddress = new JTextField();
        txtCustomerAddress.setBounds(10, 160, 400, 20);
        mainFrame.add(txtCustomerAddress);

        JLabel customerID = new JLabel();
        customerID.setText("Customer ID");
        customerID.setBounds(10, 180, 400, 50);
        mainFrame.add(customerID);

        JTextField txtCustomerID = new JTextField();
        txtCustomerID.setBounds(10, 220, 400, 20);
        mainFrame.add(txtCustomerID);
        
        
        //create table and scroll pan
        t = new JTable();
        JScrollPane pane = new JScrollPane();
        t.setModel(new DefaultTableModel(null, new String[]{"id", "address", "name"}));
        pane.setViewportView(t);                               //data null , colum
        pane.setBounds(30, 300, 300, 100);
        mainFrame.add(pane);
        d = (DefaultTableModel) t.getModel();

        JButton btn = new JButton();
        btn.setText("Save Customer");
        btn.setBounds(120, 260, 140, 30);

        //add values in table
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String a = txtCustomerName.getText();
                String b = txtCustomerAddress.getText();
                String c = txtCustomerID.getText();

                //add row
                d=(DefaultTableModel) t.getModel();
                Object[] row = {c, b, a};
                d.addRow(row);
            }

        });
        mainFrame.add(btn);

      //  remove selected row
        
        JButton btn2 = new JButton();
        btn2.setText("Remove");
        btn2.setBounds(270, 260, 140, 30);
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = t.getSelectedRow();
                d.removeRow(row);
            }

        });

        mainFrame.add(btn2);

        // selected row set texfeilds
        
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = t.getSelectedRow();
                //int col= t.getSelectedColumn();

                txtCustomerID.setText((String) d.getValueAt(row, 0));
                txtCustomerAddress.setText((String) d.getValueAt(row, 1));
                txtCustomerName.setText((String) d.getValueAt(row, 2));
                // d.removeRow(row);
            }

        });

        mainFrame.setVisible(true);
    }
}
