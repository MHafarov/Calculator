package com.app.calculator.abstractclasses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public abstract class Window extends Application {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Сохраняем ссылку на основной Stage
        stage = primaryStage;

        // Создаем корневой узел с пустым содержимым
        StackPane root = new StackPane();

        // Создаем сцену
        Scene scene = new Scene(root, 400, 300);

        // Устанавливаем сцену на окно
        stage.setScene(scene);
    }


    public void showWindow(){
        // Запускаем окно в отдельном потоке
        Thread thread = new Thread(() -> {
            // Показываем окно
            stage.show();
        });
        thread.start();
    }

}
