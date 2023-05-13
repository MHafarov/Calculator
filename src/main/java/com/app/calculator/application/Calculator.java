package com.app.calculator.application;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.windows.ArithmeticWindow;
import com.app.calculator.windows.ConvertionWindow;
import com.app.calculator.windows.TrigonometricWindow;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Calculator extends Application {
    @Override
    public void start(Stage hiddenStage) {

        List<Window> windows = new ArrayList<>();

        Window arithmeticWindow = new ArithmeticWindow(new Stage());
        Window trigonometricWindow = new TrigonometricWindow(new Stage());
        Window convertionWindow = new ConvertionWindow(new Stage());

        windows.add(arithmeticWindow);
        windows.add(trigonometricWindow);
        windows.add(convertionWindow);

        windows.stream().forEach(window -> new Thread(window).start());
    }
}