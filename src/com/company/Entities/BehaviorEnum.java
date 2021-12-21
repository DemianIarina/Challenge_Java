package com.company.Entities;

/**
 * Represents the behaviour of a child throughout the year
 */
public enum BehaviorEnum {
    GOOD(0),
    BAD(1);

    private final int behaviorValue;

    BehaviorEnum (int behaviorValue){
        this.behaviorValue = behaviorValue;
    }

    public int getBehaviorValue() {
        return behaviorValue;
    }
}
