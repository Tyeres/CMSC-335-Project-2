// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

public class Square extends TwoDimensionalShape {
    // A square has equal sides
    private double side;
    // Constructor
    public Square() {
        side = 0;
    }

    @Override
    protected void calculateArea() {
        // Area formula for a square: A = S^2
        area = side * side;
    }

    public void setSide(double side) {
        // (The area is calculated for each call to a set method.)
        this.side = side;
        calculateArea();
    }
}
