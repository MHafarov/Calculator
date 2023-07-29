package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class InsertDigitCommand extends Command {
    public InsertDigitCommand(Window window, ActionEvent event) {
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
