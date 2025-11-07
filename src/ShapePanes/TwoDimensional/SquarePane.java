// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025
package ShapePanes.TwoDimensional;


import ConcreteClasses.TwoDimensionalShapes.Square;
import ShapePanes.Control;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SquarePane extends VBox implements Control {
    private final static int MAX_SIDE_DRAWING = 250;
    // The shape for calculation
    private final Square square = new Square();
    // Enter side here
    private final TextField sideTextInput = new TextField();
    // Alternative to the above text input. Select a side instead.
    private final ComboBox<Integer> sideComboBox = new ComboBox<>(getListOfIntegers());
    // Display square here
    private final javafx.scene.shape.Rectangle squareDrawing = new javafx.scene.shape.Rectangle();
    // The text for area output
    private final Label areaText = new Label();


    public SquarePane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Square text
        Label classText = new Label(square.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the square
        squareDrawing.setStroke(Color.BLACK);
        squareDrawing.setStrokeWidth(2);
        squareDrawing.setFill(Color.TRANSPARENT);
        // Style the text
        areaText.setStyle("-fx-font-size:14px;");
        // Default text for user input
        sideTextInput.setPromptText("Insert length here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(sideTextInput);
        optionsContainer.getChildren().add(sideComboBox);
        // The square shape and the area will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(areaText);
        BorderPane.setAlignment(areaText, Pos.CENTER);
        outputPane.setCenter(squareDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the text input
        sideTextInput.setOnKeyTyped(e->{
            try {
                // The input is the side
                double side = Double.parseDouble(sideTextInput.getText());
                // Use the side
                square.setSide(side);
                if(side < MAX_SIDE_DRAWING) {
                    squareDrawing.setHeight(side + BASE_SHAPE_SIZE);
                    squareDrawing.setWidth(side + BASE_SHAPE_SIZE);
                } else {
                    squareDrawing.setHeight(MAX_SIDE_DRAWING + BASE_SHAPE_SIZE);
                    squareDrawing.setWidth(MAX_SIDE_DRAWING + BASE_SHAPE_SIZE);
                }
                // Output area
                areaText.setText("Area: "+ square.getArea());

            } catch (NumberFormatException exception) {
                // We don't have to do anything. The user should see the problem immediately too; so,
                // we don't need an error message.
                // (The user did not insert a number in the text field)
            }
        });

        // Set on action for the combo box
        sideComboBox.setOnAction(e->{
            int side = sideComboBox.getValue(); // This is an int because the combo box only has int options
            // Set side
            square.setSide(side);
            squareDrawing.setHeight(side + BASE_SHAPE_SIZE);
            squareDrawing.setWidth(side + BASE_SHAPE_SIZE);
            // Output area
            areaText.setText("Area: " + square.getArea());
        });
    }
}
