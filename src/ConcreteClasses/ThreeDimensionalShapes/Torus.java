// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.ThreeDimensionalShapes;

import AbstractClasses.ThreeDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Torus extends ThreeDimensionalShape {

    private double bigRadius; // The radius of the major circle
    private double smallRadius; // The radius of the minor circle
    // See https://www.geeksforgeeks.org/maths/how-to-find-the-volume-of-a-torus/

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

    // Setter method. Calculate new volume within the setter method when property changes

    public void setBigRadius(double bigRadius) {
        this.bigRadius = bigRadius;
        calculateVolume();
    }


    @Override
    public void menuPrint(Scanner scan) {
        // Initialize so we don't have issues. Temp radius variables
        double smallRadius = 0;
        double bigRadius = 0;
        System.out.println("\nYou have selected a Torus.\n");
        // Use for user validation. Loop until input is validated
        boolean continueFirstLoop = true;
        // Get smallRadius.
        // Make sure the input is a number by repeating the question until valid input is received.
        while(continueFirstLoop) {
            System.out.println("\nWhat is the radius of the smaller circle?\n");
            try {
                smallRadius = scan.nextDouble();
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
        // Get bigRadius.
        // Make sure the input is a number by repeating the question until valid input is received.
        while(continueSecondLoop) {
            System.out.println("\nWhat is the radius of the larger circle?\n");
            try {
                bigRadius = scan.nextDouble();
                // The radius must be larger than the smaller radius. Otherwise, output an error.
                if (bigRadius <= smallRadius) {
                    // Big radius is too small
                    System.out.println("\nPlease insert a larger radius. Yours is too small. The radius of the larger circle must be a larger radius than the smaller circle's radius.");
                } else
                    // The input has been validated. We can exit the loop.
                    continueSecondLoop = false;
            } catch (InputMismatchException e) {
                // Clear the trash input
                scan.nextLine();
                System.out.println("\nSorry. I don't understand.\n");
            }
        }
        // We set the smallRadius and bigRadius this way so that the volume isn't calculated twice.
        // (The volume is calculated by every call to a set method.)
        this.smallRadius = smallRadius;
        setBigRadius(bigRadius);
        System.out.println("\nThe volume of the Torus is " + this.volume + "\n");
    }
}
