package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.windowsCollection.WindowCollection;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckMenuItem;

public class SelectCalculatorTypeCommand extends Command {
    Window currentWindow;
    public SelectCalculatorTypeCommand(Window window, ActionEvent event) {
        super(window, event);
        currentWindow = window;
    }
    CheckMenuItem cMI_input = (CheckMenuItem) event.getSource();
    String cMI_name = cMI_input.getText();

    @Override
    public boolean execute() {
        switch (cMI_name) {
            case "Arithmetic":
                showArithmeticWindow();
                break;
            case "Арифметичний":
                showArithmeticWindow();
                break;
            case "Арифметический":
                showArithmeticWindow();
                break;
            case "Trigonometric":
                showTrigonometricWindow();
                break;
            case "Тригонометричний":
                showTrigonometricWindow();
                break;
            case "Тригонометрический":
                showTrigonometricWindow();
                break;
            case "Convertion":
                showConvertionWindow();
                break;
            case "Переведення одиниць":
                showConvertionWindow();
                break;
            case "Перевод единиц":
                showConvertionWindow();
                break;
            default:
                System.out.println("switch CheckMenuItemCommand Error");
        }
        return true;
    }
    private void showArithmeticWindow() {
        window.cMI_ArithmeticWindow.setSelected(true);
        window.cMI_TrigonometricWindow.setSelected(false);
        window.cMI_ConvertionWindow.setSelected(false);
        WindowCollection.turnOnWindow("Arithmetic", currentWindow.stage.getX(),currentWindow.stage.getY());
        System.out.println("A");
    }
    private void showTrigonometricWindow() {
        window.cMI_ArithmeticWindow.setSelected(false);
        window.cMI_TrigonometricWindow.setSelected(true);
        window.cMI_ConvertionWindow.setSelected(false);
        WindowCollection.turnOnWindow("Trigonometric", currentWindow.stage.getX(),currentWindow.stage.getY());
        System.out.println("T");
    }
    private void showConvertionWindow() {
        window.cMI_ArithmeticWindow.setSelected(false);
        window.cMI_TrigonometricWindow.setSelected(false);
        window.cMI_ConvertionWindow.setSelected(true);
        WindowCollection.turnOnWindow("Convertion", currentWindow.stage.getX(),currentWindow.stage.getY());
        System.out.println("C");
    }
}
