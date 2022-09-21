package com.sales.src.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LinesTableModel extends AbstractTableModel {
    private ArrayList<Line> lines;
    private String[] columns = new String[]{"No.", "Item Name", "Item Price", "Count", "Item Total"};

    public LinesTableModel(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public int getRowCount() {
        return this.lines.size();
    }

    public int getColumnCount() {
        return this.columns.length;
    }

    public String getColumnName(int x) {
        return this.columns[x];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Line line = (Line)this.lines.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return line.getInvoices().getNumber();
            case 1:
                return line.getItem();
            case 2:
                return line.getPrice();
            case 3:
                return line.getCount();
            case 4:
                return line.getLinesTotal();
            default:
                return "";
        }
    }
}
