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
        backup();
        String presentText = window.displayField.getText();
        if (presentText.equals("0")) {
            presentText = "";
        }
        //checkInputString(presentText);

        Button source = getSource(event);
        String outputString = source.getText();
        presentText += outputString;
        window.displayField.setText(presentText);

        return true;
    }
}
