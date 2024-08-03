package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Text;
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
    public Stage stage;
    public TextField textField;
    public Text text;
    public MemoryWindow(Stage stage, Text text) {

        this.stage = stage;
        this.text = text;
    }
    @Override
    public void run() {
        Platform.runLater(() -> {
            stage.setTitle(text.memoryWindow);
            stage.setX(Position.MEMORY_WINDOW.getHorizontal());
            stage.setY(Position.MEMORY_WINDOW.getVertical());

            GridPane root = new GridPane();

            textField = new TextField();
            textField.setStyle("-fx-alignment: center-right;");
            textField.setText("");
            GridPane.setHgrow(textField, Priority.ALWAYS);
            GridPane.setVgrow(textField, Priority.ALWAYS);

            root.getChildren().add(textField);
            Scene scene = new Scene(root, Dimension.MEMORY_WINDOW.getWidth(), Dimension.MEMORY_WINDOW.getHeight());
            stage.setScene(scene);
        });
    }
}
