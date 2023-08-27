package com.app.calculator.theme;

import com.app.calculator.abstractclasses.Theme;
import com.app.calculator.abstractclasses.Window;
import javafx.scene.paint.Color;

public class DarkTheme extends Theme {
    Window window;
    public DarkTheme(Window window) {
        this.window = window;
        nameTheme = "DarkTheme";
        backgroundColor = "-fx-background-color: rgba(0, 0, 0, 0.8);";
        textColor = "-fx-text-fill: red;";
        chooseButtonsTheme(this.window, this);
   }
}
