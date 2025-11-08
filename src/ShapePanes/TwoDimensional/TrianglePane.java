// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025
package ShapePanes.TwoDimensional;

import ConcreteClasses.TwoDimensionalShapes.Triangle;
import ShapePanes.Control;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TrianglePane extends VBox implements Control {
    // This represents a max size for the side lengths of the triangle drawing so that it doesn't blow up the window
    private final static double MAX_LENGTH_DRAWING = 250.0;
    // The shape for calculation
    private final Triangle triangle = new Triangle();
    // Enter base here
    private final TextField baseTextInput = new TextField();
    // Alternative to the above text input. Select a base instead.
    private final ComboBox<Integer> baseComboBox = new ComboBox<>(Control.getListOfIntegers());
    // Enter height here
    private final TextField heightTextInput = new TextField();
    // Alternative to the above text input. Select a height instead.
    private final ComboBox<Integer> heightComboBox = new ComboBox<>(Control.getListOfIntegers());
    // Display triangle here
    private final javafx.scene.shape.Polygon triangleDrawing = new javafx.scene.shape.Polygon();
    // The text for area output
    private final Label areaText = new Label();


    public TrianglePane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Rectangle text
        Label classText = new Label(triangle.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the triangle
        triangleDrawing.setStroke(Color.BLACK);
        triangleDrawing.setStrokeWidth(2);
        triangleDrawing.setFill(Color.TRANSPARENT);
        // Style the text
        areaText.setStyle("-fx-font-size:14px;");
        // Default text for user inputs
        baseTextInput.setPromptText("Insert length here");
        heightTextInput.setPromptText("Insert height here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(baseTextInput);
        optionsContainer.getChildren().add(baseComboBox);
        optionsContainer.getChildren().add(heightTextInput);
        optionsContainer.getChildren().add(heightComboBox);
        // The triangle shape and the area will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(areaText);
        BorderPane.setAlignment(areaText, Pos.CENTER);
        outputPane.setCenter(triangleDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the length text input
        baseTextInput.setOnKeyTyped(e-> setTriangleBaseTextField());

        // Set on action for the length combo box
        baseComboBox.setOnAction(e-> setTriangleBaseComboBox());

        // Set the action for the height text input
        heightTextInput.setOnKeyTyped(e-> setTriangleHeightTextField());

        // Set on action for the height combo box
        heightComboBox.setOnAction(e-> setTriangleHeightComboBox());
    }
    private void setTriangleBaseTextField() {
        try {
            // The input is the base
            double base = Double.parseDouble(baseTextInput.getText());
            // Use the base
            triangle.setBase(base);
            setTriangleDrawing(base, triangle.getHeight());

            // Output area
            areaText.setText("Area: "+ triangle.getArea());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setTriangleHeightTextField() {
        try {
            // The input is the height
            double height = Double.parseDouble(heightTextInput.getText());
            // Use the height
            triangle.setHeight(height);
            setTriangleDrawing(triangle.getBase(), height);

            // Output area
            areaText.setText("Area: "+ triangle.getArea());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setTriangleBaseComboBox() {
        int base = baseComboBox.getValue(); // This is an int because the combo box only has int options
        // Set base
        triangle.setBase(base);
        setTriangleDrawing(base, triangle.getHeight());

        // Output area
        areaText.setText("Area: " + triangle.getArea());
    }
    private void setTriangleHeightComboBox() {
        int height = heightComboBox.getValue(); // This is an int because the combo box only has int options
        // Set height
        triangle.setHeight(height);
        // We only want to draw if the second field (the base) has also been given.
        setTriangleDrawing(triangle.getBase(), height);

        // Output area
        areaText.setText("Area: " + triangle.getArea());
    }
    // Used to draw the triangle's points, since there is no simple Triangle JavaFX class
    private void setTriangleDrawing(double base, double height) {
        // These drawing stipulations are put on the dimensions so that they do not blow up the window
        if (base >= MAX_LENGTH_DRAWING)
            base = MAX_LENGTH_DRAWING;
        if (height >= MAX_LENGTH_DRAWING)
            height = MAX_LENGTH_DRAWING;
        // Reset the drawing
        triangleDrawing.getPoints().clear();
        // Draw the triangle as a right triangle with the corresponding values
        triangleDrawing.getPoints().addAll(
                // 100.0 and 50.0 make the default orientation for the right triangle.
                100.0, 50.0,   // Point 1: (x1, y1) top
                100.0, 50.0 + BASE_SHAPE_SIZE + height,   // Point 2: (x2, y2) bottom left
                100.0 + BASE_SHAPE_SIZE + base, 50.0 + BASE_SHAPE_SIZE + height   // Point 3: (x3, y3) bottom right
        );
    }
}
