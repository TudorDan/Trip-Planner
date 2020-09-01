package com.codecool.locations;

import com.codecool.utilties.LocationType;
import com.codecool.utilties.Position;

public class Landmark extends Location {
    private double entranceFee;

    public Landmark(Position position, String name) {
        super(position, name);
        setLocationType(LocationType.LANDMARK);
        this.entranceFee = 0;
    }

    public void setEntranceFee(double entranceFee) {
        if (entranceFee < 0) {
            System.out.println("Entrance Fee for " + getName() + " can not have a negative value!");
        } else {
            this.entranceFee = entranceFee;
        }
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("Landmark " + getName() + " position is " + getPosition() + ". Entrance fee is "
                + entranceFee + " $.");
    }
}
