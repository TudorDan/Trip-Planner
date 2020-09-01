package com.codecool;

import com.codecool.locations.City;
import com.codecool.locations.Landmark;
import com.codecool.locations.Location;
import com.codecool.locations.UserLocation;
import com.codecool.utilties.Position;
import com.codecool.utilties.Utilities;

import java.util.ArrayList;
import java.util.List;

public class TripPlanner {
    private static TripPlanner instance = null;
    private final List<Landmark> landmarks = new ArrayList<>();
    private final List<City> cities = new ArrayList<>();
    private final List<UserLocation> userLocations = new ArrayList<>();

    public static TripPlanner getInstance() {
        if (instance == null) {
            instance = new TripPlanner();
        }
        return instance;
    }

    public void addLocation(Location location) {
        if (location.getClass().equals(Landmark.class)) {
            landmarks.add((Landmark) location);
        } else if (location.getClass().equals(City.class)) {
            cities.add((City) location);
        } else if (location.getClass().equals(UserLocation.class)) {
            userLocations.add((UserLocation) location);
        }
    }

    public List<Landmark> getLandmarksWithin50km(City city) {
        List<Landmark> result = new ArrayList<>();
        Position center = city.getPosition();
        for (Landmark landmark : landmarks) {
            Position other = landmark.getPosition();
            if (Utilities.isInsideRadius(center, other, 0.5)) {  // 1 degree of latitude = 111 km
                result.add(landmark);
            }
        }
        return result;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Landmark> getLandmarks() {
        return landmarks;
    }

    public List<UserLocation> getUserLocations() {
        return userLocations;
    }
}
