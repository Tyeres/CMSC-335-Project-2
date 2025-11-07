package ShapePanes.ThreeDimensional;

import ConcreteClasses.ThreeDimensionalShapes.Torus;
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

public class TorusPane extends VBox implements Control {

    // The shape for calculation
    private final Torus torus = new Torus();
    // Enter small radius here
    private final TextField smallRadiusTextInput = new TextField();
    // Alternative to the above text input. Select a radius instead.
    private final ComboBox<Integer> smallRadiusComboBox = new ComboBox<>(getListOfIntegers());
    // Enter big radius here
    private final TextField bigRadiusTextInput = new TextField();
    // Alternative to the above text input. Select a height instead.
    private final ComboBox<Integer> bigRadiusComboBox = new ComboBox<>(getListOfIntegers());
    // Display torus here
    private final ImageView torusDrawing = new ImageView();
    // The text for volume output
    private final Label volumeText = new Label();
    // This shape is different in that its dimensions will not dynamically change.
    // Let the user know.
    private final Label sizeNotice = new Label("Note: shape size is static.");


    public TorusPane() {
        super(5); // Padding 5
        this.setAlignment(Pos.TOP_CENTER);
        // Torus text
        Label classText = new Label(torus.getClass().getSimpleName());
        classText.setStyle("-fx-font-weight: bold; -fx-font-size: 24px;");
        getChildren().add(classText);
        // Set the characteristics of the torus drawing
        Image sphereImage = new Image(Objects.requireNonNull(Control.class.
                getResource("ShapeImages/" + torus.getClass().getSimpleName() + ".png")).toString()); // Get image
        torusDrawing.setImage(sphereImage);
        torusDrawing.setPreserveRatio(true);
        torusDrawing.setFitWidth(250d); // The default size is 125
        torusDrawing.setVisible(false); // We don't want it visible immediately
        // Style the text
        volumeText.setStyle("-fx-font-size:14px;");
        // Default text for user inputs
        smallRadiusTextInput.setPromptText("Insert small radius here");
        bigRadiusTextInput.setPromptText("Insert big radius here");
        // We want the control options to be displayed horizontally in this pane. We use an HBox for that
        HBox optionsContainer = new HBox(5);
        // Add the text input options into the horizontal pane
        optionsContainer.getChildren().add(smallRadiusTextInput);
        optionsContainer.getChildren().add(smallRadiusComboBox);
        optionsContainer.getChildren().add(bigRadiusTextInput);
        optionsContainer.getChildren().add(bigRadiusComboBox);

        sizeNotice.setStyle("-fx-text-fill: red;");
        sizeNotice.setVisible(false); // We only want this shown when the shape is visible

        // The torus shape and the volume will be outputted here
        BorderPane outputPane = new BorderPane();
        // Set the output pane
        outputPane.setTop(volumeText);
        BorderPane.setAlignment(volumeText, Pos.CENTER);
        outputPane.setCenter(torusDrawing);
        outputPane.setBottom(sizeNotice);
        BorderPane.setAlignment(sizeNotice, Pos.CENTER);
        // Add the options and the output panes to this pane
        getChildren().add(optionsContainer);
        getChildren().add(outputPane);

        // Set the action for the radius text input
        smallRadiusTextInput.setOnKeyTyped(e -> setSmallRadiusTextField());

        // Set on action for the radius combo box
        smallRadiusComboBox.setOnAction(e -> setSmallRadiusComboBox());

        // Set the action for the height text input
        bigRadiusTextInput.setOnKeyTyped(e -> setBigRadiusTextField());

        // Set on action for the height combo box
        bigRadiusComboBox.setOnAction(e -> setBigRadiusComboBox());
    }

    private void setSmallRadiusTextField() {
        try {
            // The input is the smallRadius
            double smallRadius = Double.parseDouble(smallRadiusTextInput.getText());
            // Check if the smallRadius is valid
            if (smallRadius < torus.getBigRadius()) {
                // Use the smallRadius
                torus.setSmallRadius(smallRadius);

                // We only want this to run once before the picture was shown.
                // This is also saying that when you try to display the picture for the first time,
                // both fields have to be filled out
                if (!torusDrawing.isVisible() && (smallRadius > 0 && isBigRadiusFilled())) {
                    torusDrawing.setVisible(true);
                    sizeNotice.setVisible(true);
                }

                // Output volume
                volumeText.setStyle("-fx-text-fill: black;");
                volumeText.setText("Volume: " + torus.getVolume());
            } else {
                // The radius was too large
                volumeText.setStyle("-fx-text-fill: red;");
                volumeText.setText("WARNING: The small radius is too large. \nIt must be smaller than the large radius.");
            }

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }

    }

