package com.app.calculator.windows;

import com.app.calculator.abstractclasses.Window;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

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

            Button btnMC = new Button("MC");
            Button btnMR = new Button("MR");
            Button btnMPlus = new Button("M+");
            Button btnMMinus = new Button("M-");
            Button btnMS = new Button("MS");
            Button btnM = new Button("M");
            Button btnPercent = new Button("%");
            Button btnSqrt = new Button("√");
            Button btnXSquared = new Button("X²");
            Button btnOneDivX = new Button("1/X");
            Button btnCE = new Button("CE");
            Button btnC = new Button("C");
            Button btnBackspace = new Button("←");
            Button btnDiv = new Button("÷");
            Button btn7 = new Button("7");
            Button btn8 = new Button("8");
            Button btn9 = new Button("9");
            Button btnMult = new Button("╳");
            Button btn4 = new Button("4");
            Button btn5 = new Button("5");
            Button btn6 = new Button("6");
            Button btnMinus = new Button("-");
            Button btn1 = new Button("1");
            Button btn2 = new Button("2");
            Button btn3 = new Button("3");
            Button btnPlus = new Button("+");
            Button btnPlusMinus = new Button("±");
            Button btn0 = new Button("0");
            Button btnComma = new Button(",");
            Button btnEquals = new Button("=");


            stage.show();
        });
    }
}
