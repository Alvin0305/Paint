package com.example.paint.paint.sidebar.details;

import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Line;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class LineDetails extends TitledPane {

    public LineDetails(Line line) {

        Pair startLocation = new Pair("Start", Functions.coordinatesToString(line.startCoordinates));
        Pair endLocation = new Pair("End", Functions.coordinatesToString(line.endCoordinates));

        VBox contents = new VBox(startLocation, endLocation);
        this.setText("Details-Line");
        this.setContent(contents);
    }
}
