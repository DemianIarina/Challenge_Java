package com.company.Entities;

import java.util.Date;

/**
 * Represents a child in Santa Claus tracking system
 * He can be uniquely identified through name, date of birth and address
 * The child object also contains information about his behaviour
 * (if he was good or bad)
 * He also has one letter
 */
public class Child {
    private String name;
    private Date dateOfBirth;
    private String address;
    private BehaviorEnum behaviorEnum;
    private Letter letter;

    public Child(String firstName, Date dateOfBirth, String address, BehaviorEnum behaviorEnum, Letter letter) {
        this.name = firstName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.behaviorEnum = behaviorEnum;
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BehaviorEnum getBehaviorEnum() {
        return behaviorEnum;
    }

    public void setBehaviorEnum(BehaviorEnum behaviorEnum) {
        this.behaviorEnum = behaviorEnum;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "Child{" +
                "firstName='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", behaviorEnum=" + behaviorEnum +
                ", letter=" + letter +
                '}';
    }
}
