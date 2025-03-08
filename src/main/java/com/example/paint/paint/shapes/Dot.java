package com.example.paint.paint.shapes;

import com.example.paint.assets.Config;
import com.example.paint.assets.Matrix;
import com.example.paint.assets.Transformation;
import com.example.paint.paint.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Dot extends Rectangle {

    public double[] coordinates;
    public double stroke;
    public Color color;
    public String name;

    public Dot(double[] coordinates) {
        this(coordinates[0], coordinates[1]);
    }

    public Dot(double x, double y) {
        this(x, y, Config.defaultStroke, Config.defaultColor);
    }

    public Dot(double[] coordinates, double strokeWidth) {
        this(coordinates[0], coordinates[1], strokeWidth);
    }

    public Dot(double x, double y, double strokeWidth) {
        this(x, y, strokeWidth, Config.defaultColor);
    }

    public Dot(double[] coordinates, Color color) {
        this(coordinates[0], coordinates[1], color);
    }

    public Dot(double x, double y, Color color) {
        this(x, y, Config.defaultStroke, color);
    }

    public Dot(double[] coordinates, double strokeWidth, Color color) {
        this(coordinates[0], coordinates[1], strokeWidth, color);
    }

    public Dot(double x, double y, double strokeWidth, Color color) {
        this.setX(x);
        this.setY(y);
        this.setHeight(strokeWidth);
        this.setWidth(strokeWidth);
        this.setFill(color);
        this.coordinates = new double[] {x, y, 1};
        this.name = "Dot" + Config.dotCount;
        this.color = color;

        this.setOnMouseClicked(event -> onClick());

        Config.dots.add(this);
        Config.dotCount++;
    }

    // listeners
    public void onClick() {
        select();
    }

    public void setStroke(double stroke) {
        this.setHeight(stroke);
        this.setWidth(stroke);
        this.stroke = stroke;
    }

    public void select() {
        Dot selectedDot = Config.selectedDot;
        if (selectedDot != null) {
            selectedDot.unselect();
        }
        if (selectedDot != this) {
            Config.selectedDot = this;
            this.setFill(Config.selectedColor);
        }
    }

    public void unselect() {
        this.setFill(color);
        Config.selectedDot = null;
    }

    public void refresh() {
        this.setX(coordinates[0]);
        this.setY(coordinates[1]);
    }

    // operations

    // translate
    public void translate(double dx, double dy) {
        coordinates = Matrix.multiply(coordinates, Transformation.translate(dx, dy));
        refresh();
    }

    public void translate(double dxy) {
        translate(dxy, dxy);
    }

    // rotate
    public void rotate(double theta) {
        coordinates = Matrix.multiply(coordinates, Transformation.rotate(theta));
        refresh();
    }

    public void rotate(double[] pivot, double theta) {
        rotate(pivot[0], pivot[1], theta);
    }

    public void rotate(double x, double y, double theta) {
        coordinates = Matrix.multiply(coordinates, Transformation.translate(-x, -y));
        coordinates = Matrix.multiply(coordinates, Transformation.rotate(theta));
        coordinates = Matrix.multiply(coordinates, Transformation.translate(x, y));
        refresh();
    }

    // scale
    public void scale(double sx, double sy) {
        coordinates = Matrix.multiply(coordinates, Transformation.scale(sx, sy));
        refresh();
    }

    public void scale(double s) {
        scale(s, s);
    }

    public void scale(double[] pivot, double s) {
        scale(pivot, s, s);
    }

    public void scale(double x, double y, double s) {
        scale(x, y, s, s);
    }

    public void scale(double[] pivot, double sx, double sy) {
        scale(pivot[0], pivot[1], sx, sy);
    }

    public void scale(double x, double y, double sx, double sy) {
        coordinates = Matrix.multiply(coordinates, Transformation.translate(-x, -y));
        coordinates = Matrix.multiply(coordinates, Transformation.scale(sx, sy));
        coordinates = Matrix.multiply(coordinates, Transformation.translate(x, y));
        refresh();
    }

    public void moveTo(double x, double y) {
        coordinates[0] = x;
        coordinates[1] = y;
        refresh();
    }

    public String toString() {
        return name;
    }
}
