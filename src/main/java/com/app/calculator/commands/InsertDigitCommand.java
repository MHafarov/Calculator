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
//        String input_String = getNumber_Previous();
//
//        Button source = getSource(event);
//        String source_String = source.getText();
//
//        String output_String = null;
//
//        if (input_String.equals("0") & source_String.equals("0")  ) {
//
//        }



        save_CurrentNumber();

        window.displayField.setText(getNumber_Current());
        return true;
    }
}
