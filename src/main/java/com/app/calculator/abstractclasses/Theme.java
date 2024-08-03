package com.app.calculator.abstractclasses;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class Theme {
    public Window window;
    protected String nameTheme;
    protected String textColor = "-fx-text-fill: rgb(12, 13, 13);";
    protected String backgroundColorStart = "-fx-background-color: rgb(158, 163, 163);";
    protected String style =  backgroundColorStart + textColor;
    protected Color color = Color.rgb(167, 171, 171);
    protected Color colorStart = Color.BLUE;
    protected Color colorEnd = Color.GREEN;
    public String getStyle() {
        return style = backgroundColorStart + textColor;
    }
    public boolean isThemeAnimated = false;

    public void chooseTheme(Window window, Theme theme) {

        for (int i = 0; i < window.list_MenuLables.size(); i++) {
            window.list_MenuLables.get(i).setStyle(theme.textColor);
        }

        for (int i = 0; i < window.list_ElementsRoundingTop.size(); i++) {
            window.list_ElementsRoundingTop.get(i).setStyle(theme.textColor);
        }
        for (int i = 0; i < window.list_TypeScaleRounding.size(); i++) {
            window.list_TypeScaleRounding.get(i).setStyle(theme.textColor);
        }

        for (int i = 0; i < window.list_Buttons.size(); i++) {
            window.list_Buttons.get(i).setStyle(theme.getStyle());
        }


        if (isThemeAnimated) {

            Timeline timeline = new Timeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.setAutoReverse(true);


            for (Button button : window.list_Buttons) {
                applyBackgroundAnimation(button, colorStart, colorEnd, timeline);
                button.setStyle(
                        "-fx-background-color: transparent; " +
                                "-fx-border-color: black; " +
                                "-fx-border-width: 2px; " +
                                "-fx-border-radius: 5px; " +
                                textColor
                );
            }

            for (Label label : window.list_TypeScaleRounding) {
                applyBackgroundAnimation(label, colorStart, colorEnd, timeline);
            }
            for (Label label : window.list_ElementsRoundingTop) {
                applyBackgroundAnimation(label, colorStart, colorEnd, timeline);
            }
            for (Label label : window.list_MenuLables) {
                applyBackgroundAnimation(label, colorStart, colorEnd, timeline);
            }
            applyBackgroundAnimation(window.root, colorStart, colorEnd, timeline);
            applyBackgroundAnimation(window.menuBar, colorStart, colorEnd, timeline);


            // Запускаем анимацию один раз для всех кнопок
            timeline.play();


        } else {BackgroundFill backgroundFill = new BackgroundFill(color, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
            Background background = new Background(backgroundFill);
            window.root.setBackground(background);
            window.menuBar.setBackground(background);

        }


    }
    public static <T extends Region> void applyBackgroundAnimation(T region, Color colorStart, Color colorEnd, Timeline timeline) {
        final ObjectProperty<Color> color = new SimpleObjectProperty<>(colorStart);
        color.addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> obs, Color oldColor, Color newColor) {
                BackgroundFill backgroundFill = new BackgroundFill(newColor, CornerRadii.EMPTY, Insets.EMPTY);
                region.setBackground(new Background(backgroundFill));
            }
        });

        KeyValue kvStart = new KeyValue(color, colorStart);
        KeyValue kvEnd = new KeyValue(color, colorEnd);
        KeyFrame kfStart = new KeyFrame(Duration.ZERO, kvStart);
        KeyFrame kfEnd = new KeyFrame(Duration.seconds(8), kvEnd);

        timeline.getKeyFrames().addAll(kfStart, kfEnd);
    }
}

