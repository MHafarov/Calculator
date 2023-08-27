package com.app.calculator.theme;

import com.app.calculator.abstractclasses.Theme;
import com.app.calculator.abstractclasses.Window;
import javafx.scene.paint.Color;

public class AnimatedTheme extends Theme {
    Window window;
    public AnimatedTheme(Window window) {
        this.window = window;
        nameTheme = "DarkTheme";
        textColor = Color.WHITE;
        backgroundColor = "-fx-background-color: black;";
        chooseButtonsTheme(this.window, this);
    }
}