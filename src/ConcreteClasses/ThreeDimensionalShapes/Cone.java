// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cone extends ThreeDimensionalShape {

    private double radius; // Radius of the base of the cone
    private double height; // Height of the cone

    // Constructor
    public Cone() {
        this.radius = 0;
        this.height = 0;
    }

    @Override
    protected void calculateVolume() {
        // Formula: V = 1/3 * PI * r^2 * h
        this.volume = 1d/3 * Math.PI * radius * radius * height;
    }

    // Setter methods. Calculate volume when changes are made

    public void setHeight(double height) {
        this.height = height;
        calculateVolume();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        calculateVolume();
    }

    @Override
    public void menuPrint(Scanner scan) {
        // Initialize so we don't have issues. Temp height and radius variables
        double height = 0;
        double radius = 0;
        System.out.println("\nYou have selected a Cone.\n");
        // Use for user validation. Loop until input is validated
        boolean continueFirstLoop = true;
        // Get radius.
        // Make sure the input is a number by repeating the question until valid input is received.
        while(continueFirstLoop) {
            System.out.println("\nWhat is the radius?\n");
            try {
                radius = scan.nextDouble();
                // The input has been validated. We can exit the loop.
                continueFirstLoop = false;
            } catch (InputMismatchException e) {
                // Clear the trash input
                scan.nextLine();
                System.out.println("\nSorry. I don't understand.\n");
            }
        }
        // Use for user validation. Loop until input is validated
        boolean continueSecondLoop = true;
        // Get height.
        // Make sure the input is a number by repeating the question until valid input is received.
        while(continueSecondLoop) {
            System.out.println("\nWhat is the height?\n");
            try {
                height = scan.nextDouble();
                // The input has been validated. We can exit the loop.
                continueSecondLoop = false;
            } catch (InputMismatchException e) {
                // Clear the trash input
                scan.nextLine();
                System.out.println("\nSorry. I don't understand.\n");
            }
        }
        // We set the height and radius this way so that the volume isn't calculated twice.
        // (The volume is calculated by every call to a set method.)
        this.radius = radius;
        setHeight(height);
        System.out.println("\nThe volume of the Cone is " + this.volume + "\n");
    }
}
