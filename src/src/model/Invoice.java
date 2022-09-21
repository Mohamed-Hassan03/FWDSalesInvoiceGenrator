

package com.sales.src.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Invoice {
    private int number;
    private String date;
    private String customerName;
    private ArrayList<Line> lines;

    public Invoice() {
    }

    public Invoice(int num, String date, String customer) {
        this.number = num;
        this.date = date;
        this.customerName = customer;
    }

    public double getInvoiceTotal() {
        double total = 0.0D;

        Line line;
        for(Iterator var3 = this.getLines().iterator(); var3.hasNext(); total += line.getLinesTotal()) {
            line = (Line)var3.next();
        }

        return total;
    }

    public ArrayList<Line> getLines() {
        if (this.lines == null) {
            this.lines = new ArrayList();
        }

        return this.lines;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "Invoice{num=" + this.number + ", date=" + this.date + ", customer=" + this.customerName + '}';
    }

    public String getAsCSV() {
        return this.number + "," + this.date + "," + this.customerName;
    }
}
