package com.example.paint.paint.shapes;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.canvas.Canvas;

import java.util.ArrayList;

public class Triangle {

    public double[] coordinates1;
    public double[] coordinates2;
    public double[] coordinates3;

    public Dot dot1;
    public Dot dot2;
    public Dot dot3;

    public Canvas canvas;

    public ArrayList<Dot> dots = new ArrayList<>();
    public String name = "Triangle " + Config.triangleCount;

    public Triangle(double[] coordinates1, double[] coordinates2, double[] coordinates3) {
        this(coordinates1[0], coordinates1[1], coordinates2[0], coordinates2[1], coordinates3[0], coordinates3[1]);
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        coordinates1 = new double[] {x1, y1, 1};
        coordinates2 = new double[] {x2, y2, 1};
        coordinates3 = new double[] {x3, y3, 1};

        canvas = Config.canvas;

        dot1 = new Dot(coordinates1);
        dot2 = new Dot(coordinates2);
        dot3 = new Dot(coordinates3);
        canvas.getChildren().addAll(dot1, dot2, dot3);

        draw();

        Config.triangleCount++;
    }

    public void draw() {
        drawEdge(coordinates1, coordinates2);
        drawEdge(coordinates2, coordinates3);
        drawEdge(coordinates3, coordinates1);
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

    public void onClick() {
        System.out.println("clicked triangle");
        if (Config.selectedTriangle != this) {
            select();
        } else {
            unselect();
        }
    }

    public void select() {
        System.out.println("selected");
        Line selectedLine = Config.selectedLine;
        Dot selectedDot = Config.selectedDot;
        Triangle selectedTriangle = Config.selectedTriangle;

        if (selectedLine != null) {
            selectedLine.unselect();
        }
        if (selectedDot != null) {
            selectedDot.unselect();
        }
        if (selectedTriangle != null) {
            selectedTriangle.unselect();
        }
        Config.selectedLine = null;
        Config.selectedDot = null;
        Config.selectedTriangle = this;
        Config.selectedShape = Shape.TRIANGLE;

        dot1.setFill(Config.selectedTriangleColor);
        dot2.setFill(Config.selectedTriangleColor);
        dot3.setFill(Config.selectedTriangleColor);

        dot1.setWidth(Config.selectedTriangleWidth);
        dot2.setWidth(Config.selectedTriangleWidth);
        dot3.setWidth(Config.selectedTriangleWidth);

        dot1.setHeight(Config.selectedTriangleWidth);
        dot2.setHeight(Config.selectedTriangleWidth);
        dot3.setHeight(Config.selectedTriangleWidth);

        dot1.toFront();
        dot2.toFront();
        dot3.toFront();

        if (! Config.sideBar.getChildren().contains(Config.rotateTriangleOption)) {
            Config.sideBar.getChildren().add(Config.rotateTriangleOption);
        }
    }

    public void unselect() {
        System.out.println("unselected");
        Config.selectedTriangle = null;

        dot1.setFill(Config.defaultTriangleColor);
        dot2.setFill(Config.defaultTriangleColor);
        dot3.setFill(Config.defaultTriangleColor);

        dot1.setWidth(Config.defaultTriangleWidth);
        dot2.setWidth(Config.defaultTriangleWidth);
        dot3.setWidth(Config.defaultTriangleWidth);

        dot1.setHeight(Config.defaultTriangleWidth);
        dot2.setHeight(Config.defaultTriangleWidth);
        dot3.setHeight(Config.defaultTriangleWidth);

        Config.sideBar.getChildren().remove(Config.translateLineOption);
        Config.sideBar.getChildren().remove(Config.scaleLineOption);
        Config.sideBar.getChildren().remove(Config.rotateLineOption);
        Config.sideBar.getChildren().remove(Config.moveLineOption);
    }

    private void deleteExceptEnds() {
        int i = 0;
        while (i < dots.size()) {
            canvas.getChildren().remove(dots.get(i));
            i++;
        }
        dots.clear();
    }

    private void redraw() {
        coordinates1 = dot1.coordinates;
        coordinates2 = dot2.coordinates;
        coordinates3 = dot3.coordinates;

        draw();
        dot1.toFront();
        dot2.toFront();
        dot3.toFront();
    }

    public void translate(double dx, double dy) {
        deleteExceptEnds();

        dot1.translate(dx, dy);
        dot2.translate(dx, dy);
        dot3.translate(dx, dy);

        redraw();
    }

    public void rotate(double theta) {
        rotate(0, 0, theta);
    }

    public void rotate(double x, double y, double theta) {
        deleteExceptEnds();

        dot1.rotate(x, y, theta);
        dot2.rotate(x, y, theta);
        dot3.rotate(x, y, theta);

        redraw();
    }

    public void rotateMiddle(double theta) {
        deleteExceptEnds();
        double[] centroid = Functions.centroid(coordinates1, coordinates2, coordinates3);

        dot1.rotate(centroid, theta);
        dot2.rotate(centroid, theta);
        dot3.rotate(centroid, theta);

        redraw();
    }

    private void rotateAboutVertex(double[] coordinates, double theta) {
        deleteExceptEnds();

        dot1.rotate(coordinates, theta);
        dot2.rotate(coordinates, theta);
        dot3.rotate(coordinates, theta);

        redraw();
    }

    public void rotateA(double theta) {
        rotateAboutVertex(coordinates1, theta);
    }

    public void rotateB(double theta) {
        rotateAboutVertex(coordinates2, theta);
    }

    public void rotateC(double theta) {
        rotateAboutVertex(coordinates3, theta);
    }

    public void moveATo(double x, double y) {
        translate(x - coordinates1[0], y - coordinates1[1]);
    }

    public void moveBTo(double x, double y) {
        translate(x - coordinates2[0], y - coordinates2[1]);
    }

    public void movCATo(double x, double y) {
        translate(x - coordinates3[0], y - coordinates3[1]);
    }

    public void moveTo(double x, double y) {
        double[] centroid = Functions.centroid(coordinates1, coordinates2, coordinates3);
        translate(x - centroid[0], y - centroid[1]);
    }

    public void scale(double x, double y, double sx, double sy) {
        deleteExceptEnds();

        dot1.scale(x, y, sx, sy);
        dot2.scale(x, y, sx, sy);
        dot3.scale(x, y, sx, sy);

        redraw();
    }

    public void scaleMiddle(double sx, double sy) {
        deleteExceptEnds();
        double[] centroid = Functions.centroid(coordinates1, coordinates2, coordinates3);

        dot1.scale(centroid, sx, sy);
        dot2.scale(centroid, sx, sy);
        dot3.scale(centroid, sx, sy);

        redraw();
    }

    public void scaleAboutVertex(double[] coordinates, double sx, double sy) {
        deleteExceptEnds();

        dot1.scale(coordinates, sx, sy);
        dot2.scale(coordinates, sx, sy);
        dot3.scale(coordinates, sx, sy);

        redraw();
    }

    public void scaleA(double sx, double sy) {
        scaleAboutVertex(coordinates1, sx, sy);
    }

    public void scaleB(double sx, double sy) {
        scaleAboutVertex(coordinates2, sx, sy);
    }

    public void scaleC(double sx, double sy) {
        scaleAboutVertex(coordinates3, sx, sy);
    }

}
