package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.Column;
import com.app.calculator.constants.Dimension;
import com.app.calculator.constants.Position;
import com.app.calculator.constants.Row;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MemoryWindow implements Runnable{
    Stage stage;
    public MemoryWindow(Stage stage) {
        this.stage = stage;
    }
    @Override
    public void run() {
        Platform.runLater(() -> {
            stage.setTitle("Memory Window");
            stage.setX(Position.MEMORY_WINDOW.getHorizontal());
            stage.setY(Position.MEMORY_WINDOW.getVertical());

            GridPane root = new GridPane();

            TextField textField = new TextField();
            textField.setStyle("-fx-alignment: center-right;");
            textField.setText("0");
            GridPane.setHgrow(textField, Priority.ALWAYS);
            GridPane.setVgrow(textField, Priority.ALWAYS);

            root.getChildren().add(textField);
            Scene scene = new Scene(root, Dimension.MEMORY_WINDOW.getWidth(), Dimension.MEMORY_WINDOW.getHeight());
            stage.setScene(scene);
        });
    }
}
