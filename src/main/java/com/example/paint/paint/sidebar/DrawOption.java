package com.example.paint.paint.sidebar;

import com.example.paint.assets.Config;
import com.example.paint.paint.shapes.Dot;
import com.example.paint.paint.shapes.Shape;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DrawOption extends TitledPane {

    private final TextField xField1 = new TextField();
    private final TextField yField1 = new TextField();

    private final HBox fields1 = new HBox(xField1, yField1);

    private final Button drawButton = new Button("Draw");
    private final VBox content = new VBox(fields1, drawButton);

    public DrawOption() {
        if (Config.selectedDrawShape.equals(Shape.DOT)) {
            this.setText("Draw Dot");

            xField1.setPromptText("x...");
            yField1.setPromptText("y...");

            drawButton.setOnAction(event -> onDotAction());
            this.setContent(content);
        }
    }

    private double getValue(TextField field) {
        String stringValue = field.getText();
        if (stringValue.isBlank()) return 0;
        return Double.parseDouble(stringValue);
    }

    private void onDotAction() {
        double xValue = getValue(xField1), yValue = getValue(yField1);

        Dot dot = new Dot(xValue, yValue);
        dot.select();
        Config.canvas.getChildren().add(dot);
    }
}
