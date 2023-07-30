package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;

public class PercentCommand extends Command {
    public PercentCommand(Window window, ActionEvent event) {
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
        String output_String = null;

        System.out.println("% cash " + window.getCashTwoNumberOperations().getCashCommandText());

        if (cashTwoNumberEmpty()) {
            output_String = "0";
        }
        if (window.getCashTwoNumberOperations().getCashCommandText() == "+") {
            output_BigDecimal = (window.getCashTwoNumberOperations().getCashDigit().divide(new BigDecimal(100)))
                    .multiply(input_BigDecimal);
            output_String = toString(output_BigDecimal);
            System.out.println("+");
        }

        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}
