package com.example.paint.paint.shapes;

import com.example.paint.assets.Config;
import com.example.paint.assets.Functions;
import com.example.paint.paint.canvas.Canvas;

import java.util.ArrayList;

public class Line {

    public double[] startCoordinates;
    public double[] endCoordinates;
    public Dot startDot;
    public Dot endDot;
    public Canvas canvas;
    public ArrayList<Dot> dots = new ArrayList<>();
    public String name = "Line" + Config.lineCount;

    public Line(double[] coordinates1, double[] coordinates2) {
        this(coordinates1[0], coordinates1[1], coordinates2[0], coordinates2[1]);
    }

    public Line(double x1, double y1, double x2, double y2) {
        startCoordinates = new double[] {x1, y1, 1};
        endCoordinates = new double[] {x2, y2, 1};

        canvas = Config.canvas;

        startDot = new Dot(startCoordinates);
        endDot = new Dot(endCoordinates);
        canvas.getChildren().addAll(startDot, endDot);

        draw();
        Config.lineCount++;
    }

    private void draw() {
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
        if (Config.selectedLine == this) {
            unselect();
        } else {
            select();
        }
    }

    public void select() {
        System.out.println("selecting line");
        Triangle selectedTriangle = Config.selectedTriangle;
        Line selectedLine = Config.selectedLine;
        Dot selectedDot = Config.selectedDot;
        if (selectedTriangle != null) {
            selectedTriangle.unselect();
        }
        if (selectedLine != null) {
            selectedLine.unselect();
        }
        if (selectedDot != null) {
            selectedDot.unselect();
        }
        Config.selectedDot = null;
        Config.selectedLine = this;
        Config.selectedShape = Shape.LINE;

        startDot.setFill(Config.selectedLineColor);
        startDot.setWidth(Config.selectedLineWidth);
        startDot.setHeight(Config.selectedLineWidth);
        startDot.toFront();
        endDot.setFill(Config.selectedLineColor);
        endDot.setWidth(Config.selectedLineWidth);
        endDot.setHeight(Config.selectedLineWidth);
        endDot.toFront();

        if (! Config.sideBar.getChildren().contains(Config.translateLineOption)) {
            Config.sideBar.getChildren().add(Config.translateLineOption);
        }
        if (! Config.sideBar.getChildren().contains(Config.scaleLineOption)) {
            Config.sideBar.getChildren().add(Config.scaleLineOption);
        }
        if (! Config.sideBar.getChildren().contains(Config.rotateLineOption)) {
            Config.sideBar.getChildren().add(Config.rotateLineOption);
        }
        if (! Config.sideBar.getChildren().contains(Config.moveLineOption)) {
            Config.sideBar.getChildren().add(Config.moveLineOption);
        }
    }

    public void unselect() {
        Config.selectedLine = null;

        startDot.setFill(Config.defaultLineColor);
        startDot.setHeight(Config.defaultLineWidth);
        startDot.setWidth(Config.defaultLineWidth);
        endDot.setFill(Config.defaultLineColor);
        endDot.setHeight(Config.defaultLineWidth);
        endDot.setWidth(Config.defaultLineWidth);

        Config.sideBar.getChildren().remove(Config.translateLineOption);
        Config.sideBar.getChildren().remove(Config.scaleLineOption);
        Config.sideBar.getChildren().remove(Config.rotateLineOption);
        Config.sideBar.getChildren().remove(Config.moveLineOption);
    }

    public void deleteExceptEnds() {
        int i = 0;
        while (i < dots.size()) {
            Config.canvas.getChildren().remove(dots.get(i));
            i++;
        }
        dots.clear();
    }

    private void redraw() {
        startCoordinates = startDot.coordinates;
        endCoordinates = endDot.coordinates;

        draw();
        startDot.toFront();
        endDot.toFront();
    }

    public void translate(double dx, double dy) {
        deleteExceptEnds();

        startDot.translate(dx, dy);
        endDot.translate(dx, dy);
        redraw();
    }

    public void rotateStart(double theta) {
        deleteExceptEnds();

        endDot.rotate(startCoordinates, theta);
        redraw();
    }

    public void rotateEnd(double theta) {
        deleteExceptEnds();

        startDot.rotate(endCoordinates, theta);
        redraw();
    }

    public void rotate(double[] coordinates, double theta) {
        rotate(coordinates[0], coordinates[1], theta);
    }

    public void rotate(double x, double y, double theta) {
        deleteExceptEnds();

        startDot.rotate(x, y, theta);
        endDot.rotate(x, y, theta);

        redraw();
    }

    public void rotateMiddle(double theta) {
        deleteExceptEnds();
        double[] midPoints = Functions.midpoint(startDot.coordinates, endDot.coordinates);

        startDot.rotate(midPoints[0], midPoints[1], theta);
        endDot.rotate(midPoints[0], midPoints[1], theta);
        redraw();
    }

    public void scaleStart(double sx, double sy) {
        deleteExceptEnds();

        endDot.scale(startCoordinates, sx, sy);
        redraw();
    }

    public void scaleEnd(double sx, double sy) {
        deleteExceptEnds();

        startDot.scale(endCoordinates, sx, sy);
        redraw();
    }

    public void scale(double[] coordinates, double sx, double sy) {
        scale(coordinates[0], coordinates[1], sx, sy);
    }

    public void scale(double sx, double sy) {
        scale(0, 0, sx, sy);
    }

    public void scale(double x, double y, double sx, double sy) {
        deleteExceptEnds();

        startDot.scale(x, y, sx, sy);
        endDot.scale(x, y, sx, sy);

        redraw();
    }

    public void scaleMiddle(double sx, double sy) {
        deleteExceptEnds();
        double[] midPoints = Functions.midpoint(startCoordinates, endCoordinates);

        startDot.scale(midPoints, sx, sy);
        endDot.scale(midPoints, sx, sy);
        redraw();
    }

    public void moveTo(double x, double y) {
        translate(x - startCoordinates[0], y - startCoordinates[1]);
    }
}
