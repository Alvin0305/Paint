package com.example.paint.paint.shapes;

import com.example.paint.assets.Config;
import com.example.paint.paint.canvas.Canvas;

import java.util.ArrayList;

public class Quadrilateral {

    public double[] coordinates1;
    public double[] coordinates2;
    public double[] coordinates3;
    public double[] coordinates4;

    public Dot dot1;
    public Dot dot2;
    public Dot dot3;
    public Dot dot4;

    private Canvas canvas;

    ArrayList<Dot> dots = new ArrayList<>();

    public Quadrilateral(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        coordinates1 = new double[] {x1, y1, 1};
        coordinates2 = new double[] {x2, y2, 1};
        coordinates3 = new double[] {x3, y3, 1};
        coordinates4 = new double[] {x4, y4, 1};

        canvas = Config.canvas;

        dot1 = new Dot(coordinates1);
        dot2 = new Dot(coordinates2);
        dot3 = new Dot(coordinates3);
        dot4 = new Dot(coordinates4);
        canvas.getChildren().addAll(dot1, dot2, dot3, dot4);

        draw();
    }

    public void draw() {
        drawEdge(coordinates1, coordinates2);
        drawEdge(coordinates2, coordinates3);
        drawEdge(coordinates3, coordinates4);
        drawEdge(coordinates4, coordinates1);
    }

    public void drawEdge(double[] startCoordinates, double[] endCoordinates) {
        System.out.println("first edge");
        int x1 = (int) Math.round(startCoordinates[0]);
        int y1 = (int) Math.round(startCoordinates[1]);
        int x2 = (int) Math.round(endCoordinates[0]);
        int y2 = (int) Math.round(endCoordinates[1]);

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        boolean steep = dy > dx;

        if (steep) {
            int temp = x1;
            x1 = y1;
            y1 = temp;

            temp = x2;
            x2 = y2;
            y2 = temp;

            temp = dx;
            dx = dy;
            dy = temp;

            temp = sx;
            sx = sy;
            sy = temp;
        }

        int d = 2 * dy - dx;
        int y = y1;
        int x = x1;

        for (int i = 0; i <= dx; i++) {
            if (steep) {
                System.out.println(y + ", " + x);
                Dot dot = new Dot(y, x);
                dot.setOnMouseClicked(event -> onClick());
                dots.add(dot);
                canvas.getChildren().add(dot);
            } else {
                System.out.println(x + ", " + y);
                Dot dot = new Dot(x, y);
                dot.setOnMouseClicked(event -> onClick());
                dots.add(dot);
                canvas.getChildren().add(dot);
            }
            if (d > 0) {
                y += sy;
                d -= 2 * dx;
            }
            x += sx;
            d += 2 * dy;
        }
    }

    private void onClick() {

    }
}
