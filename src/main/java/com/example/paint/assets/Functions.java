package com.example.paint.assets;

import javafx.scene.control.TextField;

public class Functions {

    public static double[] midpoint(double[] coordinates1, double[] coordinates2) {
        return midpoint(coordinates1[0], coordinates1[1], coordinates2[0], coordinates2[1]);
    }

    public static double[] midpoint(double x1, double y1, double x2, double y2) {
        return new double[] {
                (x1 + x2) / 2, (y1 + y2) / 2, 1
        };
    }

    public static double[] centroid(double[] coordinates1, double[] coordinates2, double[] coordinates3) {
        return centroid(coordinates1[0], coordinates1[1], coordinates2[0], coordinates2[1], coordinates3[0], coordinates3[1]);
    }

    public static double[] centroid(double x1, double y1, double x2, double y2, double x3, double y3) {
        return new double[] {
                (x1 + x2 + x3) / 3, (y1 + y2 + y3) / 3, 1
        };
    }

    public static double getValue(TextField field) {
        String stringValue = field.getText();
        if (stringValue.isBlank()) return 0;
        return Double.parseDouble(stringValue);
    }
}
