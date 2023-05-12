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
    public void start(Stage hiddenStage) throws Exception {

        List<Window> windows = new ArrayList<Window>();

        ArithmeticWindow aW = new ArithmeticWindow();
        TrigonometricWindow tW = new TrigonometricWindow();
        ConvertionWindow cW = new ConvertionWindow();

        windows.add(aW);
        windows.add(tW);
        windows.add(cW);

        for (int i=0; i < windows.size(); i++ ) {
            windows.get(i).showWindow();
        }
    }
}