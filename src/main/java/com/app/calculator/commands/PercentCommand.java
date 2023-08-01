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
                output_BigDecimal = (window.getCashTwoDigits().getCashDigit().divide(new BigDecimal(100)))
                        .multiply(input_BigDecimal);
                output_String = toString(output_BigDecimal);
                System.out.println("In Percent +");
                break;
            case "-":
                output_BigDecimal = (window.getCashTwoDigits().getCashDigit().divide(new BigDecimal(100)))
                        .multiply(input_BigDecimal);
                output_String = toString(output_BigDecimal);
                System.out.println("In Percent -");
                break;
            case "╳":
                output_BigDecimal = input_BigDecimal.divide(new BigDecimal(100));
                output_String = toString(output_BigDecimal);
                System.out.println("In Percent ╳");
                break;
            case "÷":
                output_BigDecimal = input_BigDecimal.divide(new BigDecimal(100));
                output_String = toString(output_BigDecimal);
                System.out.println("In Percent ÷");
                break;
            default:
                System.out.println("switch Percent Error");
        }

        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}