    private void setBigRadiusTextField() {
        try {
            // The input is the bigRadius
            double bigRadius = Double.parseDouble(bigRadiusTextInput.getText());
            // Check if the bigRadius is valid
            if (bigRadius > torus.getSmallRadius()) {
                // Use the bigRadius
                torus.setBigRadius(bigRadius);
                // We only want this to run once before the picture was shown.
                // This is also saying that when you try to display the picture for the first time,
                // both fields have to be filled out
                if (!torusDrawing.isVisible() && (bigRadius > 0 && isSmallRadiusFilled())) {
                    torusDrawing.setVisible(true);
                    sizeNotice.setVisible(true);
                }
                // Output volume
                volumeText.setStyle("-fx-text-fill: black;");
                volumeText.setText("Volume: " + torus.getVolume());
            } else {
                // The radius was too small
                volumeText.setStyle("-fx-text-fill: red;");
                volumeText.setText("WARNING: The large radius is too small. \nIt must be larger than the small radius.");
            }

        } catch (NumberFormatException exception) {
            // We don't have to do anything. The user should see the problem immediately too; so,
            // we don't need an error message.
            // (The user did not insert a number in the text field)
        }
    }

    private void setSmallRadiusComboBox() {
        int smallRadius = smallRadiusComboBox.getValue(); // This is an int because the combo box only has int options
        // Check if the smallRadius is valid
        if (smallRadius < torus.getBigRadius()) {
            // Set smallRadius
            torus.setSmallRadius(smallRadius);
            // We only want this to run once before the picture was shown.
            // This is also saying that when you try to display the picture for the first time,
            // both fields have to be filled out
            if (!torusDrawing.isVisible() && (smallRadius > 0 && isBigRadiusFilled())) {
                torusDrawing.setVisible(true);
                sizeNotice.setVisible(true);
            }
            // Output volume
            volumeText.setStyle("-fx-text-fill: black;");
            volumeText.setText("Volume: " + torus.getVolume());
        } else {
            // The radius was too large
            volumeText.setStyle("-fx-text-fill: red;");
            volumeText.setText("WARNING: The small radius is too large. \nIt must be smaller than the large radius.");
        }
    }

    private void setBigRadiusComboBox() {
        int bigRadius = bigRadiusComboBox.getValue(); // This is an int because the combo box only has int options
        // Check if the bigRadius is valid
        if (bigRadius > torus.getSmallRadius()) {
            // Set bigRadius
            torus.setBigRadius(bigRadius);
            // We only want this to run once before the picture was shown.
            // This is also saying that when you try to display the picture for the first time,
            // both fields have to be filled out
            if (!torusDrawing.isVisible() && (bigRadius > 0 && isSmallRadiusFilled())) {
                torusDrawing.setVisible(true);
                sizeNotice.setVisible(true);
            }
            // Output volume
            volumeText.setStyle("-fx-text-fill: black;");
            volumeText.setText("Volume: " + torus.getVolume());
        }  else {
            // The radius was too small
            volumeText.setStyle("-fx-text-fill: red;");
            volumeText.setText("WARNING: The large radius is too small. \nIt must be larger than the small radius.");
        }
    }
    // This is used to check if either the textField or (not and) the ComboBox for the big radius was filled
    private boolean isBigRadiusFilled() {
        return (isNumber(bigRadiusTextInput.getText())
                || bigRadiusComboBox.getSelectionModel().getSelectedItem() != null);
    }

    // This is used to check if either the textField or (not and) the ComboBox for the small radius was filled
    private boolean isSmallRadiusFilled() {
        return (isNumber(smallRadiusTextInput.getText())
                || smallRadiusComboBox.getSelectionModel().getSelectedItem() != null);
    }
    // Used to check if the given string is a number
    private boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
