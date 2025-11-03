// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package AbstractClasses;

public abstract class TwoDimensionalShape extends Shape {

    // Area is protected because only children should be able to modify this.
    // There is no setter method because a non-child class should not be able to set the area
    // without calculating it.
    protected double area;

    // Constructor
    public TwoDimensionalShape() {
        super(2);
        area = 0;
    }

    // The area will be calculated based on the shape.
    // The area formula depends on the shape.
    // This is protected because there is no reason for a non-child class to calculate the area.
    // HOWEVER, The area should be calculated in a child class's setter methods for its properties.
    protected abstract void calculateArea();

}
