

package com.sales.src.model;

public class Line {
    private String item;
    private double price;
    private int count;
    private com.sales.src.model.Invoice invoice;

    public Line() {
    }

    public Line(String item, double price, int count, com.sales.src.model.Invoice invoice) {
        this.item = item;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public double getLinesTotal() {
        return this.price * (double)this.count;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Line{num=" + this.invoice.getNumber() + ", item=" + this.item + ", price=" + this.price + ", count=" + this.count + '}';
    }

    public com.sales.src.model.Invoice getInvoices() {
        return this.invoice;
    }

    public String getAsCSV() {
        return this.invoice.getNumber() + "," + this.item + "," + this.price + "," + this.count;
    }
}
