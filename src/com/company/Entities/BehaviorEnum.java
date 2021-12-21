package com.company.Entities;

enum BehaviorEnum {
    GOOD(0),
    BAD(1);

    private int behaviorValue;

    BehaviorEnum (int behaviorValue){
        this.behaviorValue = behaviorValue;
    }

    public int getBehaviorValue() {
        return behaviorValue;
    }
}
