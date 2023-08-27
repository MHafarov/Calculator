package com.app.calculator.abstractclasses;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public abstract class Theme {
    protected String nameTheme;
    protected String textColor = "-fx-text-fill: black";
    protected String backgroundColor = "-fx-background-color: lightgray;";

    protected String style =  backgroundColor + textColor;

    public String getStyle() {
        return style = backgroundColor  + textColor;
    }

    public void chooseButtonsTheme(Window window, Theme theme) {
        for (int i = 0; i < window.list_Buttons.size(); i++) {
            window.list_Buttons.get(i).setStyle(theme.getStyle());
        }
    };
}

