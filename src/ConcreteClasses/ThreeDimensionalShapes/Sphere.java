// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

public class Sphere extends ThreeDimensionalShape {

    private double radius;

    public Sphere() {
        radius = 0;
    }

    @Override
    protected void calculateVolume() {
        // Volume formula: V = 4/3 * R^3 * PI
        this.volume = radius * radius * radius * Math.PI * 4d/3;
    }

    // Set method. Calculate new volume when property changes
    public void setRadius(double radius) {
        this.radius = radius;
        calculateVolume();
    }
}
