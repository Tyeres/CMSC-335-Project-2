// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package AbstractClasses;

public abstract class ThreeDimensionalShape extends Shape {

    // This is protected because children should be able to modify this.
    // There is no setter method because a non-child class should not be able to set the volume
    // without calculating it.
    protected double volume;

    // Constructor
    public ThreeDimensionalShape() {
        super(3);
        volume = 0;
    }

    // The volume will be calculated based on the shape.
    // The volume formula depends on the shape.
    // This is protected because there is no reason for a non-child class to calculate the volume.
    // HOWEVER, The volume should be calculated in a child class's setter methods for its properties.
    protected abstract void calculateVolume();

}
