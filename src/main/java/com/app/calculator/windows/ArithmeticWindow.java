package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ArithmeticWindow extends Window{
    public ArithmeticWindow (Stage stage) {
        super(stage);
    }
    @Override
    public void run() {
        Platform.runLater(() -> {

            this.stage.setTitle("Calculator");
            GridPane root = new GridPane();
            root.setPadding(new Insets(20));
            root.setHgap(25);
            root.setVgap(15);

            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);

            stage.show();
        });
    }
}
