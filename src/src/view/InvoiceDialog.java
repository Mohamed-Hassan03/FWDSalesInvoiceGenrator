package com.sales.src.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoiceDialog extends JDialog {
    private JTextField custmerNameField = new JTextField(20);
    private JTextField invDateField = new JTextField(20);
    private JLabel custNameLbl = new JLabel("Customer Name:");
    private JLabel invDateLbl = new JLabel("Invoice Date:");
    private JButton okBtn = new JButton("OK");
    private JButton cancelBtn = new JButton("Cancel");

    public InvoiceDialog(InvoiceFrame frame) {
        this.okBtn.setActionCommand("createInvoiceOK");
        this.cancelBtn.setActionCommand("createInvoiceCancel");
        this.okBtn.addActionListener(frame.getController());
        this.cancelBtn.addActionListener(frame.getController());
        this.setLayout(new GridLayout(3, 2));
        this.add(this.invDateLbl);
        this.add(this.invDateField);
        this.add(this.custNameLbl);
        this.add(this.custmerNameField);
        this.add(this.okBtn);
        this.add(this.cancelBtn);
        this.pack();
    }

    public JTextField getCustmerNameField() {
        return this.custmerNameField;
    }

    public JTextField getInvDateField() {
        return this.invDateField;
    }
}
