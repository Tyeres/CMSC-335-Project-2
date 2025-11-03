// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

import AbstractClasses.Shape;
import ConcreteClasses.ThreeDimensionalShapes.*;
import ConcreteClasses.TwoDimensionalShapes.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continueProgram = true; // When this is false, the program ends
        System.out.println("*********Welcome to the Java OO Shapes Program **********");
        Scanner scan = new Scanner(System.in); // Used to take user input from the console
        int menuChoice; // The number which corresponds to the user choice
        // Menu (the main) loop
        while (continueProgram) {
            // Print the menu options
            printMenu();

            // Check if the input is a number
            try {
                menuChoice = scan.nextInt();
                // Check if input is within the 1-10 bounds
                if(menuChoice < 1 || menuChoice > 10) {
                    System.out.println("\nYour answer was out of bounds and must be a number 1-10.");
                    continue; // Repeat iteration because input validation failed
                }
                // We will only be able to continue from here in the code if the
                // choice has been validated.
            }
            // Input is not a number
            catch (InputMismatchException e) {
                // A non-character was given. Use scan.nextLine to rid the whitespace
                scan.nextLine();
                System.out.println("\nYour answer was not a number.");
                continue; // Repeat iteration because input validation failed
            }
            // This is the selected shape object
            Shape shape = null;
            switch (menuChoice) {
                case 1: // Construct a circle
                    shape = new Circle();
                    break;
                case 2: // Construct a rectangle
                    shape = new Rectangle();
                    break;
                case 3: // Construct a square
                    shape = new Square();
                    break;
                case 4: // Construct a triangle
                    shape = new Triangle();
                    break;
                case 5: // Construct a sphere
                    shape = new Sphere();
                    break;
                case 6: // Construct a cube
                    shape = new Cube();
                    break;
                case 7: // Construct a cone
                    shape = new Cone();
                    break;
                case 8: // Construct a cylinder
                    shape = new Cylinder();
                    break;
                case 9: // Construct a torus
                    shape = new Torus();
                    break;
                case 10:
                    // End the program
                    printDate();
                    continueProgram = false;
                    break;
            }
            // We don't want to try to construct a shape and print anything if trying to exit the program
            if (continueProgram) {
                // Go through the shape creation interface
                shape.menuPrint(scan);

                // Ask if user wants to continue
                System.out.println("Would you like to continue? (Y or N)\n");
                scan.nextLine(); // The last input was a number, and it left white space. Clean it up.
                // Validate input. Is false until the input is truly validated
                boolean inputValidated = false;
                while (!inputValidated) {
                    String input = scan.nextLine().toUpperCase(); // To supper case because I want it case-insensitive
                    if(input.equals("Y"))
                        // Do nothing. Just continue and validate the input.
                        inputValidated = true;
                    else if (input.equals("N")) {
                        // End the program
                        inputValidated = true;
                        continueProgram = false;
                        printDate();
                    }
                    // Input invalid. Let the user know and loop again
                    else System.out.println("\nSorry I do not understand. Enter Y or N\n");
                }
            }
        }
    }
    // Prints the date before ending the program
    public static void printDate() {
        LocalDateTime now = LocalDateTime.now(); // Get the current date and time
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM dd"); // Month and day format
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("hh:mm a"); // Time format

        String formatted1 = now.format(formatter1); // Formatted month and day
        String formatted2 = now.format(formatter2); // Formatted time

        System.out.println("\nThanks for using the program. Today is " + formatted1 + " at " +
                formatted2 + ".");
    }
    // Prints the menu options
    public static void printMenu()  {
        System.out.println("""
                
                Select from the menu below:\s
                1. Construct a Circle\s
                2. Construct a Rectangle\s
                3. Construct a Square\s
                4. Construct a Triangle\s
                5. Construct a Sphere\s
                6. Construct a Cube\s
                7. Construct a Cone\s
                8. Construct a Cylinder\s
                9. Construct a Torus\s
                10. Exit the program
                """);
    }
}
