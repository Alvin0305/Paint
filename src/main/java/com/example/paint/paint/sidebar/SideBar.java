package com.example.paint.paint.sidebar;

import com.example.paint.assets.Config;
import javafx.scene.layout.VBox;

public class SideBar extends VBox {

    public SideBar() {
        this.getChildren().addAll(new DrawOption(), new TranslateOption(), new ScaleOption(), new RotateOption(), new MoveOption());
        this.setPrefWidth(Config.sideBarWidth);
    }
}
