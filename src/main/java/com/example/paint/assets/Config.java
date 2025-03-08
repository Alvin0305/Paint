package com.example.paint.assets;

import com.example.paint.paint.canvas.Canvas;
import com.example.paint.paint.shapes.Dot;
import com.example.paint.paint.shapes.Shape;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Config {

    // Components
    public static Canvas canvas;

    // Global
    public static Shape selectedShape = Shape.DOT;
    public static Shape selectedDrawShape = Shape.DOT;

    // Dot
    public static double defaultStroke = 5;
    public static Color defaultColor = Color.BLACK;
    public static ArrayList<Dot> dots = new ArrayList<>();
    public static int dotCount = 0;
    public static Color selectedColor = Color.GREEN;
    public static Dot selectedDot;

    // Side Bar
    public static double sideBarWidth = 200;
}
