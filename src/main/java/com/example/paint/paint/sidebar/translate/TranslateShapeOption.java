package com.example.paint.paint.sidebar.translate;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Shape;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TranslateShapeOption extends TitledPane {
    private final TextField xField = new TextField();
    private final TextField yField = new TextField();

    private final Button translateButton = new Button("Translate");

    private final HBox fields = new HBox(xField, yField);
    private VBox content = new VBox(fields, translateButton);

    public TranslateShapeOption() {
        this.setText("Translate Shape");
        xField.setPromptText("dx...");
        yField.setPromptText("dy...");

        translateButton.setOnAction(event -> onAction());
        this.setContent(content);

        this.setExpanded(false);
    }

    private void onAction() {
        double xValue = Functions.getValue(xField), yValue = Functions.getValue(yField);

        if (Config.selectedShape == Shape.TRIANGLE) {
            if (Config.selectedTriangle != null) {
                Config.selectedTriangle.translate(xValue, yValue);
            }
        }
    }
}
