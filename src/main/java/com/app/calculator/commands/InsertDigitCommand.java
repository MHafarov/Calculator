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
        String inputString = window.displayField.getText();
        //checkInputString(inputString);

        Button source = getSource(event);
        String outputString = source.getText();
        window.displayField.setText(outputString);

        return true;
    }
}
