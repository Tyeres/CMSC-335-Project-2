// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle extends TwoDimensionalShape {

    // The properties needed for the area formula for a rectangle
    private double length;
    private double height;


    // Constructor
    public Rectangle() {
        this.length = 0;
        this.height = 0;
    }

    // This will be used when creating the object and by the setter methods.
    @Override
    protected void calculateArea() {
        // Formula for rectangle: A = L * H
        this.area = this.length * this.height;
    }

    // Setter methods. Calculate new area within setter methods

    public void setLength(double length) {
        this.length = length;
        calculateArea();
    }


    public void setHeight(double height) {
        this.height = height;
        calculateArea();
    }

    @Override
    public void menuPrint(Scanner scan) {
        // Initialize so we don't have issues. Width and length temp variables
        double length = 0;
        double height = 0;
        System.out.println("\nYou have selected a Rectangle.\n");
        // Use for user validation. Loop until input is validated
        boolean continueFirstLoop = true;
        // Get length.
        // Make sure the input is a number by repeating the question until valid input is received.
        while(continueFirstLoop) {
            System.out.println("\nWhat is the length?\n");
            try {
                length = scan.nextDouble();
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
        // We set the length and height this way so that the area isn't calculated twice.
        // (The area is calculated by every call to a set method.)
        this.length = length;
        setHeight(height);
        System.out.println("\nThe area of the Rectangle is " + this.area + "\n");
    }
}
