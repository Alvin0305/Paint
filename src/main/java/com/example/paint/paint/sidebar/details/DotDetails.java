package com.example.paint.paint.sidebar.details;

import com.example.paint.assets.Functions;
import com.example.paint.paint.shapes.Dot;
import javafx.scene.control.TitledPane;

public class DotDetails extends TitledPane {

    public DotDetails(Dot dot) {
        Pair location = new Pair("Location", Functions.coordinatesToString(dot.coordinates));

        this.setText("Details-Dot");
        this.setContent(location);
    }
}
