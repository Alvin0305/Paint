package com.example.paint.assets;

public class Transformation {

    public static double[][] translate(double a, double b) {
        return new double[][] {
                {1, 0, 0},
                {0, 1, 0},
                {a, b, 1}
        };
    }

    public static double[][] scale(double s) {
        return scale(s, s);
    }

    public static double[][] scale(double sx, double sy) {
        return new double[][] {
                {sx, 0, 0},
                {0, sy, 0},
                {0, 0, 1}
        };
    }

    public static double[][] rotate(double theta) {
        return new double[][] {
                {Math.cos(theta), -Math.sin(theta), 0},
                {Math.sin(theta), Math.cos(theta), 0},
                {0, 0, 1}
        };
    }
}
