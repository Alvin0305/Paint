package com.example.paint.paint.sidebar.details;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class Pair extends HBox {

    Text keyText = new Text();
    Text valueText = new Text();
    Region spacer = new Region();

    public Pair(String key, String value) {

        keyText.setText(key);
        valueText.setText(value);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        this.getChildren().addAll(keyText, spacer, valueText);
    }
}
