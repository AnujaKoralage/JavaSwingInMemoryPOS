/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static postest.ItemInterface.d1;
import static postest.StartInterface.odb;

/**
 *
 * @author User
 */
public class OrderInterface extends StartInterface {

    static DefaultTableModel d1 = null;
    static JComboBox dd = null;
    static JTable t = null;
    OrderDataRetriver dataRetriveClass = new OrderDataRetriver();

    public void run() {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(600, 900);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        JLabel customerLable = new JLabel();
        customerLable.setText("Item Form");
        customerLable.setFont(new Font("Ubuntu", 0, 30));
        customerLable.setForeground(new Color(2, 125, 197));
        customerLable.setBounds(10, 10, 400, 50);
        mainFrame.add(customerLable);

        JLabel orderID = new JLabel();
        orderID.setText("Oder ID");
        orderID.setBounds(10, 60, 400, 50);
        mainFrame.add(orderID);

        JTextField txtOderId = new JTextField();
        txtOderId.setBounds(10, 100, 400, 30);
        mainFrame.add(txtOderId);

        JLabel orderDate = new JLabel();
        orderDate.setText("Order Date");
        orderDate.setBounds(10, 120, 400, 50);
        mainFrame.add(orderDate);

        JTextField txtOrderDate = new JTextField();
        txtOrderDate.setEditable(false);
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        txtOrderDate.setText(formattedDate);
        txtOrderDate.setBounds(10, 160, 400, 30);
        mainFrame.add(txtOrderDate);

        JLabel customerID = new JLabel();
        customerID.setText("Customer ID");
        customerID.setBounds(10, 180, 400, 50);
        mainFrame.add(customerID);

        dd = new JComboBox();

        for (int i = 0; i < cdb.ar.size(); i++) {
            Customer c = (Customer) cdb.ar.get(i);
            dd.addItem(c.getId());
        }
        dd.setBounds(10, 220, 400, 30);
        dd.setVisible(true);
        dd.setSelectedIndex(0);
        //JScrollPane djp = new JScrollPane(dd);
        mainFrame.add(dd);

        JLabel cutomerName = new JLabel();
        cutomerName.setText("Customer Name");
        cutomerName.setBounds(10, 240, 400, 50);
        mainFrame.add(cutomerName);

        JTextField txtCusName = new JTextField();
        txtCusName.setEditable(false);
        txtCusName.setBounds(10, 280, 400, 30);
        mainFrame.add(txtCusName);

        JLabel itemCode = new JLabel();
        itemCode.setText("Item code");
        itemCode.setBounds(10, 300, 400, 50);
        mainFrame.add(itemCode);

        JComboBox cb = new JComboBox();

        for (int i = 0; i < idb.ar.size(); i++) {
            Item it = (Item) idb.ar.get(i);
            cb.addItem(it.getCode());
        }
        cb.setBounds(10, 340, 400, 30);
        cb.setVisible(true);
        cb.setSelectedIndex(0);
        mainFrame.add(cb);

        /*JTextField txtCode = new JTextField();
        txtCode.setBounds(10, 340, 400, 30);
        mainFrame.add(txtCode);*/
        JLabel description = new JLabel();
        description.setText("Description");
        description.setBounds(10, 360, 400, 50);
        mainFrame.add(description);

        JTextField txtDes = new JTextField();
        txtDes.setEditable(false);
        txtDes.setBounds(10, 400, 400, 30);
        mainFrame.add(txtDes);

        JLabel qtyOnHand = new JLabel();
        qtyOnHand.setText("Qantity on hand");
        qtyOnHand.setBounds(10, 420, 400, 50);
        mainFrame.add(qtyOnHand);

        JTextField txtQtyOnHand = new JTextField();
        txtQtyOnHand.setEditable(false);
        txtQtyOnHand.setBounds(10, 460, 400, 30);
        mainFrame.add(txtQtyOnHand);

        JLabel unitPrice = new JLabel();
        unitPrice.setText("Unit Price");
        unitPrice.setBounds(10, 480, 400, 50);
        mainFrame.add(unitPrice);

        JTextField txtPrice4 = new JTextField();
        txtPrice4.setBounds(10, 520, 400, 30);
        txtPrice4.setEditable(false);
        mainFrame.add(txtPrice4);

        JLabel quatity = new JLabel();
        quatity.setText("Quantity");
        quatity.setBounds(10, 540, 400, 50);
        mainFrame.add(quatity);

        JTextField txtQuantity = new JTextField();
        txtQuantity.setBounds(10, 580, 400, 30);
        mainFrame.add(txtQuantity);

        dd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCusID = (String) dd.getSelectedItem();
                txtCusName.setText(dataRetriveClass.customerNameRetriver(selectedCusID));
            }
        });

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = (String) cb.getSelectedItem();
                txtPrice4.setText(dataRetriveClass.priceRetriver(code));
                txtDes.setText(dataRetriveClass.descriptionRetriver(code));
                txtQtyOnHand.setText(dataRetriveClass.quantityRetriver(code));
            }
        });

        //create table and scroll pan
        t = new JTable();
        JScrollPane pane = new JScrollPane();
        t.setModel(new DefaultTableModel(null, new String[]{"code", "description", "quantity", "unitprice", "total", "ref"}));
        t.getColumnModel().getColumn(5).setMinWidth(0);
        t.getColumnModel().getColumn(5).setMaxWidth(0);
        pane.setViewportView(t);                               //data null , colum
        pane.setBounds(30, 680, 300, 100);
        mainFrame.add(pane);
        d1 = (DefaultTableModel) t.getModel();

        JButton save = new JButton();
        save.setText("Save Item");
        save.setBounds(120, 640, 140, 30);
        save.setVisible(true);

        //add values in table
        save.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String itemCode = (String) cb.getSelectedItem();
                String qty = txtQuantity.getText();

                Order or = new Order();
                or.setCode(itemCode);
                or.setQty(qty);

                odb.save(or);

                d1 = (DefaultTableModel) t.getModel();
                int tot = Integer.parseInt(qty) * Integer.parseInt(dataRetriveClass.priceRetriver(itemCode));
                Object[] row = {itemCode, dataRetriveClass.descriptionRetriver(itemCode), qty, dataRetriveClass.priceRetriver(itemCode), Integer.toString(tot), or};
                d1.addRow(row);

            }

        });
        mainFrame.add(save);

        //  remove selected row
        JButton remove = new JButton();
        remove.setText("Remove");
        remove.setBounds(270, 640, 140, 30);
        remove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = t.getSelectedRow();
                d1.removeRow(row);

                odb.remove((Order) t.getValueAt(t.getSelectedRow(), 5));
            }

        });

        mainFrame.add(remove);

        JButton plaseOrder = new JButton();
        plaseOrder.setText("Plase Order");
        plaseOrder.setBounds(270, 800, 140, 30);
        plaseOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlaseOrder p = new PlaseOrder();
                odb.confirmOrder(p, dd.getSelectedItem().toString(), txtOderId.getText());
                
                
            }
        });
        mainFrame.add(plaseOrder);

        // selected row set texfeilds
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                save.setVisible(false);

                int row = t.getSelectedRow();
                JButton update = new JButton();
                update.setText("Update Item");
                update.setBounds(120, 640, 140, 30);

                //add values in table
                update.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String itemCode = (String) cb.getSelectedItem();
                        String itemQty = txtQuantity.getText();

                        Order address = (Order) t.getValueAt(t.getSelectedRow(), 5);
                        odb.update(address, itemCode, itemQty);
                        d1 = (DefaultTableModel) t.getModel();

                        d1.removeRow(t.getSelectedRow());
                        int tot = Integer.parseInt(itemQty) * Integer.parseInt(dataRetriveClass.priceRetriver(itemCode));
                        Object[] row = {itemCode, dataRetriveClass.descriptionRetriver(itemCode), itemQty, dataRetriveClass.priceRetriver(itemCode), Integer.toString(tot), address};
                        d1.addRow(row);
                    }

                });
                mainFrame.add(update);

                txtDes.setText((String) d1.getValueAt(row, 1));
                txtQuantity.setText((String) d1.getValueAt(row, 2));
                txtPrice4.setText((String) d1.getValueAt(row, 2));
                update.setVisible(true);
            }

        });

        mainFrame.setVisible(true);
    }
}
