// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

// It would be a good idea to use a rectangular parallelepiped class and just extend that, but
// it will be easier to skip using a class name that long, and that class isn't in the project requirements.
public class Cube extends ThreeDimensionalShape {

    private double side;

    // Constructor
    public Cube() {
        side = 0;
    }

    @Override
    protected void calculateVolume() {
        // Formula: V = side^3
        this.volume = side * side * side;
    }

    // Setter method. Calculate new volume when side changes
    public void setSide(double side) {
        this.side = side;
        calculateVolume();
    }
}
