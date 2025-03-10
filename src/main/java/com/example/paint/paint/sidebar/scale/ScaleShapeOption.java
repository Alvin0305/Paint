package com.example.paint.paint.sidebar.scale;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Line;
import com.example.paint.paint.shapes.Shape;
import com.example.paint.paint.shapes.Triangle;
import com.example.paint.paint.sidebar.Heading;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ScaleShapeOption extends TitledPane {
    private final Heading pivotHeading = new Heading("Center");
    private final TextField pivotXField = new TextField();
    private final TextField pivotYField = new TextField();
    private final HBox pivotBox = new HBox(pivotXField, pivotYField);

    ToggleGroup scaleGroup = new ToggleGroup();
    RadioButton scaleMiddleBox = new RadioButton("Scale About Middle");

    private final Heading scaleHeading = new Heading("Scale Options");

    private final CheckBox uniformScalingBox = new CheckBox("Uniform Scaling");

    private final TextField sxyField = new TextField();
    private final TextField sxField = new TextField();
    private final TextField syField = new TextField();
    private final HBox fields = new HBox(sxField, syField);

    private final Button scaleButton = new Button("Scale");

    private VBox content = new VBox(pivotHeading, pivotBox, scaleMiddleBox,
            scaleHeading, uniformScalingBox, fields, scaleButton);

    public ScaleShapeOption() {
        pivotXField.setPromptText("x...");
        pivotYField.setPromptText("y...");
        sxField.setPromptText("sx...");
        syField.setPromptText("sy...");
        sxyField.setPromptText("s...");

        addListeners();

        uniformScalingBox.setOnAction(event -> handleUniformScaling());
        scaleButton.setOnAction(event -> onAction());

        this.setText("Scale Shape");
        this.setContent(content);

        this.setExpanded(false);
    }

    private RadioButton selectedButton = scaleMiddleBox;

    private void addListeners() {
        scaleMiddleBox.setToggleGroup(scaleGroup);

        pivotXField.setDisable(true);
        pivotYField.setDisable(true);
        scaleMiddleBox.setSelected(true);

        for (Toggle toggle: scaleGroup.getToggles()) {
            RadioButton radioButton = (RadioButton) toggle;
            radioButton.setOnMouseClicked(event -> {
                if (selectedButton == radioButton) {
                    System.out.println("deselecting " + radioButton.getText());
                    pivotXField.setDisable(false);
                    pivotYField.setDisable(false);
                    radioButton.setSelected(false);
                    selectedButton = null;
                } else {
                    System.out.println("selecting " + radioButton.getText());
                    pivotXField.setDisable(true);
                    pivotYField.setDisable(true);
                    radioButton.setSelected(true);
                    selectedButton = radioButton;
                }
            });
        }
    }

    private void handleUniformScaling() {
        System.out.println(uniformScalingBox.isSelected());
        if (uniformScalingBox.isSelected() && ! content.getChildren().contains(sxyField)) {
            System.out.println("adding sxy");
            content.getChildren().remove(fields);
            content.getChildren().add(5, sxyField);
        } else if (! uniformScalingBox.isSelected() && ! content.getChildren().contains(fields)) {
            System.out.println("removing sxy");
            content.getChildren().remove(sxyField);
            content.getChildren().add(5, fields);
        }
    }

    public void onAction() {
        double pivotX = Functions.getValue(pivotXField), pivotY = Functions.getValue(pivotYField);

        double sxy = Functions.getValue(sxyField), sx = Functions.getValue(sxField), sy = Functions.getValue(syField);
        sx = (sx == 0) ? 1: sx;
        sy = (sy == 0) ? 1: sy;
        sxy = (sxy == 0) ? 1: sxy;
        if (uniformScalingBox.isSelected()) {
            sx = sxy;
            sy = sxy;
        }

        if (Config.selectedShape == Shape.TRIANGLE) {
            Triangle selectedTriangle = Config.selectedTriangle;
            if (selectedTriangle == null) return;

            if (scaleMiddleBox.isSelected()) {
                System.out.println("scaling about middle");
                selectedTriangle.scaleMiddle(sx, sy);
            } else {
                System.out.println("scaling about pivot");
                selectedTriangle.scale(pivotX, pivotY, sx, sy);
            }
        }
    }
}
