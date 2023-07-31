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
        String cash_String = window.getCashTwoNumbersOperations().getCashCommandText();
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

//        if (window.getCashTwoNumberOperations().getCashCommandText() == null) {
//            window.getCashTwoNumberOperations().setCash(window.getCashEquelOperation().getCashCommandText(), new BigDecimal("0"));
//            cash_String = window.getCashTwoNumberOperations().getCashCommandText();
//            input_BigDecimal = window.getCashEquelOperation().getCashDigit();
//        }

        BigDecimal output_BigDecimal = null;
        String output_String = null;


        String pr1 = getNumber_Previous();
        String pB1 = window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand();
        String tDC1 = window.getCashTwoNumbersOperations().getCashCommandText();
        BigDecimal tDD1 = window.getCashTwoNumbersOperations().getCashDigit();
        String eOC1 = window.getCashEquelOperation().getCashCommandText();
        BigDecimal eOD1 = window.getCashEquelOperation().getCashDigit();
        String cr1 = getNumber_Current();

        if (equalWasPressedBefore()) {
            cash_String = window.getCashEquelOperation().getCashCommandText();
            System.out.println(cash_String);
            System.out.println("WasPressed");
        }

        switch (cash_String) {
            case "÷":
                if (cashTwoNumberFull() & input_String.equals("0")) {
                    output_String = "Деление на ноль невозможно";
                    window.getCashTwoNumbersOperations().clearCash();
                    window.getCashEquelOperation().clearCash();
                    break;
                }
                if (cashTwoNumberFull() & input_String != "0") {
                    output_BigDecimal = window.getCashTwoNumbersOperations().getCashDigit().divide(input_BigDecimal);
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
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoNumbersOperations().getCashDigit());
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
                    output_BigDecimal = window.getCashTwoNumbersOperations().getCashDigit().subtract(input_BigDecimal);
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
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoNumbersOperations().getCashDigit());
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

        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        window.getCashTwoNumbersOperations().clearCash();

        String pr2 = getNumber_Previous();
        String pB2 = window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand();
        String tDC2 = window.getCashTwoNumbersOperations().getCashCommandText();
        BigDecimal tDD2 = window.getCashTwoNumbersOperations().getCashDigit();
        String eOC2 = window.getCashEquelOperation().getCashCommandText();
        BigDecimal eOD2 = window.getCashEquelOperation().getCashDigit();
        String cr2 = getNumber_Current();

//        System.out.println("                         Before         After");
//        System.out.println("Get_Previous         :      " + pr1 + "             " + pr2);
//        System.out.println("Pressed button       :      " + pB1 + "             " + pB2);
//        System.out.println("Cash TwoDigit Command:      "+ tDC1 + "             " + tDC2);
//        System.out.println("Cash TwoDigit Digit  :      "+ tDD1 + "             " + tDD2);
//        System.out.println("Cash Equal Command   :      "+ eOC1 + "             " + eOC2);
//        System.out.println("Cash Equal Digit     :      "+ eOD1 + "             " + eOD2);
//        System.out.println("Get_Current          :      "+ cr1 + "             " + cr2);

        System.out.println("           Get_Previous   Pressed_button   Cash_TD_Command   Cash_TD_Digit   Cash_E_Command   Cash_E_Digit   Get_Current");
        System.out.println("Before  :       " + pr1 + "             " + pB1 + "                 " + tDC1 +"                 " + tDD1 +"             " + eOC1 +"             "+ eOD1 +"             "+ cr1);
        System.out.println("After   :       " + pr2 + "             " + pB2 + "                 " + tDC2 +"               " + tDD2 +"             " + eOC2 +"             "+ eOD2 +"             "+ cr2);



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