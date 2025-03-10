package com.example.paint.paint.sidebar.rotate;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Shape;
import com.example.paint.paint.shapes.Triangle;
import com.example.paint.paint.sidebar.Heading;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RotateShapeOption extends TitledPane {

    Heading pivotHeading = new Heading("Pivot");

    TextField pivotXField = new TextField();
    TextField pivotYField = new TextField();
    HBox pivotBox = new HBox(pivotXField, pivotYField);

    Heading rotateHeading = new Heading("Rotate Options");

    TextField angleField = new TextField();
    Button rotateButton = new Button("Rotate");

    ToggleGroup rotateGroup = new ToggleGroup();
    RadioButton rotateMiddleBox = new RadioButton("Rotate About Middle");

    VBox content;

    public RotateShapeOption() {
        pivotXField.setPromptText("x...");
        pivotYField.setPromptText("y...");
        angleField.setPromptText("Angle...");
        this.setText("Rotate Shape");

        rotateMiddleBox.setToggleGroup(rotateGroup);

        rotateButton.setOnAction(event -> onAction());

        addListeners();

        content = new VBox(pivotHeading, pivotBox, rotateMiddleBox,
                rotateHeading, angleField, rotateButton);
        this.setContent(content);

        this.setExpanded(false);
    }

    private RadioButton selectedButton = rotateMiddleBox;

    private void addListeners() {
        pivotXField.setDisable(true);
        pivotYField.setDisable(true);
        rotateMiddleBox.setSelected(true);

        for (Toggle toggle: rotateGroup.getToggles()) {
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

    public void onAction() {
        double pivotX = Functions.getValue(pivotXField), pivotY = Functions.getValue(pivotYField);
        double angle = Math.toRadians(Functions.getValue(angleField));

        if (Config.selectedShape == Shape.TRIANGLE) {
            Triangle selectedTriangle = Config.selectedTriangle;
            if (selectedTriangle != null) {
                if (rotateMiddleBox.isSelected()) {
                    selectedTriangle.rotateMiddle(angle);
                } else {
                    selectedTriangle.rotate(pivotX, pivotY, angle);
                }
            }
        }
    }
}
