// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

public class Torus extends ThreeDimensionalShape {

    private double bigRadius; // The radius of the major circle
    private double smallRadius; // The radius of the minor circle
    // See https://www.geeksforgeeks.org/maths/how-to-find-the-volume-of-a-torus/
    // Also see https://www.mathsisfun.com/geometry/torus.html

    // Constructor
    public Torus() {
        this.bigRadius = 0;
        this.smallRadius = 0;
    }

    @Override
    protected void calculateVolume() {
        // Formula: 2 * PI^2 * r^2 * R (r = inner radius and R = big radius)
        this.volume = 2d * Math.PI * Math.PI * smallRadius * smallRadius * bigRadius;
    }
    // Check if the fields are valid. The small radius cannot be larger than the big radius
    public boolean areRadiiValid() {
        return smallRadius < bigRadius;
    }


    // Setter methods. Calculate new volume within the setter methods when a property changes

    public void setBigRadius(double bigRadius) {
        this.bigRadius = bigRadius;
        calculateVolume();
    }

    public void setSmallRadius(double smallRadius) {
        this.smallRadius = smallRadius;
        calculateVolume();
    }
}
