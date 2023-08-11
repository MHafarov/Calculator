package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CategoryCommand extends Command {
    Window currentWindow;
    public CategoryCommand() {
        super();
        currentWindow = window;
    }
    @Override
    public boolean execute() {
        currentWindow.stage.close();
        System.out.println("E");
        System.exit(0);
        return true;
    }
}