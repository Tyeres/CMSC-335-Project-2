package ShapePanes;

import ConcreteClasses.TwoDimensionalShapes.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RectanglePane extends VBox implements Control{

    // The shape for calculation
    private final Rectangle rectangle = new Rectangle();
    // Enter length here
    private final TextField lengthTextInput = new TextField();
    // Alternative to the above text input. Select a length instead.
    private final ComboBox<Integer> lengthComboBox = new ComboBox<>(getListOfIntegers());
    // Enter height here
    private final TextField heightTextInput = new TextField();
    // Alternative to the above text input. Select a height instead.
    private final ComboBox<Integer> heightComboBox = new ComboBox<>(getListOfIntegers());
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
        lengthTextInput.setOnKeyTyped(e->setRectangleLengthTextField());

        // Set on action for the length combo box
        lengthComboBox.setOnAction(e-> setRectangleLengthComboBox());

        // Set the action for the height text input
        heightTextInput.setOnKeyTyped(e->setRectangleHeightTextField());

        // Set on action for the height combo box
        heightComboBox.setOnAction(e-> setRectangleHeightComboBox());
    }
    private void setRectangleLengthTextField() {
        try {
            // The input is the length
            double length = Double.parseDouble(lengthTextInput.getText());
            // Use the length
            rectangle.setLength(length);
            rectangleDrawing.setWidth(length + BASE_SHAPE_SIZE);
            // Output area
            areaText.setText("Area: "+ rectangle.getArea());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setRectangleHeightTextField() {
        try {
            // The input is the height
            double height = Double.parseDouble(heightTextInput.getText());
            // Use the height
            rectangle.setHeight(height);
            rectangleDrawing.setHeight(height + BASE_SHAPE_SIZE);
            // Output area
            areaText.setText("Area: "+ rectangle.getArea());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setRectangleLengthComboBox() {
        int length = lengthComboBox.getValue(); // This is an int because the combo box only has int options
        // Set length
        rectangle.setLength(length);
        rectangleDrawing.setWidth(length + BASE_SHAPE_SIZE);
        // Output area
        areaText.setText("Area: " + rectangle.getArea());
    }
    private void setRectangleHeightComboBox() {
        int height = heightComboBox.getValue(); // This is an int because the combo box only has int options
        // Set height
        rectangle.setHeight(height);
        rectangleDrawing.setHeight(height + BASE_SHAPE_SIZE);
        // Output area
        areaText.setText("Area: " + rectangle.getArea());
    }
}
