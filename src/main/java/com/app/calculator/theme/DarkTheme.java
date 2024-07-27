package com.app.calculator.theme;

import com.app.calculator.abstractclasses.Theme;
import com.app.calculator.abstractclasses.Window;
import javafx.scene.paint.Color;

public class DarkTheme extends Theme {
    public DarkTheme(Window window) {
        this.window = window;
        nameTheme = "DarkTheme";
        backgroundColorStart = "-fx-background-color: rgb(59, 61, 61);";
        textColor = "-fx-text-fill: rgb(138, 194, 194);";
        color = Color.rgb(71, 74, 74);
        chooseTheme(this.window, this);
   }
}
