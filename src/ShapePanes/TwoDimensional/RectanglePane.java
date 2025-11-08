// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025
package ShapePanes.TwoDimensional;

import ConcreteClasses.TwoDimensionalShapes.Rectangle;
import ShapePanes.Control;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RectanglePane extends VBox implements Control {
    // This is used to that the rectangle cannot blow up the window
    private final static int MAX_LENGTH_DRAWING = 200;
    // The shape for calculation
    private final Rectangle rectangle = new Rectangle();
    // Enter length here
    private final TextField lengthTextInput = new TextField();
    // Alternative to the above text input. Select a length instead.
    private final ComboBox<Integer> lengthComboBox = new ComboBox<>(Control.getListOfIntegers());
    // Enter height here
    private final TextField heightTextInput = new TextField();
    // Alternative to the above text input. Select a height instead.
    private final ComboBox<Integer> heightComboBox = new ComboBox<>(Control.getListOfIntegers());
    // Display rectangle here
    private final javafx.scene.shape.Rectangle rectangleDrawing = new javafx.scene.shape.Rectangle();
    // The text for area output
    private final Label areaText = new Label();


    public RectanglePane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Rectangle text
        Label classText = new Label(rectangle.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the rectangle
        rectangleDrawing.setStroke(Color.BLACK);
        rectangleDrawing.setStrokeWidth(2);
        rectangleDrawing.setFill(Color.TRANSPARENT);
        // Style the text
        areaText.setStyle("-fx-font-size:14px;");
        // Default text for user inputs
        lengthTextInput.setPromptText("Insert length here");
        heightTextInput.setPromptText("Insert height here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(lengthTextInput);
        optionsContainer.getChildren().add(lengthComboBox);
        optionsContainer.getChildren().add(heightTextInput);
        optionsContainer.getChildren().add(heightComboBox);
        // The rectangle shape and the area will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(areaText);
        BorderPane.setAlignment(areaText, Pos.CENTER);
        outputPane.setCenter(rectangleDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the length text input
        lengthTextInput.setOnKeyTyped(e-> setLengthTextField());

        // Set on action for the length combo box
        lengthComboBox.setOnAction(e-> setLengthComboBox());

        // Set the action for the height text input
        heightTextInput.setOnKeyTyped(e-> setHeightTextField());

        // Set on action for the height combo box
        heightComboBox.setOnAction(e-> setHeightComboBox());
    }
    private void setLengthTextField() {
        try {
            // The input is the length
            double length = Double.parseDouble(lengthTextInput.getText());
            // Use the length
            rectangle.setLength(length);
            // This is done so that you cannot blow up the rectangle to too large of a size
            if (length < MAX_LENGTH_DRAWING)
                rectangleDrawing.setWidth(length + BASE_SHAPE_SIZE);
            else rectangleDrawing.setWidth(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
            // Output area
            areaText.setText("Area: "+ rectangle.getArea());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setHeightTextField() {
        try {
            // The input is the height
            double height = Double.parseDouble(heightTextInput.getText());
            // Use the height
            rectangle.setHeight(height);
            // This is done so that you cannot blow up the rectangle to too large of a size
            if(height < MAX_LENGTH_DRAWING)
                rectangleDrawing.setHeight(height + BASE_SHAPE_SIZE);
            else rectangleDrawing.setHeight(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
            // Output area
            areaText.setText("Area: "+ rectangle.getArea());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setLengthComboBox() {
        int length = lengthComboBox.getValue(); // This is an int because the combo box only has int options
        // Set length
        rectangle.setLength(length);
        // This is done so that you cannot blow up the rectangle to too large of a size
        if (length < MAX_LENGTH_DRAWING)
            rectangleDrawing.setWidth(length + BASE_SHAPE_SIZE);
        else rectangleDrawing.setWidth(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
        // Output area
        areaText.setText("Area: " + rectangle.getArea());
    }
    private void setHeightComboBox() {
        int height = heightComboBox.getValue(); // This is an int because the combo box only has int options
        // Set height
        rectangle.setHeight(height);
        // This is done so that you cannot blow up the rectangle to too large of a size
        if(height < MAX_LENGTH_DRAWING)
            rectangleDrawing.setHeight(height + BASE_SHAPE_SIZE);
        else rectangleDrawing.setHeight(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
        // Output area
        areaText.setText("Area: " + rectangle.getArea());
    }
}
