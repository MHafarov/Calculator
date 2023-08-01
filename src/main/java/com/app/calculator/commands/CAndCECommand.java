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
                window.getCashTwoDigits().clearCash();
                window.getCashEquel().clearCash();
                window.getHistory().clearHistory();
                break;

            case "CE":
                window.displayField.setText("0");
                if (window.getHistory().history.get(window.getHistory().history.size()-3).getTextCommand() ==
                        this.getTextCommand()) {
                    window.getHistory().history.remove(window.getHistory().history.size()-3);
                    window.getHistory().currentIndex -= 1;
                }
                break;
        }
            window.displayField.setText(getNumber_Current());
        return true;
    }
}