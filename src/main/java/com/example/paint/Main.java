package com.example.paint;

import com.example.paint.paint.Paint;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Paint paint = new Paint();
        Scene scene = new Scene(paint, 500, 500);
        stage.setTitle("Paint!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}