package ShapePanes.ThreeDimensional;

import ConcreteClasses.ThreeDimensionalShapes.Cone;
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


public class ConePane extends VBox implements Control {

    // This is used to that the cone cannot blow up the window
    private final static int MAX_LENGTH_DRAWING = 250;
    // The shape for calculation
    private final Cone cone = new Cone();
    // Enter radius here
    private final TextField radiusTextInput = new TextField();
    // Alternative to the above text input. Select a radius instead.
    private final ComboBox<Integer> radiusComboBox = new ComboBox<>(getListOfIntegers());
    // Enter height here
    private final TextField heightTextInput = new TextField();
    // Alternative to the above text input. Select a height instead.
    private final ComboBox<Integer> heightComboBox = new ComboBox<>(getListOfIntegers());
    // Display cone here
    private final ImageView coneDrawing = new ImageView();
    // The text for volume output
    private final Label volumeText = new Label();


    public ConePane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Cone text
        Label classText = new Label(cone.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the cone drawing
        Image sphereImage = new Image(Objects.requireNonNull(Control.class.
                getResource("ShapeImages/"+cone.getClass().getSimpleName()+".png")).toString()); // Get image
        coneDrawing.setImage(sphereImage);
        // Default photo size is 1
        coneDrawing.setFitWidth(1d);
        coneDrawing.setFitHeight(1d);
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
        // The cone shape and the volume will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(volumeText);
        BorderPane.setAlignment(volumeText, Pos.CENTER);
        outputPane.setCenter(coneDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the radius text input
        radiusTextInput.setOnKeyTyped(e-> setConeRadiusTextField());

        // Set on action for the radius combo box
        radiusComboBox.setOnAction(e-> setConeRadiusComboBox());

        // Set the action for the height text input
        heightTextInput.setOnKeyTyped(e-> setConeHeightTextField());

        // Set on action for the height combo box
        heightComboBox.setOnAction(e-> setConeHeightComboBox());
    }
    private void setConeRadiusTextField() {
        try {
            // The input is the radius
            double radius = Double.parseDouble(radiusTextInput.getText());
            // Use the radius
            cone.setRadius(radius);
            // This is done so that you cannot blow up the cone to too large of a size
            if (radius < MAX_LENGTH_DRAWING)
                coneDrawing.setFitWidth(radius + BASE_SHAPE_SIZE);
            else coneDrawing.setFitWidth(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
            // Output volume
            volumeText.setText("Volume: "+ cone.getVolume());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setConeHeightTextField() {
        try {
            // The input is the height
            double height = Double.parseDouble(heightTextInput.getText());
            // Use the height
            cone.setHeight(height);
            // This is done so that you cannot blow up the cone to too large of a size
            if(height < MAX_LENGTH_DRAWING)
                coneDrawing.setFitHeight(height + BASE_SHAPE_SIZE);
            else coneDrawing.setFitHeight(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
            // Output volume
            volumeText.setText("Volume: "+ cone.getVolume());

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }
    private void setConeRadiusComboBox() {
        int radius = radiusComboBox.getValue(); // This is an int because the combo box only has int options
        // Set radius
        cone.setRadius(radius);
        // This is done so that you cannot blow up the cone to too large of a size
        if (radius < MAX_LENGTH_DRAWING)
            coneDrawing.setFitWidth(radius + BASE_SHAPE_SIZE);
        else coneDrawing.setFitWidth(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
        // Output volume
        volumeText.setText("Volume: " + cone.getVolume());
    }
    private void setConeHeightComboBox() {
        int height = heightComboBox.getValue(); // This is an int because the combo box only has int options
        // Set height
        cone.setHeight(height);
        // This is done so that you cannot blow up the cone to too large of a size
        if(height < MAX_LENGTH_DRAWING)
            coneDrawing.setFitHeight(height + BASE_SHAPE_SIZE);
        else coneDrawing.setFitHeight(BASE_SHAPE_SIZE + MAX_LENGTH_DRAWING);
        // Output volume
        volumeText.setText("Volume: " + cone.getVolume());
    }
}
