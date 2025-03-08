package com.example.paint.paint.sidebar;

import com.example.paint.assets.Config;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TranslateOption extends TitledPane {

    private final TextField xField = new TextField();
    private final TextField yField = new TextField();

    private final Button translateButton = new Button("Translate");

    private final HBox fields = new HBox(xField, yField);
    private VBox content = new VBox(fields, translateButton);

    public TranslateOption() {
        this.setText("Translate");
        xField.setPromptText("dx...");
        yField.setPromptText("dy...");

        translateButton.setOnAction(event -> onAction());
        this.setContent(content);

        this.setExpanded(false);
    }

    private double getValue(TextField field) {
        String stringValue = field.getText();
        if (stringValue.isBlank()) return 0;
        return Double.parseDouble(stringValue);
    }

    private void onAction() {
        double xValue = getValue(xField), yValue = getValue(yField);

        if (Config.selectedDot != null) {
            Config.selectedDot.translate(xValue, yValue);
        }
    }
}
