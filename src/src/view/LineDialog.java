package com.sales.src.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LineDialog extends JDialog {
    private JTextField itemNameField = new JTextField(20);
    private JTextField itemCountField = new JTextField(20);
    private JTextField itemPriceField = new JTextField(20);
    private JLabel itemNameLbl = new JLabel("Item Name");
    private JLabel itemCountLbl = new JLabel("Item Count");
    private JLabel itemPriceLbl = new JLabel("Item Price");
    private JButton okBtn = new JButton("OK");
    private JButton cancelBtn = new JButton("Cancel");

    public LineDialog(InvoiceFrame frame) {
        this.okBtn.setActionCommand("createLineOK");
        this.cancelBtn.setActionCommand("createLineCancel");
        this.okBtn.addActionListener(frame.getController());
        this.cancelBtn.addActionListener(frame.getController());
        this.setLayout(new GridLayout(4, 2));
        this.add(this.itemNameLbl);
        this.add(this.itemNameField);
        this.add(this.itemCountLbl);
        this.add(this.itemCountField);
        this.add(this.itemPriceLbl);
        this.add(this.itemPriceField);
        this.add(this.okBtn);
        this.add(this.cancelBtn);
        this.pack();
    }

    public JTextField getItemNameField() {
        return this.itemNameField;
    }

    public JTextField getItemCountField() {
        return this.itemCountField;
    }

    public JTextField getItemPriceField() {
        return this.itemPriceField;
    }
}
