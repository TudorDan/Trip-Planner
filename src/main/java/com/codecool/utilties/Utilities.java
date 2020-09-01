package com.codecool.utilties;

public class Utilities {
    /**
     *
     * @param center central position
     * @param other position to check if it's inside radius
     * @param radius km
     * @return boolean
     */
    public static boolean isInsideRadius(Position center, Position other, double radius) {
        return (center.x - other.x) * (center.x - other.x) + (center.y - other.y) * (center.y - other.y)
                <= radius * radius;
    }
}
