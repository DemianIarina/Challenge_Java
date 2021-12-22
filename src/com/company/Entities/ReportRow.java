package com.company.Entities;

import java.util.Collections;
import java.util.Comparator;

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
        return "ReportRow{" +
                "toyName='" + toyName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
