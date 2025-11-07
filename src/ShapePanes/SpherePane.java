// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

package ShapePanes;

import ConcreteClasses.ThreeDimensionalShapes.Sphere;
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

public class SpherePane extends VBox implements Control{

    // There is a max drawing radius so that the sphere cannot blow up the window
    private final static int MAX_SIZE_DRAWING = 250;
    // The shape for calculation
    private final Sphere sphere = new Sphere();
    // Enter radius here
    private final TextField radiusTextInput = new TextField();
    // Alternative to the above text input. Select a radius instead.
    private final ComboBox<Integer> radiusComboBox = new ComboBox<>(getListOfIntegers());
    // Display sphere here
    private final ImageView sphereDrawing = new ImageView();
    // The text for volume output
    private final Label volumeText = new Label();


    public SpherePane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Circle text
        Label classText = new Label(sphere.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the sphere
        Image sphereImage = new Image(Objects.requireNonNull(SpherePane.class.
                getResource("ShapeImages/"+sphere.getClass().getSimpleName()+".png")).toString()); // Get image
        sphereDrawing.setImage(sphereImage);
        sphereDrawing.setPreserveRatio(true);
        sphereDrawing.setFitWidth(1d); // Default photo size is 1
        // Style the text
        volumeText.setStyle("-fx-font-size:14px;");
        // Default text for user input
        radiusTextInput.setPromptText("Insert radius here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(radiusTextInput);
        optionsContainer.getChildren().add(radiusComboBox);
        // The sphere shape and the volume will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(volumeText);
        BorderPane.setAlignment(volumeText, Pos.CENTER);
        outputPane.setCenter(sphereDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the text input
        radiusTextInput.setOnKeyTyped(e->{
            try {
                // The input is the radius
                double radius = Double.parseDouble(radiusTextInput.getText());
                // Use the radii
                sphere.setRadius(radius);
                // This is done so that the sphere cannot blow up the window
                if (radius < MAX_SIZE_DRAWING)
                    sphereDrawing.setFitWidth(radius + BASE_SHAPE_SIZE);
                else sphereDrawing.setFitWidth(MAX_SIZE_DRAWING + BASE_SHAPE_SIZE);
                // Output volume
                volumeText.setText("Volume: "+ sphere.getVolume());

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
            sphere.setRadius(radius);
            sphereDrawing.setFitWidth(radius + BASE_SHAPE_SIZE);
            // Output volume
            volumeText.setText("Volume: " + sphere.getVolume());
        });
    }
}
