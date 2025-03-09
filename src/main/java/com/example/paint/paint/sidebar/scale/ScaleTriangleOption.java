package com.example.paint.paint.sidebar.scale;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Line;
import com.example.paint.paint.sidebar.Heading;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ScaleTriangleOption extends TitledPane {
    private final Heading pivotHeading = new Heading("Center");
    private final TextField pivotXField = new TextField();
    private final TextField pivotYField = new TextField();
    private final HBox pivotBox = new HBox(pivotXField, pivotYField);

    ToggleGroup scaleGroup = new ToggleGroup();
    RadioButton scaleStartBox = new RadioButton("Scale About Start");
    RadioButton scaleMiddleBox = new RadioButton("Scale About Middle");
    RadioButton scaleEndBox = new RadioButton("Scale About End");

    private final Heading scaleHeading = new Heading("Scale Options");

    private final CheckBox uniformScalingBox = new CheckBox("Uniform Scaling");

    private final TextField sxyField = new TextField();
    private final TextField sxField = new TextField();
    private final TextField syField = new TextField();
    private final HBox fields = new HBox(sxField, syField);

    private final Button scaleButton = new Button("Scale");

    private VBox content = new VBox(pivotHeading, pivotBox, scaleStartBox, scaleMiddleBox, scaleEndBox,
            scaleHeading, uniformScalingBox, fields, scaleButton);

    public ScaleTriangleOption() {
        pivotXField.setPromptText("x...");
        pivotYField.setPromptText("y...");
        sxField.setPromptText("sx...");
        syField.setPromptText("sy...");
        sxyField.setPromptText("s...");

        addListeners();

        uniformScalingBox.setOnAction(event -> handleUniformScaling());
        scaleButton.setOnAction(event -> onAction());

        this.setText("Scale Line");
        this.setContent(content);

        this.setExpanded(false);
    }

    private RadioButton selectedButton = scaleMiddleBox;

    private void addListeners() {
        scaleStartBox.setToggleGroup(scaleGroup);
        scaleMiddleBox.setToggleGroup(scaleGroup);
        scaleEndBox.setToggleGroup(scaleGroup);

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
            content.getChildren().add(7, sxyField);
        } else if (! uniformScalingBox.isSelected() && ! content.getChildren().contains(fields)) {
            System.out.println("removing sxy");
            content.getChildren().remove(sxyField);
            content.getChildren().add(7, fields);
        }
    }

    public void onAction() {
        double pivotX = Functions.getValue(pivotXField), pivotY = Functions.getValue(pivotYField);

        Line selectedLine = Config.selectedLine;
        if (selectedLine == null) return;
        double sxy = Functions.getValue(sxyField), sx = Functions.getValue(sxField), sy = Functions.getValue(syField);
        if (uniformScalingBox.isSelected()) {
            sx = sxy;
            sy = sxy;
        }
        if (scaleStartBox.isSelected()) {
            selectedLine.scaleStart(sx, sy);
        } else if (scaleMiddleBox.isSelected()) {
            selectedLine.scaleMiddle(sx, sy);
        } else if (scaleEndBox.isSelected()) {
            selectedLine.scaleEnd(sx, sy);
        } else {
            selectedLine.scale(pivotX, pivotY, sx, sy);
        }
    }
}
