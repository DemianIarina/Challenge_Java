package com.company.Entities;

import java.util.Date;
import java.util.List;

/**
 * Represents a letter written by a child, it contains the date it was written
 * and the list of items requested
 */
public class Letter {
    private Date date;
    private List<Item> itemList;

    public Letter(Date date, List<Item> itemList) {
        this.date = date;
        this.itemList = itemList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "date=" + date +
                ", itemList=" + itemList +
                '}';
    }
}
