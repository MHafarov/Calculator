package com.app.calculator.application;

import com.app.calculator.abstractclasses.Window;
import com.app.calculator.windows.ArithmeticWindow;
import com.app.calculator.windows.ConvertionWindow;
import com.app.calculator.windows.TrigonometricWindow;
import com.app.calculator.windowsCollection.WindowCollection;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Calculator extends Application {
    public WindowCollection windowCollection = new WindowCollection();
    @Override
    public void start(Stage hiddenStage) {

        Window arithmeticWindow = new ArithmeticWindow(new Stage());
        Window trigonometricWindow = new TrigonometricWindow(new Stage());
        Window convertionWindow = new ConvertionWindow(new Stage());

        windowCollection.add(arithmeticWindow);
        windowCollection.add(trigonometricWindow);
        windowCollection.add(convertionWindow);

        windowCollection.getList_windows().stream().forEach(window -> new Thread(window).start());
        System.out.println("Все три окна запущены");
    }
}