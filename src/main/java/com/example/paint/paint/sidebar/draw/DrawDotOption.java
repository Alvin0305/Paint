package com.example.paint.paint.sidebar.draw;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Dot;
import com.example.paint.paint.shapes.Shape;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DrawDotOption extends TitledPane {

    private final TextField xField = new TextField();
    private final TextField yField = new TextField();

    private final HBox fields = new HBox(xField, yField);

    private final Button drawButton = new Button("Draw");
    private final VBox content = new VBox(fields, drawButton);

    public DrawDotOption() {
        this.setText("Draw Dot");

        xField.setPromptText("x...");
        yField.setPromptText("y...");

        drawButton.setOnAction(event -> onAction());
        this.setContent(content);
    }

    private void onAction() {
        double xValue = Functions.getValue(xField), yValue = Functions.getValue(yField);

        Dot dot = new Dot(xValue, yValue);
        dot.select();
        Config.canvas.getChildren().add(dot);
    }
}
