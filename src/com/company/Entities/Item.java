package com.company.Entities;

/**
 * Represents an item in a list from a letter to Santa Claus
 * It contains an integer unique identifier (self incremented) and a name
 */
public class Item {
    private static int count = 100;
    private int identifier;
    private String name;

    public Item(String name) {
        setIdentifier(++count);
        this.name = name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                '}';
    }
}
