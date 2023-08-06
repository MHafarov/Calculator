package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.windowsCollection.WindowCollection;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CheckMenuItemCommand extends Command {
    public CheckMenuItemCommand(Window window, ActionEvent event) {
        super(window, event);
    }
    CheckMenuItem cMI_input = (CheckMenuItem) event.getSource();
    String cMI_name = cMI_input.getText();
    List<Window> list_windows = WindowCollection.getList_windows();

    @Override
    public boolean execute() {
        switch (cMI_name) {
            case "Arithmetic":
                window.cMI_ArithmeticWindow.setSelected(true);
                window.cMI_TrigonometricWindow.setSelected(false);
                window.cMI_ConvertionWindow.setSelected(false);
                System.out.println("A");
                for (int i = 0; i < list_windows.size(); i++) {
                    if
                }
                break;
            case "Trigonometric":
                window.cMI_ArithmeticWindow.setSelected(false);
                window.cMI_TrigonometricWindow.setSelected(true);
                window.cMI_ConvertionWindow.setSelected(false);
                System.out.println("T");
                break;
            case "Convertion":
                window.cMI_ArithmeticWindow.setSelected(false);
                window.cMI_TrigonometricWindow.setSelected(false);
                window.cMI_ConvertionWindow.setSelected(true);
                System.out.println("C");
                break;

            default:
                System.out.println("switch CheckMenuItemCommand Error");
        }
        return true;
    }
}
