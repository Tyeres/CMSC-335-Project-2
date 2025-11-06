// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package AbstractClasses;

import java.util.Scanner;

public abstract class Shape {
    private final int numberOfDimensions;

    // Constructor
    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    // This method is not used, but if I remove it, I get more warnings about how numberOfDimensions is never used.
    // I can't remove the property because the property was in the project requirements. So, please forgive this warning
    public int getNumberOfDimensions() {
        return this.numberOfDimensions;
    }

    /**
     * This will be used to print data when a shape is selected in the menu.
     * It will receive data from the scanner so that it can determine area/volume.
     */
    public abstract void menuPrint(Scanner scan);
}
