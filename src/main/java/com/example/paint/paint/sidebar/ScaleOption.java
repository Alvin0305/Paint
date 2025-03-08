package com.example.paint.paint.sidebar;

import com.example.paint.assets.Config;
import com.example.paint.paint.shapes.Dot;
import com.example.paint.paint.shapes.Shape;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ScaleOption extends TitledPane {
    private final Heading pivotHeading = new Heading("Center");
    private final TextField pivotXField = new TextField();
    private final TextField pivotYField = new TextField();

    private final HBox pivotBox = new HBox(pivotXField, pivotYField);

    private final Heading scaleHeading = new Heading("Scale Options");

    private final CheckBox uniformScalingBox = new CheckBox("Uniform Scaling");

    private final TextField sxyField = new TextField();

    private final TextField sxField = new TextField();
    private final TextField syField = new TextField();

    private final Button scaleButton = new Button("Scale");

    private final HBox fields = new HBox(sxField, syField);
    private VBox content = new VBox(pivotHeading, pivotBox, scaleHeading, uniformScalingBox, fields, scaleButton);

    public ScaleOption() {
        if (Config.selectedShape == Shape.DOT) {
            pivotXField.setPromptText("x...");
            pivotYField.setPromptText("y...");
            sxField.setPromptText("sx...");
            syField.setPromptText("sy...");
            sxyField.setPromptText("s...");

            uniformScalingBox.setOnAction(event -> handleUniformScaling());
            scaleButton.setOnAction(event -> onAction());

            this.setText("Scale");
            this.setContent(content);
        }

        this.setExpanded(false);
    }

    private void handleUniformScaling() {
        System.out.println(uniformScalingBox.isSelected());
        if (uniformScalingBox.isSelected() && ! content.getChildren().contains(sxyField)) {
            System.out.println("adding sxy");
            content.getChildren().remove(4);
            content.getChildren().add(4, sxyField);
        } else if (! uniformScalingBox.isSelected() && ! content.getChildren().contains(fields)) {
            System.out.println("removing sxy");
            content.getChildren().remove(4);
            content.getChildren().add(4, fields);
        }
    }

    private double getValue(TextField field) {
        String stringValue = field.getText();
        if (stringValue.isBlank()) return 0;
        return Double.parseDouble(stringValue);
    }

    public void onAction() {
        double pivotX = getValue(pivotXField), pivotY = getValue(pivotYField);

        Dot selectedDot = Config.selectedDot;
        if (selectedDot == null) return;

        if (uniformScalingBox.isSelected()) {
            double sxyValue = getValue(sxyField);
            if (pivotX == 0 && pivotY == 0) {
                selectedDot.scale(sxyValue);
            } else {
                selectedDot.scale(pivotX, pivotY, sxyValue);
            }
        } else {
            double sxValue = getValue(sxField), syValue = getValue(syField);
            if (pivotX == 0 && pivotY == 0) {
                selectedDot.scale(sxValue, syValue);
            } else {
                selectedDot.scale(pivotX, pivotY, sxValue, syValue);
            }
        }
    }


}
