package com.app.calculator.theme;

import com.app.calculator.abstractclasses.Theme;
import com.app.calculator.abstractclasses.Window;
import javafx.scene.paint.Color;

public class ClassicTheme extends Theme {
    Window window;
    public ClassicTheme(Window window) {
        this.window = window;
        nameTheme = "ClassicTheme";
        backgroundColor = "-fx-background-color: lightgray;";
        textColor = "-fx-text-fill: black";

        System.out.println(style);
        chooseButtonsTheme(this.window, this);
    }
}
