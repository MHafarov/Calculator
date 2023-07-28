package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.BigDecimalDigit;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class OneDigitCommand extends Command {
    public OneDigitCommand(Window window, ActionEvent event) {
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
            case "1/X":
                if (getNumber_Previous().equals("0")) {
                    setNumber_Current("Деление на ноль невозможно");
                    window.displayField.setText(getNumber_Current());
                } else {
                    output_BigDecimal = BigDecimalDigit.ONE.getNumber().divide(input_BigDecimal,8, RoundingMode.HALF_UP);
                }
                break;

            case "X²":
                output_BigDecimal = input_BigDecimal.multiply(input_BigDecimal);
                break;

            case "√":
                if (input_BigDecimal.compareTo(BigDecimalDigit.ZERO.getNumber()) < 0) {
                    setNumber_Current("Введены неверные данные");
                    window.displayField.setText(getNumber_Current());
                } else {
                    output_BigDecimal = input_BigDecimal.sqrt(new MathContext(100));
                }
                break;

            default:
                System.out.println("switch OneDigitCommand Error");
        }

        String output_String = toString(output_BigDecimal);
        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}
