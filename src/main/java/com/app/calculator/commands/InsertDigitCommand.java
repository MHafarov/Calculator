package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;

public class InsertDigitCommand extends Command {
    public InsertDigitCommand(Window window, ActionEvent event) {
        super(window, event);
    }
    @Override
    public boolean execute() {
        window.checkDigit;


        return false;
    }
}
