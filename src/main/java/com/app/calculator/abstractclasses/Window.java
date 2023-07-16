package com.app.calculator.abstractclasses;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public abstract class Window implements Runnable {
    protected final Stage stage;

    public Window (Stage stage) {
        this.stage = stage;
    }
    @Override
    public void run() {
        Platform.runLater(() -> {


        });
    }
}
