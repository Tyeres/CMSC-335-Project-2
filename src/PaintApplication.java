// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025

import AbstractClasses.Shape;
import ConcreteClasses.ThreeDimensionalShapes.*;
import ConcreteClasses.TwoDimensionalShapes.Circle;
import ConcreteClasses.TwoDimensionalShapes.Rectangle;
import ConcreteClasses.TwoDimensionalShapes.Square;
import ConcreteClasses.TwoDimensionalShapes.Triangle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PaintApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        // Main pane
        HBox mainPane = new HBox(5);
        // Set insets
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        ListView<Shape> shapeList = new ListView<>(getShapeList());
        mainPane.getChildren().add(shapeList);

        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    // This is used for the ListView. It displays the list of shapes.
    private ObservableList<Shape> getShapeList() {
        // List of shapes
        Shape[] shapes = new Shape[9];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        shapes[3] = new Triangle();
        shapes[4] = new Sphere();
        shapes[5] = new Cube();
        shapes[6] = new Cone();
        shapes[7] = new Cylinder();
        shapes[8] = new Torus();
        return FXCollections.observableArrayList(shapes);
    }
}
