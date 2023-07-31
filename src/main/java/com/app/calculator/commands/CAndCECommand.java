package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CAndCECommand extends Command {
    public CAndCECommand(Window window, ActionEvent event) {
        super(window, event);
    }
    @Override
    public boolean execute() {
        save_PreviousNumber();

        Button source = getSource(event);
        String source_String = source.getText();

        setNumber_Current("0");

        switch (source_String) {
            case "C":
                window.getCashTwoNumbersOperations().clearCash();
                window.getCashEquelOperation().clearCash();
                break;

            case "CE":
                break;
        }
            window.displayField.setText(getNumber_Current());
        return true;
    }
}