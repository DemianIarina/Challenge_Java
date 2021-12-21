package com.company.Entities;

import java.util.Date;

/**
 * Represents a child in Santa Claus tracking system
 * He can be uniquely identified through his first and last name,
 * a date of birth, address
 * The child object also contains information about his behavoiur
 * (if he was good or bad)
 * He also has one letter
 */
public class Child {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;   //TODO clasa Adress maybe
    private BehaviorEnum behaviorEnum;
    private Letter letter;

    public Child(String firstName, String lastName, Date dateOfBirth, String address, BehaviorEnum behaviorEnum, Letter letter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.behaviorEnum = behaviorEnum;
        this.letter = letter;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", behaviorEnum=" + behaviorEnum +
                ", letter=" + letter +
                '}';
    }
}
