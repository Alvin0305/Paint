package com.example.paint.paint.sidebar.draw;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Dot;
import com.example.paint.paint.shapes.Line;
import com.example.paint.paint.shapes.Triangle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DrawTriangleOption extends TitledPane {
    private final TextField xField1 = new TextField();
    private final TextField yField1 = new TextField();
    private final TextField xField2 = new TextField();
    private final TextField yField2 = new TextField();
    private final TextField xField3 = new TextField();
    private final TextField yField3 = new TextField();

    private final HBox fields1 = new HBox(xField1, yField1);
    private final HBox fields2 = new HBox(xField2, yField2);
    private final HBox fields3 = new HBox(xField3, yField3);

    private final Button drawButton = new Button("Draw");
    private final VBox content = new VBox(fields1, fields2, fields3, drawButton);

    public DrawTriangleOption() {
        this.setText("Draw Line");

        xField1.setPromptText("x1...");
        yField1.setPromptText("y1...");
        xField2.setPromptText("x2...");
        yField2.setPromptText("y2...");
        xField3.setPromptText("x3...");
        yField3.setPromptText("y3...");

        drawButton.setOnAction(event -> onAction());
        this.setContent(content);
    }

    private void onAction() {
        double x1 = Functions.getValue(xField1), y1 = Functions.getValue(yField1);
        double x2 = Functions.getValue(xField2), y2 = Functions.getValue(yField2);
        double x3 = Functions.getValue(xField3), y3 = Functions.getValue(yField3);
        System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2 + ", " + x3 + ", " + y3);
        if (x1 == x2 && x1 == x3 && y1 == y2 && y1 == y3) {
            Dot dot = new Dot(x1, y1);
            dot.select();
            Config.canvas.getChildren().add(dot);
        } else {
            Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3);
            triangle.select();
        }
    }
}
