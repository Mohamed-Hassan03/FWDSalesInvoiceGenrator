package com.sales.src.view;

import com.sales.src.controller.Controller;
import com.sales.src.model.Invoice;
import com.sales.src.model.InvoicesTableModel;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

public class InvoiceFrame extends JFrame {
    private JButton newInvoiceBtn;
    private JButton newLineBtn;
    private JLabel customerNameField;
    private JButton deleteInvoiceBtn;
    private JButton deleteLineBtn;
    private JLabel invoiceDateField;
    private JLabel invoiceNum1;
    private JTable invoicesTable1;
    private JLabel totalInvoice;
    private JLabel labelNum1;
    private JLabel labelNum2;
    private JLabel labelNum3;
    private JLabel labelNum4;
    private JMenu menu1;
    private JMenuBar menuBar1;
    private JScrollPane scrollTab;
    private JScrollPane scrollTab2;
    private JTable lineTable;
    private JMenuItem loadFileMenuItem;
    private JMenuItem saveFileMenuItem;
    private ArrayList<Invoice> invoices;
    private Controller controller = new Controller(this);
    private InvoicesTableModel invoicesTableModel;

    public InvoiceFrame() {
        this.initComponents();
    }

    private void initComponents() {
        this.scrollTab = new JScrollPane();
        this.invoicesTable1 = new JTable();
        this.invoicesTable1.getSelectionModel().addListSelectionListener(this.controller);
        this.invoicesTable1.setModel(this.getInvoicesTable());
        this.newInvoiceBtn = new JButton();
        this.newInvoiceBtn.addActionListener(this.controller);
        this.deleteInvoiceBtn = new JButton();
        this.deleteInvoiceBtn.addActionListener(this.controller);
        this.labelNum1 = new JLabel();
        this.labelNum2 = new JLabel();
        this.labelNum3 = new JLabel();
        this.labelNum4 = new JLabel();
        this.customerNameField = new JLabel();
        this.invoiceDateField = new JLabel();
        this.invoiceNum1 = new JLabel();
        this.totalInvoice = new JLabel();
        this.scrollTab2 = new JScrollPane();
        this.lineTable = new JTable();
        this.newLineBtn = new JButton();
        this.newLineBtn.addActionListener(this.controller);
        this.deleteLineBtn = new JButton();
        this.deleteLineBtn.addActionListener(this.controller);
        this.menuBar1 = new JMenuBar();
        this.menu1 = new JMenu();
        this.loadFileMenuItem = new JMenuItem();
        this.loadFileMenuItem.addActionListener(this.controller);
        this.saveFileMenuItem = new JMenuItem();
        this.saveFileMenuItem.addActionListener(this.controller);
        this.setDefaultCloseOperation(3);
        this.setBackground(new Color(204, 204, 204));
        this.scrollTab.setBackground(this.getContentPane().getBackground());
        this.invoicesTable1.setBackground(this.getContentPane().getBackground());
        this.invoicesTable1.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.scrollTab.setViewportView(this.invoicesTable1);
        this.newInvoiceBtn.setBackground(this.getContentPane().getBackground());
        this.newInvoiceBtn.setText("Create New Invoice");
        this.deleteInvoiceBtn.setBackground(this.getContentPane().getBackground());
        this.deleteInvoiceBtn.setText("Delete Invoice");
        this.deleteInvoiceBtn.setOpaque(false);
        this.labelNum1.setBackground(this.getContentPane().getBackground());
        this.labelNum1.setText("Inoice Number");
        this.labelNum1.setOpaque(true);
        this.labelNum2.setBackground(this.getContentPane().getBackground());
        this.labelNum2.setText("Invoice Date");
        this.labelNum2.setOpaque(true);
        this.labelNum3.setBackground(this.getContentPane().getBackground());
        this.labelNum3.setText("Customer Name");
        this.labelNum3.setOpaque(true);
        this.labelNum4.setBackground(this.getContentPane().getBackground());
        this.labelNum4.setText("Invoice Total");
        this.labelNum4.setOpaque(true);
        this.customerNameField.setBackground(this.getContentPane().getBackground());
        this.customerNameField.setOpaque(true);
        this.invoiceDateField.setBackground(this.getContentPane().getBackground());
        this.invoiceDateField.setOpaque(true);
        this.invoiceNum1.setBackground(this.getContentPane().getBackground());
        this.invoiceNum1.setOpaque(true);
        this.totalInvoice.setBackground(this.getContentPane().getBackground());
        this.totalInvoice.setOpaque(true);
        this.scrollTab2.setBackground(this.getContentPane().getBackground());
        this.lineTable.setBackground(this.getContentPane().getBackground());
        this.lineTable.setModel(new DefaultTableModel(new Object[0][], new String[0]));
        this.scrollTab2.setViewportView(this.lineTable);
        this.newLineBtn.setBackground(this.getContentPane().getBackground());
        this.newLineBtn.setText("Create New Item");
        this.deleteLineBtn.setBackground(this.getContentPane().getBackground());
        this.deleteLineBtn.setText("Delete Item");
        this.menu1.setText("File");
        this.loadFileMenuItem.setText("Load File");
        this.menu1.add(this.loadFileMenuItem);
        this.saveFileMenuItem.setText("Save File");
        this.menu1.add(this.saveFileMenuItem);
        this.menuBar1.add(this.menu1);
        this.setJMenuBar(this.menuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.scrollTab, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(43, 43, 43).addComponent(this.newInvoiceBtn).addGap(131, 131, 131).addComponent(this.deleteInvoiceBtn))).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.labelNum4).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.totalInvoice)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.labelNum1).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.invoiceNum1)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.labelNum2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.invoiceDateField)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.labelNum3).addGap(18, 18, 18).addComponent(this.customerNameField))).addComponent(this.scrollTab2, -2, -1, -2)).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addGap(76, 76, 76).addComponent(this.newLineBtn).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.deleteLineBtn).addGap(133, 133, 133)))));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.labelNum1).addComponent(this.invoiceNum1)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.labelNum2).addComponent(this.invoiceDateField)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.labelNum3).addComponent(this.customerNameField)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.labelNum4).addComponent(this.totalInvoice)).addGap(18, 18, 18).addComponent(this.scrollTab2, -2, 295, -2)).addComponent(this.scrollTab)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.deleteInvoiceBtn).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.newInvoiceBtn).addComponent(this.newLineBtn).addComponent(this.deleteLineBtn))).addContainerGap(-1, 32767)));
        this.pack();
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new InvoiceFrame()).setVisible(true);
            }
        });
    }

    public ArrayList<Invoice> getInvoices() {
        if (this.invoices == null) {
            this.invoices = new ArrayList();
        }

        return this.invoices;
    }

    public void newInvoice(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public InvoicesTableModel getInvoicesTable() {
        if (this.invoicesTableModel == null) {
            this.invoicesTableModel = new InvoicesTableModel(this.getInvoices());
        }

        return this.invoicesTableModel;
    }

    public void setInvoicesTable(InvoicesTableModel invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public JLabel getCustomerName() {
        return this.customerNameField;
    }

    public JLabel getInvoiceDate() {
        return this.invoiceDateField;
    }

    public JLabel getInvoiceNum1() {
        return this.invoiceNum1;
    }

    public JTable getInvoicesTable1() {
        return this.invoicesTable1;
    }

    public JLabel getTotalInvoices() {
        return this.totalInvoice;
    }

    public JTable getLineTable() {
        return this.lineTable;
    }

    public Controller getController() {
        return this.controller;
    }

    public int getNextInvoiceNum() {
        int num = 0;
        Iterator var2 = this.getInvoices().iterator();

        while(var2.hasNext()) {
            Invoice invoice = (Invoice)var2.next();
            if (invoice.getNumber() > num) {
                num = invoice.getNumber();
            }
        }

        ++num;
        return num;
    }
}
