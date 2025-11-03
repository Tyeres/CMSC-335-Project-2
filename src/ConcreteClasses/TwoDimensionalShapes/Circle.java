// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle extends TwoDimensionalShape {
    // The radius
    private double radius;

    // Constructor
    public Circle() {
        radius = 0;
    }

    @Override
    protected void calculateArea() {
        // Formula: A = PI * R^2
        this.area = Math.PI * radius * radius;
    }

    // Setter method. Calculate new area in when radius changes.

    public void setRadius(double radius) {
        this.radius = radius;
        calculateArea();
    }

    @Override
    public void menuPrint(Scanner scan) {
        System.out.println("\nYou have selected a Circle.\n");
        boolean continueLoop = true; // Use to loop until user input is validated
        double radius = 0; // temp radius variable
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
        System.out.println("\nThe area of the Circle is " + this.area + "\n");
    }
}
