package ShapePanes;

import ConcreteClasses.TwoDimensionalShapes.Circle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CirclePane extends HBox implements Control{
    private Circle circle = new Circle();
    private TextField radiusTextInput = new TextField();
    private ComboBox<Integer> radiusComboBox = new ComboBox<>(getListOfIntegers());

    public CirclePane() {
        super(5);
        radiusTextInput.setPromptText("Insert radius here");
        getChildren().add(radiusTextInput);
        getChildren().add(radiusComboBox);

    }


}
