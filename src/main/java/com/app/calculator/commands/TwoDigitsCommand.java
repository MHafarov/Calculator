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
        input_Double = toDouble(input_BigDecimal);

        Button source = getSource(event);
        String source_String = source.getText();

        BigDecimal output_BigDecimal = null;
        String output_String = null;


        switch (source_String) {
            case "÷":
                if (cashFull() & input_String.equals("0")) {
                    output_String = "Деление на ноль невозможно";
                    window.getCashTwoDigits().clearCash();
                    window.getCashEquel().clearCash();
                    break;
                }
                if (cashFull() & !input_String.equals("0")) {
                    output_BigDecimal = window.getCashTwoDigits().getCashDigit().divide(input_BigDecimal);
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "╳":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoDigits().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "-":
                if (cashFull()) {
                    output_BigDecimal = window.getCashTwoDigits().getCashDigit().subtract(input_BigDecimal);
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "+":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoDigits().getCashDigit());
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "x^y":
                if (cashFull()) {
                    output_BigDecimal = BigDecimal.valueOf(Math.pow(toDouble(window.getCashTwoDigits().getCashDigit()), input_Double));
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "x^(1/y)":
                if (cashFull() & input_String.equals("0")) {
                    output_String = "Деление на ноль невозможно";
                    window.getCashTwoDigits().clearCash();
                    window.getCashEquel().clearCash();
                    break;
                }
                if (cashFull() & !input_String.equals("0")) {
                    output_BigDecimal = BigDecimal.valueOf(Math.pow(toDouble(window.getCashTwoDigits().getCashDigit()), 1 / input_Double));
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;
            case "Exp":
                if (cashFull()) {
                    BigDecimal ten_Number = new BigDecimal(10);
                    input_BigDecimal = ten_Number.pow(input_BigDecimal.intValueExact());

                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoDigits().getCashDigit());

                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "Mod":
                if (cashFull() & input_String.equals("0")) {
                    output_String = "Результат не определен";
                    window.getCashTwoDigits().clearCash();
                    window.getCashEquel().clearCash();
                    break;
                }
                if (cashFull() & !input_String.equals("0")) {
                    double dividend = window.getCashTwoDigits().getCashDigit().doubleValue();
                    double divisor = input_BigDecimal.doubleValue();

                    double remainder = dividend - ((int)(dividend / divisor)) * divisor;

                    output_BigDecimal = new BigDecimal(remainder);
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoDigits().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoDigits().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                }
                break;

            default:
                System.out.println("switch TwoDigitsCommand Error");
        }

        System.out.println("output_String in witch " + output_String);
        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }

}