package com.example.paint.paint;

import com.example.paint.assets.Config;
import com.example.paint.paint.canvas.Canvas;
import com.example.paint.paint.ribbon.Ribbon;
import com.example.paint.paint.shapes.Triangle;
import com.example.paint.paint.sidebar.SideBar;
import javafx.scene.layout.BorderPane;

public class Paint extends BorderPane {
    SideBar sideBar = new SideBar();
    Ribbon ribbon = new Ribbon();
    Canvas canvas = new Canvas();

    public Paint() {

        Config.canvas = canvas;

//        new Line(50, 100, 200, 300);
        new Triangle(10, 100, 10, 10, 100, 100);

        this.setTop(ribbon);
        this.setCenter(canvas);
        this.setLeft(sideBar);
    }
}
