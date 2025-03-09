package com.example.paint.paint.sidebar.rotate;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Dot;
import com.example.paint.paint.sidebar.Heading;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RotateDotOption extends TitledPane {
    Heading pivotHeading = new Heading("Pivot");

    TextField pivotXField = new TextField();
    TextField pivotYField = new TextField();
    HBox pivotBox = new HBox(pivotXField, pivotYField);

    Heading rotateHeading = new Heading("Rotate Options");

    TextField angleField = new TextField();
    Button rotateButton = new Button("Rotate");

    VBox content = new VBox(pivotHeading, pivotBox, rotateHeading, angleField, rotateButton);;

    public RotateDotOption() {
        pivotXField.setPromptText("x...");
        pivotYField.setPromptText("y...");
        angleField.setPromptText("Angle...");
        this.setText("Rotate Dot");

        rotateButton.setOnAction(event -> onAction());
        this.setContent(content);

        this.setExpanded(false);
    }

    public void onAction() {
        double pivotX = Functions.getValue(pivotXField), pivotY = Functions.getValue(pivotYField);
        double angle = Math.toRadians(Functions.getValue(angleField));

        Dot selectedDot = Config.selectedDot;
        if (pivotX == 0 && pivotY == 0) {
            if (selectedDot != null) {
                selectedDot.rotate(angle);
            }
        } else {
            if (selectedDot != null) {
                selectedDot.rotate(pivotX, pivotY, angle);
            }
        }
    }
}
