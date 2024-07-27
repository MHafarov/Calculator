package com.app.calculator.theme;

import com.app.calculator.abstractclasses.Theme;
import com.app.calculator.abstractclasses.Window;
import javafx.scene.paint.Color;

public class AnimatedTheme extends Theme {
    public AnimatedTheme(Window window) {
        this.window = window;
        nameTheme = "DarkTheme";
        backgroundColorStart = "-fx-background-color: rgba(0, 0, 0, 0.8);";
        textColor = "-fx-text-fill: red;";
        color = Color.rgb(71, 74, 74);
        isThemeAnimated = true;
        chooseTheme(this.window, this);
    }
}