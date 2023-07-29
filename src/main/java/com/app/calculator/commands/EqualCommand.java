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

        if (window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand() == "="
                & window.getCashEquelOperation().getCashCommandText() == "+") {
            cash_String = window.getCashEquelOperation().getCashCommandText();
            System.out.println(cash_String);
        }



        switch (cash_String) {
            case "÷":
                break;

            case "╳":
                break;

            case "-":
                break;

            case "+":
                if (window.getCashTwoNumberOperations().getCashDigit() != null) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashTwoNumberOperations().getCashDigit());
                    window.getCashEquelOperation().setCash(cash_String,input_BigDecimal);
                    System.out.println("Command 1 " + cash_String + " digit " + input_BigDecimal);
                }
                if (window.getCashTwoNumberOperations().getCashDigit() == null) {
                    output_BigDecimal = input_BigDecimal.add(window.getCashEquelOperation().getCashDigit());
                    System.out.println("Command 2 " + cash_String + " digit " + input_BigDecimal);
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
}