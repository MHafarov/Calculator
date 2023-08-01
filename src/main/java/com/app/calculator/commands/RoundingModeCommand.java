package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;

public class RoundingModeCommand extends Command {
    public RoundingModeCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        save_PreviousNumber();
        String input_String = getNumber_Previous();
        BigDecimal input_BigDecimal = toBigDecimal(input_String);

        String cash_String = window.getCashTwoDigits().getCashCommandText();

        Button source = getSource(event);
        String source_String = source.getText();

        BigDecimal output_BigDecimal = null;
        String output_String = null;

        System.out.println("% cash " + cash_String);

        if (cashTwoNumberEmpty()) {
            output_String = "0";
        }


        switch (cash_String) {
            case "+":

                break;
            case "-":

                break;
            case "╳":

                break;
            case "÷":

                break;
            default:
                System.out.println("switch RoundingMode Error");
        }

        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}
