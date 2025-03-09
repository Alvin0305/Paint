package com.example.paint.paint.sidebar.move;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MoveLineOption extends TitledPane {
    private final TextField xField = new TextField();
    private final TextField yField = new TextField();

    private final Button moveButton = new Button("Move");

    private final HBox fields = new HBox(xField, yField);
    private VBox content = new VBox(fields, moveButton);

    public MoveLineOption() {
        this.setText("Move Line");
        xField.setPromptText("x...");
        yField.setPromptText("y...");

        moveButton.setOnAction(event -> onAction());
        this.setContent(content);

        this.setExpanded(false);
    }

    private void onAction() {
        double xValue = Functions.getValue(xField), yValue = Functions.getValue(yField);

        if (Config.selectedLine != null) {
            Config.selectedLine.moveTo(xValue, yValue);
        }
    }
}
