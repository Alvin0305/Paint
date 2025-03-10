package com.example.paint.paint.sidebar.details;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Triangle;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class TriangleDetails extends TitledPane {

    public TriangleDetails(Triangle triangle) {

        Pair locationA = new Pair("A", Functions.coordinatesToString(triangle.coordinates1));
        Pair locationB = new Pair("B", Functions.coordinatesToString(triangle.coordinates2));
        Pair locationC = new Pair("C", Functions.coordinatesToString(triangle.coordinates3));

        VBox contents = new VBox(locationA, locationB, locationC);
        this.setText("Details-Triangle");
        this.setContent(contents);
    }
}
