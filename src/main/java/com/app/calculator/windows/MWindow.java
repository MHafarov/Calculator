package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import javafx.application.Platform;
import javafx.stage.Stage;

public class MWindow extends Window {
    public MWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

        });
    }
}
