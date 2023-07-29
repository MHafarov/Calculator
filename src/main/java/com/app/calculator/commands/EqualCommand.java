package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;

import java.math.BigDecimal;

public class EqualCommand extends Command {
    public EqualCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        save_PreviousNumber();
        String input_String = getNumber_Previous();
        BigDecimal input_BigDecimal = toBigDecimal(input_String);

        String cash_String = window.getCashTwoNumberOperations().getCashCommandText();

        BigDecimal output_BigDecimal = null;

        System.out.println("H " + window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand());

        if (equalWasPressedBefore()) {
            cash_String = window.getCashEquelOperation().getCashCommandText();
            System.out.println(cash_String);
        }



        switch (cash_String) {
            case "÷":
                if (cashFull() & input_String == "0") {
                    setNumber_Current("Деление на ноль невозможно");
                    window.displayField.setText(getNumber_Current());
                }
                if (cashFull() & input_String != "0") {
                    output_BigDecimal = window.getCashTwoNumberOperations().getCashDigit().divide(input_BigDecimal);
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashEmpty()) {
                    output_BigDecimal = input_BigDecimal.divide(window.getCashEquelOperation().getCashDigit());
                }
                break;

            case "╳":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoNumberOperations().getCashDigit());
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashEmpty()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashEquelOperation().getCashDigit());
                }
                break;

            case "-":
                if (cashFull()) {
                    output_BigDecimal = window.getCashTwoNumberOperations().getCashDigit().subtract(input_BigDecimal);
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashEmpty()) {
                    output_BigDecimal = input_BigDecimal.subtract(window.getCashEquelOperation().getCashDigit());
                }
                break;

            case "+":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoNumberOperations().getCashDigit());
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashEmpty()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashEquelOperation().getCashDigit());
                }
                break;
            default:
                System.out.println("switch TwoDigitsCommand Error");
        }

        String output_String = toString(output_BigDecimal);
        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        window.getCashTwoNumberOperations().clearCash();
        return true;
    }

    public boolean equalWasPressedBefore() {
        if (window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand() == "="
                & (window.getCashEquelOperation().getCashCommandText() == "÷" |
                window.getCashEquelOperation().getCashCommandText() == "╳" |
                window.getCashEquelOperation().getCashCommandText() == "-" |
                window.getCashEquelOperation().getCashCommandText() == "+" )) {
            return true;
        } else {
            return false;
        }
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