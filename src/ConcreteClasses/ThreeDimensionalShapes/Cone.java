// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

public class Cone extends ThreeDimensionalShape {

    private double radius; // Radius of the base of the cone
    private double height; // Height of the cone

    // Constructor
    public Cone() {
        this.radius = 0;
        this.height = 0;
    }

    @Override
    protected void calculateVolume() {
        // Formula: V = 1/3 * PI * r^2 * h
        this.volume = 1d/3 * Math.PI * radius * radius * height;
    }

    // Setter methods. Calculate volume when changes are made

    public void setHeight(double height) {
        this.height = height;
        calculateVolume();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        calculateVolume();
    }

}
