package com.example.paint.assets;

import com.example.paint.paint.canvas.Canvas;
import com.example.paint.paint.shapes.*;
import com.example.paint.paint.sidebar.*;
import com.example.paint.paint.sidebar.details.DotDetails;
import com.example.paint.paint.sidebar.details.LineDetails;
import com.example.paint.paint.sidebar.details.TriangleDetails;
import com.example.paint.paint.sidebar.draw.DrawDotOption;
import com.example.paint.paint.sidebar.draw.DrawLineOption;
import com.example.paint.paint.sidebar.draw.DrawTriangleOption;
import com.example.paint.paint.sidebar.move.MoveDotOption;
import com.example.paint.paint.sidebar.move.MoveLineOption;
import com.example.paint.paint.sidebar.move.MoveShapeOption;
import com.example.paint.paint.sidebar.rotate.RotateDotOption;
import com.example.paint.paint.sidebar.rotate.RotateLineOption;
import com.example.paint.paint.sidebar.rotate.RotateShapeOption;
import com.example.paint.paint.sidebar.scale.ScaleDotOption;
import com.example.paint.paint.sidebar.scale.ScaleLineOption;
import com.example.paint.paint.sidebar.scale.ScaleShapeOption;
import com.example.paint.paint.sidebar.translate.TranslateDotOption;
import com.example.paint.paint.sidebar.translate.TranslateLineOption;
import com.example.paint.paint.sidebar.translate.TranslateShapeOption;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Config {

    // Components
    public static Canvas canvas;
    public static SideBar sideBar;

    // options components

        //draw
        public static DrawDotOption drawDotOption;
        public static DrawLineOption drawLineOption;
        public static DrawTriangleOption drawTriangleOption;

        // translate
        public static TranslateDotOption translateDotOption;
        public static TranslateLineOption translateLineOption;
        public static TranslateShapeOption translateShapeOption;

        // scale
        public static ScaleDotOption scaleDotOption;
        public static ScaleLineOption scaleLineOption;
        public static ScaleShapeOption scaleShapeOption;

        // rotate
        public static RotateDotOption rotateDotOption;
        public static RotateLineOption rotateLineOption;
        public static RotateShapeOption rotateShapeOption;

        // move
        public static MoveDotOption moveDotOption;
        public static MoveLineOption moveLineOption;
        public static MoveShapeOption moveShapeOption;

        // details
        public static DotDetails dotDetails;
        public static LineDetails lineDetails;
        public static TriangleDetails triangleDetails;

    // Global
    public static Shape selectedShape = Shape.LINE;
    public static Shape selectedDrawShape = Shape.DOT;

    // Dot
    public static double defaultStroke = 5;
    public static Color defaultColor = Color.BLACK;
    public static ArrayList<Dot> dots = new ArrayList<>();
    public static int dotCount = 0;
    public static Color selectedColor = Color.GREEN;
    public static Dot selectedDot;

    // Line
    public static Line selectedLine;
    public static Color defaultLineColor = Color.BLACK;
    public static double defaultLineWidth = 5;
    public static Color selectedLineColor = Color.RED;
    public static double selectedLineWidth = 8;
    public static int lineCount = 0;

    // Triangle
    public static int triangleCount = 0;
    public static Triangle selectedTriangle;
    public static Color defaultTriangleColor = Color.BLACK;
    public static double defaultTriangleWidth = 5;
    public static double selectedTriangleWidth = 8;
    public static Color selectedTriangleColor = Color.RED;

    // Quadrilateral
    public static int quadrilateralCount = 0;
    public static Quadrilateral selectedQuadrilateral;
    public static Color defaultQuadrilateralColor = Color.BLACK;
    public static double defaultQuadrilateralWidth = 5;
    public static double selectedQuadrilateralWidth = 8;
    public static Color selectedQuadrilateralColor = Color.RED;

    // Side Bar
    public static double sideBarWidth = 200;
}
