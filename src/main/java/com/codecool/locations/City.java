package com.codecool.locations;

import com.codecool.TripPlanner;
import com.codecool.utilties.Position;

import java.util.List;

public class City extends Location {


    public City(Position position, String name) {
        super(position, name);
    }

    public List<Landmark> getNearbyLandmarks() {
        return TripPlanner.getInstance().getLandmarksWithin50km(this);
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println("City " + getName() + " position is " + getPosition() + ".");
    }
}
