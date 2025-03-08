package com.example.paint.paint.canvas;

import com.example.paint.paint.shapes.Dot;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Canvas extends Pane {

    public Canvas() {
        this.getChildren().addAll(new Dot(50, 50), new Dot(100, 100, 10, Color.BLUE));
    }
}
