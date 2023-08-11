package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EqualCommand extends Command {
    public EqualCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        save_PreviousNumber();
        System.out.println("PreviousNumber = " + getNumber_Previous());
        String input_String = null;
        String cash_String = window.getCashTwoDigits().getCashCommandText();
        System.out.println("Cash_String = " + cash_String);
        input_Double = toDouble(toBigDecimal(getNumber_Previous()));

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
        input_Double = toDouble(input_BigDecimal);
        BigDecimal output_BigDecimal = null;
        String output_String = null;


        String pr1 = getNumber_Previous();
        String pB1 = window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand();
        String tDC1 = window.getCashTwoDigits().getCashCommandText();
        BigDecimal tDD1 = window.getCashTwoDigits().getCashDigit();
        String eOC1 = window.getCashEquel().getCashCommandText();
        BigDecimal eOD1 = window.getCashEquel().getCashDigit();
        String cr1 = getNumber_Current();

        if (equalWasPressedBefore()) {
            cash_String = window.getCashEquel().getCashCommandText();
            System.out.println(cash_String);
            System.out.println("WasPressed");
        }

        if (cash_String == null) {
            cash_String = "null";
        }


        switch (cash_String) {
            case "÷":
                if (cashTwoNumberFull() & input_String.equals("0")) {
                    output_String = "Деление на ноль невозможно";
                    window.getCashTwoDigits().clearCash();
                    window.getCashEquel().clearCash();
                    break;
                }
                if (cashTwoNumberFull() & input_String != "0") {
                    output_BigDecimal = window.getCashTwoDigits().getCashDigit().divide(input_BigDecimal,Command.scale,Command.roundMode);;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.divide(window.getCashEquel().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "╳":
                if (cashTwoNumberFull()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoDigits().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashEquel().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "-":
                if (cashTwoNumberFull()) {
                    output_BigDecimal = window.getCashTwoDigits().getCashDigit().subtract(input_BigDecimal);
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.subtract(window.getCashEquel().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "+":
                if (cashTwoNumberFull()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoDigits().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashEquel().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "x^y":
                if (cashTwoNumberFull()) {
                    output_BigDecimal = BigDecimal.valueOf(Math.pow(toDouble(window.getCashTwoDigits().getCashDigit()), input_Double));
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = BigDecimal.valueOf(Math.pow(input_Double, toDouble(window.getCashEquel().getCashDigit())));
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "x^(1/y)":
                if (cashTwoNumberFull() & input_String.equals("0")) {
                    output_String = "Деление на ноль невозможно";
                    window.getCashTwoDigits().clearCash();
                    window.getCashEquel().clearCash();
                    break;
                }
                if (cashTwoNumberFull() & input_String != "0") {
                    output_BigDecimal = BigDecimal.valueOf(Math.pow(toDouble(window.getCashTwoDigits().getCashDigit()), 1 / input_Double));
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    System.out.println("cash E " + toDouble(window.getCashEquel().getCashDigit()));
                    System.out.println("input_double " + input_Double);

                    output_BigDecimal = BigDecimal.valueOf(Math.pow(input_Double, 1 / toDouble(window.getCashEquel().getCashDigit())));
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "Exp":
                if (cashTwoNumberFull()) {
                    BigDecimal ten_Number = new BigDecimal(10);
                    input_BigDecimal = ten_Number.pow(input_BigDecimal.intValueExact());

                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoDigits().getCashDigit());

                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "Mod":
                if (cashTwoNumberFull() & input_String.equals("0")) {
                    output_String = "Результат не определен";
                    window.getCashTwoDigits().clearCash();
                    window.getCashEquel().clearCash();
                    break;
                }
                if (cashTwoNumberFull() & input_String != "0") {
                    double dividend = window.getCashTwoDigits().getCashDigit().doubleValue();
                    double divisor = input_BigDecimal.doubleValue();

                    double remainder = dividend - ((int)(dividend / divisor)) * divisor;

                    output_BigDecimal = new BigDecimal(remainder);
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashEquel().setCash(cash_String,input_BigDecimal);
                    System.out.println("CashTwo dividend" + dividend);
                    System.out.println("input_BigDecimal divisor" + divisor);
                    System.out.println("remainder" + remainder);
                }
                if (cashTwoNumberEmpty()) {
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "null":
                output_String = getNumber_Previous();
                System.out.println(output_String);
                break;
            default:
                System.out.println("switch TwoDigitsCommand Error");
        }

        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        window.getCashTwoDigits().clearCash();

        String pr2 = getNumber_Previous();
        String pB2 = window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand();
        String tDC2 = window.getCashTwoDigits().getCashCommandText();
        BigDecimal tDD2 = window.getCashTwoDigits().getCashDigit();
        String eOC2 = window.getCashEquel().getCashCommandText();
        BigDecimal eOD2 = window.getCashEquel().getCashDigit();
        String cr2 = getNumber_Current();

        System.out.println("           Get_Previous   Pressed_button   Cash_TD_Command   Cash_TD_Digit   Cash_E_Command   Cash_E_Digit   Get_Current");
        System.out.println("Before  :       " + pr1 + "             " + pB1 + "                 " + tDC1 +"                 " + tDD1 +"             " + eOC1 +"             "+ eOD1 +"             "+ cr1);
        System.out.println("After   :       " + pr2 + "             " + pB2 + "                 " + tDC2 +"               " + tDD2 +"             " + eOC2 +"             "+ eOD2 +"             "+ cr2);

        return true;
    }

    public boolean equalWasPressedBefore() {
        if (window.getHistory().history.get(window.getHistory().history.size()-3).getTextCommand() == "="
                & (window.getCashEquel().getCashCommandText() == "÷" |
                window.getCashEquel().getCashCommandText() == "╳" |
                window.getCashEquel().getCashCommandText() == "-" |
                window.getCashEquel().getCashCommandText() == "+" |
                window.getCashEquel().getCashCommandText() == "x^y" |
                window.getCashEquel().getCashCommandText() == "x^(1/y)" |
                window.getCashEquel().getCashCommandText() == "Mod" |
                window.getCashEquel().getCashCommandText() == "Exp")) {
            return true;
        } else {
            return false;
        }
    }
}