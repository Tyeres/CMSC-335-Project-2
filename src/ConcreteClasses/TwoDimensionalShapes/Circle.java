// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

public class Circle extends TwoDimensionalShape {
    // The radius
    private double radius;

    // Constructor
    public Circle() {
        radius = 0;
    }

    @Override
    protected void calculateArea() {
        // Formula: A = PI * R^2
        this.area = Math.PI * radius * radius;
    }

    // Setter method. Calculate new area in when radius changes.

    public void setRadius(double radius) {
        this.radius = radius;
        calculateArea();
    }

}
