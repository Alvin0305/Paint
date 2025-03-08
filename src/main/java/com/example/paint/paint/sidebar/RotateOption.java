package com.example.paint.paint.sidebar;

import com.example.paint.assets.Config;
import com.example.paint.paint.shapes.Dot;
import com.example.paint.paint.shapes.Shape;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RotateOption extends TitledPane {

    Heading pivotHeading = new Heading("Pivot");

    TextField pivotXField = new TextField();
    TextField pivotYField = new TextField();
    HBox pivotBox = new HBox(pivotXField, pivotYField);

    Heading rotateHeading = new Heading("Rotate Options");

    TextField angleField = new TextField();
    Button rotateButton = new Button("Rotate");

    VBox content = new VBox(pivotHeading, pivotBox, rotateHeading, angleField, rotateButton);

    public RotateOption() {
        if (Config.selectedShape == Shape.DOT) {
            pivotXField.setPromptText("x...");
            pivotYField.setPromptText("y...");
            angleField.setPromptText("Angle...");
            rotateButton.setOnAction(event -> onAction());

            this.setText("Rotate");
            this.setContent(content);
        }

        this.setExpanded(false);
    }

    private double getValue(TextField field) {
        String stringValue = field.getText();
        if (stringValue.isBlank()) return 0;
        return Double.parseDouble(stringValue);
    }

    public void onAction() {
        double pivotX = getValue(pivotXField), pivotY = getValue(pivotYField);
        double angle = Math.toRadians(getValue(angleField));

        Dot selectedDot = Config.selectedDot;
        if (selectedDot == null) return;

        if (pivotX == 0 && pivotY == 0) {
            selectedDot.rotate(angle);
        } else {
            selectedDot.rotate(pivotX, pivotY, angle);
        }
    }
}
