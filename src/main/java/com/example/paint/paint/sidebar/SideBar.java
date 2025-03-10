package com.example.paint.paint.sidebar;

import com.example.paint.assets.Config;
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
import javafx.scene.layout.VBox;

public class SideBar extends VBox {

    public SideBar() {
        DrawDotOption drawDotOption = new DrawDotOption();
        DrawLineOption drawLineOption = new DrawLineOption();
        DrawTriangleOption drawTriangleOption = new DrawTriangleOption();

        TranslateDotOption translateDotOption = new TranslateDotOption();
        TranslateLineOption translateLineOption = new TranslateLineOption();
        TranslateShapeOption translateShapeOption = new TranslateShapeOption();

        ScaleDotOption scaleDotOption = new ScaleDotOption();
        ScaleLineOption scaleLineOption = new ScaleLineOption();
        ScaleShapeOption scaleShapeOption = new ScaleShapeOption();

        RotateDotOption rotateDotOption = new RotateDotOption();
        RotateLineOption rotateLineOption = new RotateLineOption();
        RotateShapeOption rotateShapeOption = new RotateShapeOption();

        MoveDotOption moveDotOption = new MoveDotOption();
        MoveLineOption moveLineOption = new MoveLineOption();
        MoveShapeOption moveShapeOption = new MoveShapeOption();

        Config.drawDotOption = drawDotOption;
        Config.drawLineOption = drawLineOption;
        Config.drawTriangleOption = drawTriangleOption;

        Config.translateDotOption = translateDotOption;
        Config.translateLineOption = translateLineOption;
        Config.translateShapeOption = translateShapeOption;

        Config.scaleDotOption = scaleDotOption;
        Config.scaleLineOption = scaleLineOption;
        Config.scaleShapeOption = scaleShapeOption;

        Config.rotateDotOption = rotateDotOption;
        Config.rotateLineOption = rotateLineOption;
        Config.rotateShapeOption = rotateShapeOption;

        Config.moveDotOption = moveDotOption;
        Config.moveLineOption = moveLineOption;
        Config.moveShapeOption = moveShapeOption;

        this.getChildren().addAll(drawDotOption);
        this.setPrefWidth(Config.sideBarWidth);

        Config.sideBar = this;
    }
}
