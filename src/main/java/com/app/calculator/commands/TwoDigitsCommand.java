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
                    window.getCashTwoNumbersOperations().clearCash();
                    window.getCashEquelOperation().clearCash();
                    break;
                }
                if (cashFull() & !input_String.equals("0")) {
                    output_BigDecimal = window.getCashTwoNumbersOperations().getCashDigit().divide(input_BigDecimal);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumbersOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoNumbersOperations().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "╳":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.multiply(window.getCashTwoNumbersOperations().getCashDigit());
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumbersOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoNumbersOperations().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "-":
                if (cashFull()) {
                    output_BigDecimal = window.getCashTwoNumbersOperations().getCashDigit().subtract(input_BigDecimal);
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumbersOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoNumbersOperations().setCash(source_String, input_BigDecimal);
                    output_BigDecimal = input_BigDecimal;
                    output_String = toString(output_BigDecimal);
                }
                break;

            case "+":
                if (cashFull()) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoNumbersOperations().getCashDigit());
                    output_String = toString(output_BigDecimal);
                    window.getCashTwoNumbersOperations().setCash(source_String, output_BigDecimal);
                }
                if (cashTwoNumberEmpty()) {
                    window.getCashTwoNumbersOperations().setCash(source_String, input_BigDecimal);
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

}