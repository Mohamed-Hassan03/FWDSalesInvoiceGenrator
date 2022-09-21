package com.sales.src.controller;

import com.sales.src.model.Line;
import com.sales.src.model.LinesTableModel;
import com.sales.src.view.InvoiceDialog;
import com.sales.src.view.InvoiceFrame;
//import com.sales.src.view.LineDialog;
import com.sales.src.model.Invoice;
import com.sales.src.model.InvoicesTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener {
    private InvoiceFrame frame;
    private InvoiceDialog invoiceDialog;
    private com.sales.src.view.LineDialog lineDialog;

    public Controller(InvoiceFrame frame) {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println("Action: " + actionCommand);
        byte var4 = -1;
        switch(actionCommand.hashCode()) {
            case -960965514:
                if (actionCommand.equals("Load File")) {
                    var4 = 0;
                }
                break;
            case -792596393:
                if (actionCommand.equals("Create New Item")) {
                    var4 = 4;
                }
                break;
            case 440593848:
                if (actionCommand.equals("Delete Invoice")) {
                    var4 = 3;
                }
                break;
            case 486593640:
                if (actionCommand.equals("Delete Item")) {
                    var4 = 5;
                }
                break;
            case 1090392109:
                if (actionCommand.equals("createInvoiceOK")) {
                    var4 = 7;
                }
                break;
            case 1163031978:
                if (actionCommand.equals("createLineCancel")) {
                    var4 = 9;
                }
                break;
            case 1325100268:
                if (actionCommand.equals("createLineOK")) {
                    var4 = 8;
                }
                break;
            case 1335138153:
                if (actionCommand.equals("Create New Invoice")) {
                    var4 = 2;
                }
                break;
            case 1658818667:
                if (actionCommand.equals("createInvoiceCancel")) {
                    var4 = 6;
                }
                break;
            case 2128551487:
                if (actionCommand.equals("Save File")) {
                    var4 = 1;
                }
        }

        switch(var4) {
            case 0:
                this.loadFile();
                break;
            case 1:
                this.saveFile();
                break;
            case 2:
                this.newInvoice();
                break;
            case 3:
                this.deleteAnInvoice();
                break;
            case 4:
                this.newItem();
                break;
            case 5:
                this.deleteAnItem();
                break;
            case 6:
                this.cancelInvoice();
                break;
            case 7:
                this.newInvoiceOK();
                break;
            case 8:
                this.newLineOK();
                break;
            case 9:
                this.createLineCancel();
        }

    }

    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = this.frame.getInvoicesTable1().getSelectedRow();
        if (selectedIndex != -1) {
            System.out.println("You have selected row: " + selectedIndex);
            Invoice currentInvoice = (Invoice)this.frame.getInvoices().get(selectedIndex);
            this.frame.getInvoiceNum1().setText("" + currentInvoice.getNumber());
            this.frame.getInvoiceDate().setText(currentInvoice.getDate());
            this.frame.getCustomerName().setText(currentInvoice.getCustomerName());
            this.frame.getTotalInvoices().setText("" + currentInvoice.getInvoiceTotal());
            LinesTableModel linesTableModel = new LinesTableModel(currentInvoice.getLines());
            this.frame.getLineTable().setModel(linesTableModel);
            linesTableModel.fireTableDataChanged();
        }

    }

    private void loadFile() {
        JFileChooser fc = new JFileChooser();

        try {
            int result = fc.showOpenDialog(this.frame);
            if (result == 0) {
                File headerFile = fc.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                System.out.println("Invoices have been read");
                ArrayList<Invoice> invoicesArray = new ArrayList();
                Iterator var7 = headerLines.iterator();

                String lineLine;
                while(var7.hasNext()) {
                    String headerLine = (String)var7.next();

                    try {
                        String[] headerParts = headerLine.split(",");
                        int invoiceNum = Integer.parseInt(headerParts[0]);
                        lineLine = headerParts[1];
                        String customerName = headerParts[2];
                        Invoice invoice = new Invoice(invoiceNum, lineLine, customerName);
                        invoicesArray.add(invoice);
                    } catch (Exception var21) {
                        var21.printStackTrace();
                        JOptionPane.showMessageDialog(this.frame, "Error in line format", "Error", 0);
                    }
                }

                System.out.println("Check point");
                result = fc.showOpenDialog(this.frame);
                if (result == 0) {
                    File lineFile = fc.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(linePath);
                    System.out.println("Lines have been read");
                    Iterator var28 = lineLines.iterator();

                    while(var28.hasNext()) {
                        lineLine = (String)var28.next();

                        try {
                            String[] lineParts = lineLine.split(",");
                            int invoiceNum = Integer.parseInt(lineParts[0]);
                            String itemName = lineParts[1];
                            double itemPrice = Double.parseDouble(lineParts[2]);
                            int count = Integer.parseInt(lineParts[3]);
                            Invoice inv = null;
                            Iterator var19 = invoicesArray.iterator();

                            while(var19.hasNext()) {
                                Invoice invoice = (Invoice)var19.next();
                                if (invoice.getNumber() == invoiceNum) {
                                    inv = invoice;
                                    break;
                                }
                            }

                            Line line = new Line(itemName, itemPrice, count, inv);
                            inv.getLines().add(line);
                        } catch (Exception var22) {
                            var22.printStackTrace();
                            JOptionPane.showMessageDialog(this.frame, "Error in line format", "Error", 0);
                        }
                    }

                    System.out.println("Check point");
                }

                this.frame.newInvoice(invoicesArray);
                InvoicesTableModel invoicesTableModel = new InvoicesTableModel(invoicesArray);
                this.frame.setInvoicesTable(invoicesTableModel);
                this.frame.getInvoicesTable1().setModel(invoicesTableModel);
                this.frame.getInvoicesTable().fireTableDataChanged();
            }
        } catch (IOException var23) {
            var23.printStackTrace();
            JOptionPane.showMessageDialog(this.frame, "Cannot read file", "Error", 0);
        }

    }

    private void saveFile() {
        ArrayList<Invoice> invoices = this.frame.getInvoices();
        String headers = "";
        String lines = "";
        Iterator var4 = invoices.iterator();

        while(var4.hasNext()) {
            Invoice invoice = (Invoice)var4.next();
            String invCSV = invoice.getAsCSV();
            headers = headers + invCSV;
            headers = headers + "\n";

            for(Iterator var7 = invoice.getLines().iterator(); var7.hasNext(); lines = lines + "\n") {
                Line line = (Line)var7.next();
                String lineCSV = line.getAsCSV();
                lines = lines + lineCSV;
            }
        }

        System.out.println("Check point");

        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(this.frame);
            if (result == 0) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(this.frame);
                if (result == 0) {
                    File lineFile = fc.getSelectedFile();
                    FileWriter lfw = new FileWriter(lineFile);
                    lfw.write(lines);
                    lfw.flush();
                    lfw.close();
                }
            }
        } catch (Exception var10) {
        }

    }

    private void newInvoice() {
        this.invoiceDialog = new InvoiceDialog(this.frame);
        this.invoiceDialog.setVisible(true);
    }

    private void deleteAnInvoice() {
        int selectedRow = this.frame.getInvoicesTable1().getSelectedRow();
        if (selectedRow != -1) {
            this.frame.getInvoices().remove(selectedRow);
            this.frame.getInvoicesTable().fireTableDataChanged();
        }

    }

    private void newItem() {
        this.lineDialog = new com.sales.src.view.LineDialog(this.frame);
        this.lineDialog.setVisible(true);
    }

    private void deleteAnItem() {
        int selectedRow = this.frame.getLineTable().getSelectedRow();
        if (selectedRow != -1) {
            LinesTableModel linesTableModel = (LinesTableModel)this.frame.getLineTable().getModel();
            linesTableModel.getLines().remove(selectedRow);
            linesTableModel.fireTableDataChanged();
            this.frame.getInvoicesTable().fireTableDataChanged();
        }

    }

    private void cancelInvoice() {
        this.invoiceDialog.setVisible(false);
        this.invoiceDialog.dispose();
        this.invoiceDialog = null;
    }

    private void newInvoiceOK() {
        String date = this.invoiceDialog.getInvDateField().getText();
        String customer = this.invoiceDialog.getCustmerNameField().getText();
        int num = this.frame.getNextInvoiceNum();

        try {
            String[] dateParts = date.split("-");
            if (dateParts.length < 3) {
                JOptionPane.showMessageDialog(this.frame, "Wrong date format", "Error", 0);
            } else {
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);
                if (day <= 31 && month <= 12) {
                    Invoice invoice = new Invoice(num, date, customer);
                    this.frame.getInvoices().add(invoice);
                    this.frame.getInvoicesTable().fireTableDataChanged();
                    this.invoiceDialog.setVisible(false);
                    this.invoiceDialog.dispose();
                    this.invoiceDialog = null;
                } else {
                    JOptionPane.showMessageDialog(this.frame, "Wrong date format", "Error", 0);
                }
            }
        } catch (Exception var9) {
            JOptionPane.showMessageDialog(this.frame, "Wrong date format", "Error", 0);
        }

    }

    private void newLineOK() {
        String item = this.lineDialog.getItemNameField().getText();
        String countStr = this.lineDialog.getItemCountField().getText();
        String priceStr = this.lineDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = this.frame.getInvoicesTable1().getSelectedRow();
        if (selectedInvoice != -1) {
            Invoice invoice = (Invoice)this.frame.getInvoices().get(selectedInvoice);
            Line line = new Line(item, price, count, invoice);
            invoice.getLines().add(line);
            LinesTableModel linesTableModel = (LinesTableModel)this.frame.getLineTable().getModel();
            linesTableModel.fireTableDataChanged();
            this.frame.getInvoicesTable().fireTableDataChanged();
        }

        this.lineDialog.setVisible(false);
        this.lineDialog.dispose();
        this.lineDialog = null;
    }

    private void createLineCancel() {
        this.lineDialog.setVisible(false);
        this.lineDialog.dispose();
        this.lineDialog = null;
    }
}
