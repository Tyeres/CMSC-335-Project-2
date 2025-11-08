// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

public class Rectangle extends TwoDimensionalShape {

    // The properties needed for the area formula for a rectangle
    private double length;
    private double height;


    // Constructor
    public Rectangle() {
        this.length = 0;
        this.height = 0;
    }

    // This will be used when creating the object and by the setter methods.
    @Override
    protected void calculateArea() {
        // Formula for rectangle: A = L * H
        this.area = this.length * this.height;
    }

    // Setter methods. Calculate new area within setter methods

    public void setLength(double length) {
        this.length = length;
        calculateArea();
    }


    public void setHeight(double height) {
        this.height = height;
        calculateArea();
    }
}
