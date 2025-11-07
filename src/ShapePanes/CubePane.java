package ShapePanes;

import ConcreteClasses.ThreeDimensionalShapes.Cube;
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

public class CubePane extends VBox implements Control {

    // There is a max drawing side so that the cube cannot blow up the window
    private final static int MAX_SIZE_DRAWING = 250;
    // The shape for calculation
    private final Cube cube = new Cube();
    // Enter side here
    private final TextField sideTextInput = new TextField();
    // Alternative to the above text input. Select a cube instead.
    private final ComboBox<Integer> sideComboBox = new ComboBox<>(getListOfIntegers());
    // Display cube here
    private final ImageView cubeDrawing = new ImageView();
    // The text for volume output
    private final Label volumeText = new Label();


    public CubePane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Circle text
        Label classText = new Label(cube.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the cube
        Image sphereImage = new Image(Objects.requireNonNull(SpherePane.class.
                getResource("ShapeImages/"+cube.getClass().getSimpleName()+".png")).toString()); // Get image
        cubeDrawing.setImage(sphereImage);
        cubeDrawing.setPreserveRatio(true);
        cubeDrawing.setFitWidth(1d); // Default photo size is 1
        // Style the text
        volumeText.setStyle("-fx-font-size:14px;");
        // Default text for user input
        sideTextInput.setPromptText("Insert side here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(sideTextInput);
        optionsContainer.getChildren().add(sideComboBox);
        // The cube shape and the volume will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(volumeText);
        BorderPane.setAlignment(volumeText, Pos.CENTER);
        outputPane.setCenter(cubeDrawing);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the text input
        sideTextInput.setOnKeyTyped(e->{
            try {
                // The input is the side
                double side = Double.parseDouble(sideTextInput.getText());
                // Use the side
                cube.setSide(side);
                // This is done so that the cube cannot blow up the window
                if (side < MAX_SIZE_DRAWING)
                    cubeDrawing.setFitWidth(side + BASE_SHAPE_SIZE);
                else cubeDrawing.setFitWidth(MAX_SIZE_DRAWING + BASE_SHAPE_SIZE);
                // Output volume
                volumeText.setText("Volume: "+ cube.getVolume());

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
            cube.setSide(side);
            cubeDrawing.setFitWidth(side + BASE_SHAPE_SIZE);
            // Output volume
            volumeText.setText("Volume: " + cube.getVolume());
        });
    }

}
