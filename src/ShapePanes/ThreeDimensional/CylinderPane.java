package ShapePanes.ThreeDimensional;

import ConcreteClasses.ThreeDimensionalShapes.Cylinder;
import ShapePanes.Control;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class CylinderPane extends VBox implements Control {

    // This is used to that the cylinder cannot blow up the window
    private final static int MAX_LENGTH_DRAWING = 250;
    // The shape for calculation
    private final Cylinder cylinder = new Cylinder();
    // Enter radius here
    private final TextField radiusTextInput = new TextField();
    // Alternative to the above text input. Select a radius instead.
    private final ComboBox<Integer> radiusComboBox = new ComboBox<>(getListOfIntegers());
    // Enter height here
    private final TextField heightTextInput = new TextField();
    // Alternative to the above text input. Select a height instead.
    private final ComboBox<Integer> heightComboBox = new ComboBox<>(getListOfIntegers());
    // Display cylinder here
    private final ImageView cylinderDrawing = new ImageView();
    // The text for volume output
    private final Label volumeText = new Label();


    public CylinderPane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Cylinder text
        Label classText = new Label(cylinder.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the cylinder drawing
        Image sphereImage = new Image(Objects.requireNonNull(Control.class.
                getResource("ShapeImages/"+ cylinder.getClass().getSimpleName()+".png")).toString()); // Get image
        cylinderDrawing.setImage(sphereImage);
        // Default photo size is 1
        cylinderDrawing.setFitWidth(1d);
        cylinderDrawing.setFitHeight(1d);
        // Style the text
        volumeText.setStyle("-fx-font-size:14px;");
        // Default text for user inputs
        radiusTextInput.setPromptText("Insert radius here");
        heightTextInput.setPromptText("Insert height here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(radiusTextInput);
        optionsContainer.getChildren().add(radiusComboBox);
        optionsContainer.getChildren().add(heightTextInput);
        optionsContainer.getChildren().add(heightComboBox);
        // The cylinder shape and the volume will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(volumeText);
        BorderPane.setAlignment(volumeText, Pos.CENTER);
        outputPane.setCenter(cylinderDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the radius text input
        radiusTextInput.setOnKeyTyped(e-> setCylinderRadiusTextField());

        // Set on action for the radius combo box
        radiusComboBox.setOnAction(e-> setCylinderRadiusComboBox());

        // Set the action for the height text input
        heightTextInput.setOnKeyTyped(e-> setCylinderHeightTextField());

        // Set on action for the height combo box
        heightComboBox.setOnAction(e-> setCylinderHeightComboBox());
    }
    private void setCylinderRadiusTextField() {
        try {
            // The input is the radius
            double radius = Double.parseDouble(radiusTextInput.getText());
            // Use the radius
            cylinder.setRadius(radius);
            // This is done so that you cannot blow up the cylinder to too large of a size
            if (radius < MAX_LENGTH_DRAWING)
                cylinderDrawing.setFitWidth(radius + BASE_SHAPE_SIZE);
            else cylinderDrawing.setFitWidth(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
            // Output volume
            volumeText.setText("Volume: "+ cylinder.getVolume());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setCylinderHeightTextField() {
        try {
            // The input is the height
            double height = Double.parseDouble(heightTextInput.getText());
            // Use the height
            cylinder.setHeight(height);
            // This is done so that you cannot blow up the cylinder to too large of a size
            if(height < MAX_LENGTH_DRAWING)
                cylinderDrawing.setFitHeight(height + BASE_SHAPE_SIZE);
            else cylinderDrawing.setFitHeight(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
            // Output volume
            volumeText.setText("Volume: "+ cylinder.getVolume());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setCylinderRadiusComboBox() {
        int radius = radiusComboBox.getValue(); // This is an int because the combo box only has int options
        // Set radius
        cylinder.setRadius(radius);
        // This is done so that you cannot blow up the cylinder to too large of a size
        if (radius < MAX_LENGTH_DRAWING)
            cylinderDrawing.setFitWidth(radius + BASE_SHAPE_SIZE);
        else cylinderDrawing.setFitWidth(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
        // Output volume
        volumeText.setText("Volume: " + cylinder.getVolume());
    }
    private void setCylinderHeightComboBox() {
        int height = heightComboBox.getValue(); // This is an int because the combo box only has int options
        // Set height
        cylinder.setHeight(height);
        // This is done so that you cannot blow up the cylinder to too large of a size
        if(height < MAX_LENGTH_DRAWING)
            cylinderDrawing.setFitHeight(height + BASE_SHAPE_SIZE);
        else cylinderDrawing.setFitHeight(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
        // Output volume
        volumeText.setText("Volume: " + cylinder.getVolume());
    }
}
