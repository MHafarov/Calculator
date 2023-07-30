package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;

public class PercentCommand extends Command{
    public PercentCommand(Window window, ActionEvent event) {
        super(window, event);
    }
    @Override
    public boolean execute() {
        save_PreviousNumber();
        save_CurrentNumber();

        window.displayField.setText(getNumber_Current());
        return true;
    }
}