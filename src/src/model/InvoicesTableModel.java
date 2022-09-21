package com.sales.src.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoicesTableModel extends AbstractTableModel {
    private ArrayList<com.sales.src.model.Invoice> invoices;
    private String[] columns = new String[]{"No.", "Date", "Customer", "Total"};

    public InvoicesTableModel(ArrayList<com.sales.src.model.Invoice> invoices) {
        this.invoices = invoices;
    }

    public int getRowCount() {
        return this.invoices.size();
    }

    public int getColumnCount() {
        return this.columns.length;
    }

    public String getColumnName(int column) {
        return this.columns[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        com.sales.src.model.Invoice invoice = (com.sales.src.model.Invoice)this.invoices.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return invoice.getNumber();
            case 1:
                return invoice.getDate();
            case 2:
                return invoice.getCustomerName();
            case 3:
                return invoice.getInvoiceTotal();
            default:
                return "";
        }
    }
}
