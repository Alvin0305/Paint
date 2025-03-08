package com.example.paint.paint.sidebar;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class Heading extends HBox {
    public Heading(String heading) {
        Text title = new Text(heading);
        Region spacer = new Region();
        spacer.setPrefWidth(10);

        Separator line = new Separator(Orientation.HORIZONTAL);

        HBox.setHgrow(line, Priority.ALWAYS);
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(title, line);
    }
}
