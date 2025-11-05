// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025
package ShapePanes;

import ConcreteClasses.TwoDimensionalShapes.Circle;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CirclePane extends VBox implements Control{
    // The shape for calculation
    private final Circle circle = new Circle();
    // Enter radius here
    private final TextField radiusTextInput = new TextField();
    // Alternative to the above text input. Select a radius instead.
    private final ComboBox<Integer> radiusComboBox = new ComboBox<>(getListOfIntegers());
    // Display circle here
    private final javafx.scene.shape.Circle circleDrawing = new javafx.scene.shape.Circle();
    // The text for area output
    private final Label areaText = new Label();


    public CirclePane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Circle text
        Label classText = new Label(circle.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the circle
        circleDrawing.setStroke(Color.BLACK);
        circleDrawing.setStrokeWidth(2);
        circleDrawing.setFill(Color.TRANSPARENT);
        // Style the text
        areaText.setStyle("-fx-font-size:14px;");
        // Default text for user input
        radiusTextInput.setPromptText("Insert radius here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(radiusTextInput);
        optionsContainer.getChildren().add(radiusComboBox);
        // The circle shape and the area will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(areaText);
        BorderPane.setAlignment(areaText, Pos.CENTER);
        outputPane.setCenter(circleDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the text input
        radiusTextInput.setOnKeyTyped(e->{
            try {
                // The input is the radius
                double radius = Double.parseDouble(radiusTextInput.getText());
                // Use the radii
                circle.setRadius(radius);
                circleDrawing.setRadius(radius + BASE_SHAPE_SIZE);
                // Output area
                areaText.setText("Area: "+ circle.getArea());

            } catch (NumberFormatException exception) {
                // We don't have to do anything. The user should see the problem immediately too; so,
                // we don't need an error message.
                // (The user did not insert a number in the text field)
            }
        });

        // Set on action for the combo box
        radiusComboBox.setOnAction(e->{
            int radius = radiusComboBox.getValue(); // This is an int because the combo box only has int options
            // Set radii
            circle.setRadius(radius);
            circleDrawing.setRadius(radius);
            // Output area
            areaText.setText("Area: " + circle.getArea());
        });
    }
}
