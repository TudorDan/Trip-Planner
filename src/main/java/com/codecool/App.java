package com.codecool;

import com.codecool.locations.City;
import com.codecool.locations.Landmark;
import com.codecool.locations.UserLocation;
import com.codecool.utilties.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Simulation for Trip Planner Project started!" );

        System.out.println("Initiating trip planner!");
        TripPlanner tripPlanner = TripPlanner.getInstance();
        System.out.println("Globa trip planner initiated!");

        System.out.println("Adding locations!");
        tripPlanner.addLocation(new Landmark(new Position(47.1318, 24.5027), "CasaEma Bistrita"));
        tripPlanner.addLocation(new Landmark(new Position(47.1360, 24.4995), "HotelCoroanaDeAur Bistrita"));
        tripPlanner.addLocation(new Landmark(new Position(47.1353, 24.5002), "BisericaMinoritilor Bistrita"));
        tripPlanner.addLocation(new Landmark(new Position(47.1322, 24.4961), "CatedralaEv Bistrita"));
        tripPlanner.addLocation(new Landmark(new Position(47.1291, 24.4976), "TurnulDogarilor Bistrita"));
        tripPlanner.addLocation(new City(new Position(47.13, 24.49), "Bistrita"));
        tripPlanner.addLocation(new City(new Position(47.28, 24.40), "Nasaud"));
        tripPlanner.addLocation(new City(new Position(47.36, 24.67), "Sangeorz-Bai"));
        tripPlanner.addLocation(new City(new Position(47.17, 24.17), "Beclean"));
        tripPlanner.addLocation(new City(new Position(46.77, 24.70), "Reghin"));
        tripPlanner.addLocation(new City(new Position(47.34, 25.35), "Vatra-Dornei"));
        tripPlanner.addLocation(new UserLocation(new Position(47.1304, 24.4998), "UserLocation 1"));
        System.out.println("Locations added!");

        System.out.println("Set Fees for landmarks:");
        List<Landmark> landmarks = tripPlanner.getLandmarks();
        for (Landmark landmark : landmarks) {
            switch (landmark.getName()) {
                case "CasaEma Bistrita":
                    landmark.setEntranceFee(20);
                    break;
                case "HotelCoroanaDeAur Bistrita":
                    landmark.setEntranceFee(15);
                    break;
                case "TurnulDogarilor Bistrita":
                    landmark.setEntranceFee(-1);
                    break;
            }
        }
        for (Landmark landmark: landmarks) {
            landmark.showData();
        }

        System.out.println("Checking nearby landmarks for Bistrita:");
        List<City> cities = tripPlanner.getCities();
        for (City city : cities) {
            if (city.getName().equals("Bistrita")) {
                List<Landmark> landmarkList = city.getNearbyLandmarks();
                for (Landmark landmark : landmarkList) {
                    landmark.showData();
                }
            }
        }

        System.out.println("Checking closest city for Bistrita:");
        for (City city : cities) {
            if (city.getName().equals("Bistrita")) {
                City closest = city.getClosestCity();
                System.out.println("Closest to Bistrita is: " + closest.getName() + ".");
            }
        }

        System.out.println("Setting new user locations...");
        UserLocation userLocation = tripPlanner.getUserLocations().get(0);
        userLocation.setNewUserLocation(new Position(47.34, 25.35));
        userLocation.setNewUserLocation(new Position(46.77, 24.70));
        userLocation.showData();

        System.out.println( "Simulation finished!" );
    }
}
