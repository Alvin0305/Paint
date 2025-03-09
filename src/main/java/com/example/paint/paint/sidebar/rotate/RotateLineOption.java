package com.example.paint.paint.sidebar.rotate;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Line;
import com.example.paint.paint.sidebar.Heading;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RotateLineOption extends TitledPane {
    Heading pivotHeading = new Heading("Pivot");

    TextField pivotXField = new TextField();
    TextField pivotYField = new TextField();
    HBox pivotBox = new HBox(pivotXField, pivotYField);

    Heading rotateHeading = new Heading("Rotate Options");

    TextField angleField = new TextField();
    Button rotateButton = new Button("Rotate");

    ToggleGroup rotateGroup = new ToggleGroup();
    RadioButton rotateStartBox = new RadioButton("Rotate About Start");
    RadioButton rotateMiddleBox = new RadioButton("Rotate About Middle");
    RadioButton rotateEndBox = new RadioButton("Rotate About End");

    VBox content;

    public RotateLineOption() {
        pivotXField.setPromptText("x...");
        pivotYField.setPromptText("y...");
        angleField.setPromptText("Angle...");
        this.setText("Rotate Line");

        rotateStartBox.setToggleGroup(rotateGroup);
        rotateMiddleBox.setToggleGroup(rotateGroup);
        rotateEndBox.setToggleGroup(rotateGroup);

        rotateButton.setOnAction(event -> onAction());

        addListeners();

        content = new VBox(pivotHeading, pivotBox, rotateStartBox, rotateMiddleBox, rotateEndBox,
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

        Line selectedLine = Config.selectedLine;
        if (selectedLine != null) {
            if (rotateMiddleBox.isSelected()) {
                selectedLine.rotateMiddle(angle);
            } else if (rotateStartBox.isSelected()) {
                selectedLine.rotateStart(angle);
            } else if (rotateEndBox.isSelected()) {
                selectedLine.rotateEnd(angle);
            } else {
                selectedLine.rotate(pivotX, pivotY, angle);
            }
        }
    }
}
