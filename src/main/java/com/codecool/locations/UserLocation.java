package com.codecool.locations;

import com.codecool.utilties.Position;

import java.util.ArrayList;
import java.util.List;

public class UserLocation extends Location {
    private final List<Position> userLocationsList = new ArrayList<>();

    public UserLocation(Position position, String name) {
        super(position, name);
        userLocationsList.add(new Position(getPosition().x, getPosition().y));
    }

    public void setNewUserLocation(Position newPosition) {
        getPosition().x = newPosition.x;
        getPosition().y = newPosition.y;
        userLocationsList.add(new Position(getPosition().x, getPosition().y));
    }

    public List<Position> getUserLocationsList() {
        return userLocationsList;
    }

    @Override
    public void showData() {
        super.showData();
        System.out.println(getName() + " is " + getPosition() + ". All user positions are: "
                + userLocationsList.toString());
    }
}
