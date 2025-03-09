package com.example.paint.paint.sidebar.translate;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TranslateDotOption extends TitledPane {
    private final TextField xField = new TextField();
    private final TextField yField = new TextField();

    private final Button translateButton = new Button("Translate");

    private final HBox fields = new HBox(xField, yField);
    private VBox content = new VBox(fields, translateButton);

    public TranslateDotOption() {
        this.setText("Translate Dot");
        xField.setPromptText("dx...");
        yField.setPromptText("dy...");

        translateButton.setOnAction(event -> onAction());
        this.setContent(content);

        this.setExpanded(false);
    }

    private void onAction() {
        double xValue = Functions.getValue(xField), yValue = Functions.getValue(yField);

        if (Config.selectedDot != null) {
            Config.selectedDot.translate(xValue, yValue);
        }
    }
}
