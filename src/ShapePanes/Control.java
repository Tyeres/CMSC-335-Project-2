// Name: Aidan Snyder
// Course: CMSC 335
// Assignment: Project 2
// Date: 11/7/2025
package ShapePanes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface Control {
    // The displayed shapes are very small if we use the user sizes alone.
    // For that reason, when drawing the shapes, we add this value to the shapes' dimensions' values.
    int BASE_SHAPE_SIZE = 50;
    // For those shape panes that use a suggested list of dimensions, the lists will use this
    default ObservableList<Integer> getListOfIntegers() {
        Integer[] list = new Integer[30];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        return FXCollections.observableArrayList(list);
    }
}