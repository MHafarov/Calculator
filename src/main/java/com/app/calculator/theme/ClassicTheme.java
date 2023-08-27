package com.app.calculator.theme;

import com.app.calculator.abstractclasses.Theme;
import com.app.calculator.abstractclasses.Window;
import javafx.scene.paint.Color;

public class ClassicTheme extends Theme {
    Window window;
    public ClassicTheme(Window window) {

        this.window = window;
        nameTheme = "ClassicTheme";
        textColor = Color.BLACK;
        backgroundColor = "-fx-background-color: lightgray;";
        chooseButtonsTheme(this.window, this);
    }
}
