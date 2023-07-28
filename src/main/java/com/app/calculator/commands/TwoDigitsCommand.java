package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;

public class TwoDigitsCommand extends Command {
    public TwoDigitsCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        save_PreviousNumber();
        String input_String = getNumber_Previous();
        BigDecimal input_BigDecimal = toBigDecimal(input_String);

        Button source = getSource(event);
        String source_String = source.getText();

        BigDecimal output_BigDecimal = null;


        switch (source_String) {
            case "÷":
                break;

            case "╳":
                break;

            case "-":
                break;

            case "+":
                if (window.getCash().getCashDigit() == null) {
                    window.getCash().setCashDigit(input_BigDecimal);
                }
                if (window.getCash().getCashDigit() != null) {
                    output_BigDecimal = input_BigDecimal.add(window.getCash().getCashDigit());
                    window.getCash().setCashDigit(output_BigDecimal);
                }

                break;

            default:
                System.out.println("switch TwoDigitsCommand Error");
        }

        String output_String = toString(output_BigDecimal);
        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}