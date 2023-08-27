package com.app.calculator.abstractclasses;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public abstract class Theme {
    protected String nameTheme;
    protected Color textColor;
    protected String backgroundColor;
    public Color getTextColor() {
        return textColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void chooseButtonsTheme(Window window, Theme theme) {
        for (int i = 0; i < window.list_Buttons.size(); i++) {
            window.list_Buttons.get(i).setTextFill(theme.getTextColor());
            window.list_Buttons.get(i).setStyle(theme.getBackgroundColor());
        }
    };
}

