// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ConcreteClasses.TwoDimensionalShapes;

import AbstractClasses.TwoDimensionalShape;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle extends TwoDimensionalShape {

    private double height; // Height from the base to the highest part of the triangle
    private double base; // Base length

    // Constructor
    public Triangle() {
        this.height = 0;
        this.base = 0;
    }

    @Override
    protected void calculateArea() {
        // There are many formulas for a triangle. However, we will use the simple
        // A = B * H / 2
        this.area = this.base * this.height / 2;
    }

    // Setter method. Calculate new area within the setter method

    public void setBase(double base) {
        this.base = base;
        calculateArea();
    }

    @Override
    public void menuPrint(Scanner scan) {

        // Initialize so we don't have issues. Temp height and base variables
        double height = 0;
        double base = 0;
        System.out.println("\nYou have selected a Triangle.\n");
        // Use for user validation. Loop until input is validated
        boolean continueFirstLoop = true;
        // Get base.
        // Make sure the input is a number by repeating the question until valid input is received.
        while(continueFirstLoop) {
            System.out.println("What is the base?\n");
            try {
                base = scan.nextDouble();
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
        // We set the base and height this way so that the area isn't calculated twice.
        // (The area is calculated by every call to a set method.)
        this.height = height;
        setBase(base);
        System.out.println("\nThe area of the Triangle is " + this.area + "\n");
    }
}
