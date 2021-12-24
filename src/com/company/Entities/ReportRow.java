package com.company.Entities;

/**
 * Represents one row of the report, containing the name of the item to be produced and the quantity
 * When a row is first created, it will have the quantity set to 1
 */
public class ReportRow {
    private String toyName;
    private int quantity;

    public ReportRow(String toyName) {
        this.toyName = toyName;
        this.quantity = 1;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{toyName='" + toyName + '\'' +
                " - quantity=" + quantity +
                '}';
    }

}
