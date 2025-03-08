package com.example.paint.paint;

import com.example.paint.assets.Config;
import com.example.paint.paint.canvas.Canvas;
import com.example.paint.paint.ribbon.Ribbon;
import com.example.paint.paint.sidebar.SideBar;
import javafx.scene.layout.BorderPane;

public class Paint extends BorderPane {
    Ribbon ribbon = new Ribbon();
    SideBar sideBar = new SideBar();
    Canvas canvas = new Canvas();

    public Paint() {

        Config.canvas = canvas;

        this.setTop(ribbon);
        this.setCenter(canvas);
        this.setLeft(sideBar);
    }
}
