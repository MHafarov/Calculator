package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ConvertionWindow extends Window{
    public ConvertionWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            stage.setTitle("title");
            StackPane root = new StackPane();
            Scene scene = new Scene(root, 400, 400);
            stage.setScene(scene);

            //stage.show();
        });
    }
}