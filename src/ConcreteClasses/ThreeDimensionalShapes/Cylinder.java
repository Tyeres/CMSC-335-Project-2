// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

public class Cylinder extends ThreeDimensionalShape {

    private double radius; // Radius of base of sphere or inner sphere
    private double height; // The height of the cylinder from base-to-base

    // Constructor
    public Cylinder() {
        this.radius = 0;
        this.height = 0;
    }

    @Override
    protected void calculateVolume() {
        // Formula: V = PI * r^2 * h
        this.volume = Math.PI * radius * radius * height;
    }

    // Setter methods. Calculate new volume when a property changes
    public void setHeight(double height) {
        this.height = height;
        calculateVolume();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        calculateVolume();
    }
}
