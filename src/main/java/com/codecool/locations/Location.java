package com.codecool.locations;

import com.codecool.TripPlanner;
import com.codecool.utilties.LocationType;
import com.codecool.utilties.Position;
import com.codecool.utilties.Utilities;

import java.util.List;

public abstract class Location {
    private final Position position;
    private final String name;
    private LocationType locationType;

    public Location(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public City getClosestCity() {
        List<City> cities = TripPlanner.getInstance().getCities();
        for (double i = 0.01; i < 10; i += 0.1) { // 1 degree of latitude = 111 km
            for (City city : cities) {
                if (Utilities.isInsideRadius(position, city.getPosition(), i) && !city.getName().equals(getName())) {
                    return city;
                }
            }
        }
        return null;
    }

    public void showData() {}
}
