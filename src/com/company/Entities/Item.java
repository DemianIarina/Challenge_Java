package com.company.Entities;

/**
 * Represents an item in a list from a letter to Santa Claus
 * It contains a integer unique identifier and a name
 */
public class Item {
    private int identifier;
    private String name;

    public Item(int identifier, String name) {
        this.identifier = identifier;
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
