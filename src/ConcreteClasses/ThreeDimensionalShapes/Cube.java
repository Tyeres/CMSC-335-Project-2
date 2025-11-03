// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    @Override
    public void menuPrint(Scanner scan) {
        System.out.println("\nYou have selected a Cube.\n");
        // Use for user validation. Loop until input is validated
        boolean continueLoop = true;
        double side = 0; // Temp side variable
        // Make sure the input is a number by repeating the question until valid input is received
        while(continueLoop) {
            System.out.println("\nWhat is a side length?\n");
            try {
                side = scan.nextDouble();
                // The input is validated. We can now exit the loop.
                continueLoop = false;
            } catch (InputMismatchException e) {
                // Clear the trash input
                scan.nextLine();
                System.out.println("\nSorry. I don't understand.\n");
            }
            setSide(side);
            System.out.println("\nThe area of the Cube is " + this.volume + "\n");
        }
    }
}
