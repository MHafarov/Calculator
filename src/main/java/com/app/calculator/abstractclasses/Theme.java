package com.app.calculator.abstractclasses;

import javafx.scene.control.Menu;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public abstract class Theme {
    protected String nameTheme;
    protected String textColor = "-fx-text-fill: rgb(12, 13, 13);";
    protected String backgroundColor = "-fx-background-color: rgb(158, 163, 163);";
    protected String style =  backgroundColor + textColor;
    protected Color color = Color.rgb(167, 171, 171);
    public String getStyle() {
        return style = backgroundColor  + textColor;
    }

    public void chooseTheme(Window window, Theme theme) {
        for (int i = 0; i < window.list_Buttons.size(); i++) {
            window.list_Buttons.get(i).setStyle(theme.getStyle());
        }

        BackgroundFill backgroundFill = new BackgroundFill(color, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);

        window.root.setBackground(background);
        window.menuBar.setStyle(theme.getStyle());

        for (int i = 0; i < window.list_ElementsRoundingTop.size(); i++) {
            window.list_ElementsRoundingTop.get(i).setStyle(theme.getStyle());
        }
        window.label_TypeRounding.setStyle(theme.getStyle());
        window.label_ScaleRounding.setStyle(theme.getStyle());

    };
}

