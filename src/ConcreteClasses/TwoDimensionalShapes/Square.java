// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A Square is a rectangle. This is why we extend the Rectangle class.
 */
public class Square extends TwoDimensionalShape {
    // A square has equal sides
    private double side;
    // Constructor
    public Square() {
        side = 0;
    }

    @Override
    protected void calculateArea() {
        // Area formula for a square: A = S^2
        area = side * side;
    }

    public void setSide(double side) {
        // (The area is calculated for each call to a set method.)
        this.side = side;
        calculateArea();
    }

    @Override
    public void menuPrint(Scanner scan) {
        System.out.println("\nYou have selected a Square.\n");
        // Use for user validation. Loop until user input is validated
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
            // We set the length and width this way so that the area is not calculated twice.
            // (The area is calculated by each call to a set method.)
            setSide(side);
            System.out.println("\nThe area of the Square is " + this.area + "\n");
        }
    }
}
