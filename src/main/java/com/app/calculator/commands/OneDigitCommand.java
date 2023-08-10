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
                    output_BigDecimal = BigDecimalDigit.ONE.getNumber().divide(input_BigDecimal);
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
            case "sin":
                break;
            case "cos":
                break;
            case "tan":
                break;
            case "log":
                break;
            case "sin^(-1)":
                break;
            case "cos^(-1)":
                break;
            case "tan^(-1)":
                break;
            case "ln":
                break;
            case "x^3":
                break;
            case "Exp":
                break;
            case "Mod":
                break;
            case "π":
                break;
            case "n!":
                break;
            default:
                System.out.println("switch OneDigitCommand Error");
        }

        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
        String output_String = toString(output_BigDecimal);
        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}
