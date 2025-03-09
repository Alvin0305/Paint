package com.example.paint.paint.ribbon;

import javafx.scene.layout.HBox;

public class Ribbon extends HBox {
    public Ribbon() {
        this.getChildren().addAll(new DrawGroup());
    }
}
