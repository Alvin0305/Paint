package com.example.paint.paint.ribbon;

import com.example.paint.assets.Config;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DrawGroup extends VBox {
    HBox buttons = new HBox();
    Button dotButton = new Button(".");
    Button lineButton = new Button("/");
    Button circleButton = new Button("o");
    Button splineButton = new Button("~");

    Text groupName = new Text("Draw");

    public DrawGroup() {
        addListeners();

        buttons.getChildren().addAll(dotButton, lineButton, circleButton, splineButton);
        this.getChildren().addAll(buttons, groupName);
    }

    private void addListeners() {
        dotButton.setOnAction(event -> {
            Config.sideBar.getChildren().remove(Config.drawLineOption);
            if (! Config.sideBar.getChildren().contains(Config.drawDotOption)) {
                System.out.println("adding dot option");
                Config.sideBar.getChildren().addFirst(Config.drawDotOption);
            }
        });
        lineButton.setOnAction(event -> {
            Config.sideBar.getChildren().remove(Config.drawDotOption);
            if (! Config.sideBar.getChildren().contains(Config.drawLineOption)) {
                System.out.println("adding line option");
                Config.sideBar.getChildren().addFirst(Config.drawLineOption);
            }
        });
    }
}
