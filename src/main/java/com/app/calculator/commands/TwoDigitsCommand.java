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
        String output_String = null;


        switch (source_String) {
            case "÷":
                if (cashFull() & input_String.equals("0")) {
                    output_String = "Деление на ноль невозможно";
                    window.getCashTwoNumberOperations().clearCash();
                    window.getCashEquelOperation().clearCash();
                    break;
                }
                if (cashFull() & !input_String.equals("0")) {
                    output_BigDecimal = window.getCashTwoNumberOperations().getCashDigit().divide(input_BigDecimal);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumberOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashEmpty()) {
                    window.getCashTwoNumberOperations().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "╳":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoNumberOperations().getCashDigit());
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumberOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashEmpty()) {
                    window.getCashTwoNumberOperations().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "-":
                if (cashFull()) {
                    output_BigDecimal = window.getCashTwoNumberOperations().getCashDigit().subtract(input_BigDecimal);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumberOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashEmpty()) {
                    window.getCashTwoNumberOperations().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "+":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoNumberOperations().getCashDigit());
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumberOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashEmpty()) {
                    window.getCashTwoNumberOperations().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;

            default:
                System.out.println("switch TwoDigitsCommand Error");
        }

        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
    public boolean cashFull() {
        if (window.getCashTwoNumberOperations().getCashDigit() != null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean cashEmpty() {
        if (window.getCashTwoNumberOperations().getCashDigit() == null) {
            return true;
        } else {
            return false;
        }
    }
}