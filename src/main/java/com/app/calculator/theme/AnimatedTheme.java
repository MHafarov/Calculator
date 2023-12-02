package com.app.calculator.theme;

import com.app.calculator.abstractclasses.Theme;
import com.app.calculator.abstractclasses.Window;

public class AnimatedTheme extends Theme {
    Window window;
    public AnimatedTheme(Window window) {
        this.window = window;
        nameTheme = "DarkTheme";
        backgroundColor = "-fx-background-color: rgba(0, 0, 0, 0.8);";
        textColor = "-fx-text-fill: red;";
        chooseTheme(this.window, this);
    }
}