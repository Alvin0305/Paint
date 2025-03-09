package com.example.paint.paint.sidebar;

import com.example.paint.assets.Config;
import com.example.paint.paint.sidebar.draw.DrawDotOption;
import com.example.paint.paint.sidebar.draw.DrawLineOption;
import com.example.paint.paint.sidebar.move.MoveDotOption;
import com.example.paint.paint.sidebar.move.MoveLineOption;
import com.example.paint.paint.sidebar.rotate.RotateDotOption;
import com.example.paint.paint.sidebar.rotate.RotateLineOption;
import com.example.paint.paint.sidebar.rotate.RotateTriangleOption;
import com.example.paint.paint.sidebar.scale.ScaleDotOption;
import com.example.paint.paint.sidebar.scale.ScaleLineOption;
import com.example.paint.paint.sidebar.translate.TranslateDotOption;
import com.example.paint.paint.sidebar.translate.TranslateLineOption;
import javafx.scene.layout.VBox;

public class SideBar extends VBox {

    public SideBar() {
        DrawDotOption drawDotOption = new DrawDotOption();
        DrawLineOption drawLineOption = new DrawLineOption();

        TranslateDotOption translateDotOption = new TranslateDotOption();
        TranslateLineOption translateLineOption = new TranslateLineOption();

        ScaleDotOption scaleDotOption = new ScaleDotOption();
        ScaleLineOption scaleLineOption = new ScaleLineOption();

        RotateDotOption rotateDotOption = new RotateDotOption();
        RotateLineOption rotateLineOption = new RotateLineOption();
        RotateTriangleOption rotateTriangleOption = new RotateTriangleOption();

        MoveDotOption moveDotOption = new MoveDotOption();
        MoveLineOption moveLineOption = new MoveLineOption();

        Config.drawDotOption = drawDotOption;
        Config.drawLineOption = drawLineOption;

        Config.translateDotOption = translateDotOption;
        Config.translateLineOption = translateLineOption;

        Config.scaleDotOption = scaleDotOption;
        Config.scaleLineOption = scaleLineOption;

        Config.rotateDotOption = rotateDotOption;
        Config.rotateLineOption = rotateLineOption;
        Config.rotateTriangleOption = rotateTriangleOption;

        Config.moveDotOption = moveDotOption;
        Config.moveLineOption = moveLineOption;

        this.getChildren().addAll(drawDotOption);
        this.setPrefWidth(Config.sideBarWidth);

        Config.sideBar = this;
    }
}
