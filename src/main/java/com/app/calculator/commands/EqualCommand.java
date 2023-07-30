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
        System.out.println("PreviousNumber = " + getNumber_Previous());
        String input_String = null;
        String cash_String = window.getCashTwoNumberOperations().getCashCommandText();
        System.out.println("Cash_String = " + cash_String);

        if (getNumber_Previous().equals("Деление на ноль невозможно") |
                (allCashIsEmpty() & !getNumber_Previous().equals("Деление на ноль невозможно"))) {
            input_String = "0";
            cash_String = "null";
        } else {
            input_String = getNumber_Previous();
        }

        if (window.getHistory().history.get(window.getHistory().history.size()-3).getTextCommand() == "CE") {
            input_String = "0";
        }
        BigDecimal input_BigDecimal = toBigDecimal(input_String);

        if (window.getCashTwoNumberOperations().getCashCommandText() == null) {
            window.getCashTwoNumberOperations().setCash(window.getCashEquelOperation().getCashCommandText(), new BigDecimal("0"));
            cash_String = window.getCashTwoNumberOperations().getCashCommandText();
            input_BigDecimal = window.getCashEquelOperation().getCashDigit();
        }

        BigDecimal output_BigDecimal = null;
        String output_String = null;

        System.out.println("Start");
        System.out.println("Pressed button " + window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand());
        System.out.println("Cash TwoDigit Command " + window.getCashTwoNumberOperations().getCashCommandText());
        System.out.println("Cash TwoDigit Digit " + window.getCashTwoNumberOperations().getCashDigit());
        System.out.println("Cash Equal Command " + window.getCashEquelOperation().getCashCommandText());
        System.out.println("Cash Equal " + window.getCashEquelOperation().getCashDigit());
        System.out.println("Start");


        if (equalWasPressedBefore()) {
            cash_String = window.getCashEquelOperation().getCashCommandText();
            System.out.println(cash_String);
            System.out.println("WasPressed");
        }

        switch (cash_String) {
            case "÷":
                if (cashTwoNumberFull() & input_String.equals("0")) {
                    output_String = "Деление на ноль невозможно";
                    window.getCashTwoNumberOperations().clearCash();
                    window.getCashEquelOperation().clearCash();
                    break;
                }
                if (cashTwoNumberFull() & input_String != "0") {
                    output_BigDecimal = window.getCashTwoNumberOperations().getCashDigit().divide(input_BigDecimal);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.divide(window.getCashEquelOperation().getCashDigit());
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "╳":
                if (cashTwoNumberFull()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoNumberOperations().getCashDigit());
                    output_String = toString(output_BigDecimal);
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashEquelOperation().getCashDigit());
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "-":
                if (cashTwoNumberFull()) {
                    output_BigDecimal = window.getCashTwoNumberOperations().getCashDigit().subtract(input_BigDecimal);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.subtract(window.getCashEquelOperation().getCashDigit());
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "+":
                if (cashTwoNumberFull()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoNumberOperations().getCashDigit());
                    output_String = toString(output_BigDecimal);
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashEquelOperation().getCashDigit());
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "null":
                output_String = input_String;
                break;
            default:
                System.out.println("switch TwoDigitsCommand Error");
        }
        System.out.println("End");
        System.out.println("Pressed button " + window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand());
        System.out.println("Cash TwoDigit Command " + window.getCashTwoNumberOperations().getCashCommandText());
        System.out.println("Cash TwoDigit Digit " + window.getCashTwoNumberOperations().getCashDigit());
        System.out.println("Cash Equal Command " + window.getCashEquelOperation().getCashCommandText());
        System.out.println("Cash Equal " + window.getCashEquelOperation().getCashDigit());
        System.out.println("End");

        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        window.getCashTwoNumberOperations().clearCash();
        return true;
    }

    public boolean equalWasPressedBefore() {
        if (window.getHistory().history.get(window.getHistory().history.size()-3).getTextCommand() == "="
                & (window.getCashEquelOperation().getCashCommandText() == "÷" |
                window.getCashEquelOperation().getCashCommandText() == "╳" |
                window.getCashEquelOperation().getCashCommandText() == "-" |
                window.getCashEquelOperation().getCashCommandText() == "+" )) {
            return true;
        } else {
            return false;
        }
    }
}