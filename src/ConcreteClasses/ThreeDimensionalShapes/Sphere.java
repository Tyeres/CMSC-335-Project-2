// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sphere extends ThreeDimensionalShape {

    private double radius;

    public Sphere() {
        radius = 0;
    }

    @Override
    protected void calculateVolume() {
        // Volume formula: V = 4/3 * R^3 * PI
        this.volume = radius * radius * radius * Math.PI * 4d/3;
    }

    // Set method. Calculate new volume when property changes
    public void setRadius(double radius) {
        this.radius = radius;
        calculateVolume();
    }

    @Override
    public void menuPrint(Scanner scan) {
        System.out.println("\nYou have selected a Sphere.\n");
        // Use for user validation. Loop until input is validated
        boolean continueLoop = true;
        double radius = 0; // Temp radius variable
        // Make sure the input is a number by repeating the question until valid input is received
        while(continueLoop) {
            System.out.println("\nWhat is the radius?\n");
            try {
                radius = scan.nextDouble();
                // The input is validated. We can now exit the loop.
                continueLoop = false;
            } catch (InputMismatchException e) {
                // Clear the trash input
                scan.nextLine();
                System.out.println("\nSorry. I don't understand.\n");
            }
        }
        setRadius(radius);
        System.out.println("\nThe volume of the Sphere is " + this.volume + "\n");
    }
}
