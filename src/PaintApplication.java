// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

import ShapePanes.CirclePane;
import ShapePanes.RectanglePane;
import ShapePanes.SquarePane;
import ShapePanes.TrianglePane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PaintApplication extends Application {
    // The nodes will be saved here
    private static final Node[] shapePaneArray = new Node[9];
    @Override
    public void start(Stage primaryStage) {
        // Initialize the elements in the array.
        // When a selection is matched from the ListView, the corresponding shape is added
        // to the mainPane.
        shapePaneArray[0] = new CirclePane();
        shapePaneArray[1] = new RectanglePane();
        shapePaneArray[2] = new SquarePane();
        shapePaneArray[3] = new TrianglePane();

        // Main pane
        HBox mainPane = new HBox(5);
        // Set insets
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        // This is the listview
        ListView<String> shapeList = new ListView<>(getShapeList());
        // Add it to the pane
        mainPane.getChildren().add(shapeList);
        // We don't want multiple selections
        shapeList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // We do this because we want a default shape selected
        shapeList.getSelectionModel().selectFirst();
        // Display the circle by default
        mainPane.getChildren().add(shapePaneArray[0]);
        // Set action to listView
        shapeList.getSelectionModel().selectedItemProperty().addListener(e-> {
            // Display the selected pane

            // Remove the displayed shape
            mainPane.getChildren().remove(1);

            // Add selected pane
            switch (shapeList.getSelectionModel().getSelectedItem()) {
                case "Circle":
                    mainPane.getChildren().add(shapePaneArray[0]);
                    break;
                case "Rectangle":
                    mainPane.getChildren().add(shapePaneArray[1]);
                    break;
                case "Square":
                    mainPane.getChildren().add(shapePaneArray[2]);
                    break;
                case "Triangle":
                    mainPane.getChildren().add(shapePaneArray[3]);
            }
        });

        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    // This is used for the ListView. It displays the list of shapePaneArray.
    private ObservableList<String> getShapeList() {
        // List of strings for the ListView for the shapes
        String[] shapes = new String[9];
        shapes[0] = "Circle";
        shapes[1] = "Rectangle";
        shapes[2] = "Square";
        shapes[3] = "Triangle";
        shapes[4] = "Sphere";
        shapes[5] = "Cube";
        shapes[6] = "Cone";
        shapes[7] = "Cylinder";
        shapes[8] = "Torus";
        return FXCollections.observableArrayList(shapes);
    }
}
