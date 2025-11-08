// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

public class Triangle extends TwoDimensionalShape {

    private double height; // Height from the base to the highest part of the triangle
    private double base; // Base length

    // Constructor
    public Triangle() {
        this.height = 0;
        this.base = 0;
    }

    @Override
    protected void calculateArea() {
        // There are many formulas for a triangle. However, we will use the simple
        // A = B * H / 2
        this.area = this.base * this.height / 2;
    }

    // Getter and setter methods. Calculate new area within the setter methods

    public void setBase(double base) {
        this.base = base;
        calculateArea();
    }
    public void setHeight(double height) {
        this.height = height;
        calculateArea();
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }
}
