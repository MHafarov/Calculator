package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.history.Cash;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import java.math.BigDecimal;


public class MemoryCommand extends Command {
    public MemoryCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        save_PreviousNumber();
        String input_String = getNumber_Previous();
        BigDecimal input_BigDecimal = toBigDecimal(input_String);

        Button source = getSource(event);
        String source_String = source.getText();

        String output_String = null;
        BigDecimal output_BigDecimal = null;

        String outputMemory_String = null;
        BigDecimal outputMemory_BigDecimal = null;

        Cash cashTwoDigits = window.getCashTwoDigits();
        String cashTwoDigits_String = cashTwoDigits.getCashCommandText();
        BigDecimal cashTwoDigits_BigDecimal = cashTwoDigits.getCashDigit();

        Cash cashMemory = window.getCashMemory();
        String cashMemory_String = cashMemory.getCashCommandText();
        BigDecimal cashMemory_BigDecimal = cashMemory.getCashDigit();

        if(cashTwoDigits_String == null) {
            cashTwoDigits_String = "null";
        }

        System.out.println("CashTwoDigit " + source_String);
        System.out.println("cashTwoDigits_String " + cashTwoDigits_String);
        System.out.println(cashTwoDigits_String.equals("null"));
        System.out.println("output_String " + output_String);



        switch (source_String) {
            case "MS":
                window.m_Window.textField.setText(input_String);
                window.turnOnMCMRM();
                input_BigDecimal = input_BigDecimal.setScale(scale, roundMode);
                window.getCashMemory().setCash(source_String, input_BigDecimal);
                output_String = input_String;
                break;

            case "MC":
                window.m_Window.textField.setText("");
                window.turnOffMCMRM();
                window.getCashMemory().clearCash();
                output_String = input_String;
                break;

            case "MR":
                output_BigDecimal = cashMemory_BigDecimal;
                output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                output_String = toString(output_BigDecimal);
                break;

            case "M+":
                switch (cashTwoDigits_String) {

                    case "÷":
                        if (cashTwoNumberFull() & input_String.equals("0")) {
                            output_String = "Деление на ноль невозможно";
                            window.getCashTwoDigits().clearCash();
                            window.getCashEquel().clearCash();
                            break;
                        }
                        output_BigDecimal = cashTwoDigits_BigDecimal.divide(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;

                    case "╳":
                        output_BigDecimal = cashTwoDigits_BigDecimal.multiply(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;

                    case "-":
                        output_BigDecimal = cashTwoDigits_BigDecimal.subtract(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;

                    case "+":
                        output_BigDecimal = cashTwoDigits_BigDecimal.add(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;
                    case "null":
                        output_BigDecimal = input_BigDecimal;
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        if (cashMemory.isEmpty()) {
                            cashMemory.setCash(this.getTextCommand(), new BigDecimal(0));
                            cashMemory_BigDecimal = cashMemory.getCashDigit();
                            cashMemory_BigDecimal = cashMemory_BigDecimal.setScale(scale, roundMode);
                        }
                        break;

                    default:
                        System.out.println("switch M+ Error");
                }

                if (output_String == "Деление на ноль невозможно") {
                    break;
                }

                if (cashMemory.isEmpty()) {
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    outputMemory_String = output_String;
                } else {
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);

                    outputMemory_BigDecimal = cashMemory_BigDecimal.add(output_BigDecimal);
                    outputMemory_BigDecimal = outputMemory_BigDecimal.setScale(scale, roundMode);
                    outputMemory_String = toString(outputMemory_BigDecimal);
                }
                window.m_Window.textField.setText(outputMemory_String);
                window.turnOnMCMRM();

                window.getCashMemory().setCash(source_String, outputMemory_BigDecimal );

                cashTwoDigits.clearCash();
                break;

            case "M-":
                switch (cashTwoDigits_String) {

                    case "÷":
                        if (cashTwoNumberFull() & input_String.equals("0")) {
                            output_String = "Деление на ноль невозможно";
                            window.getCashTwoDigits().clearCash();
                            window.getCashEquel().clearCash();
                            break;
                        }
                        output_BigDecimal = cashTwoDigits_BigDecimal.divide(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;

                    case "╳":
                        output_BigDecimal = cashTwoDigits_BigDecimal.multiply(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;

                    case "-":
                        output_BigDecimal = cashTwoDigits_BigDecimal.subtract(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;

                    case "+":
                        output_BigDecimal = cashTwoDigits_BigDecimal.add(input_BigDecimal);
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        break;

                    case "null":
                        output_BigDecimal = input_BigDecimal;
                        output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                        if (cashMemory.isEmpty()) {
                            cashMemory.setCash(this.getTextCommand(), new BigDecimal(0));
                            cashMemory_BigDecimal = cashMemory.getCashDigit();
                            cashMemory_BigDecimal = cashMemory_BigDecimal.setScale(scale, roundMode);
                        }
                        break;

                    default:
                        System.out.println("switch M- Error");
                }

                if (output_String == "Деление на ноль невозможно") {
                    break;
                }

                if (cashMemory.isEmpty()) {
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);
                    outputMemory_String = output_String;
                } else {
                    output_BigDecimal = output_BigDecimal.setScale(scale, roundMode);
                    output_String = toString(output_BigDecimal);

                    outputMemory_BigDecimal = cashMemory_BigDecimal.subtract(output_BigDecimal);
                    outputMemory_BigDecimal = outputMemory_BigDecimal.setScale(scale, roundMode);
                    outputMemory_String = toString(outputMemory_BigDecimal);
                }
                window.m_Window.textField.setText(outputMemory_String);
                window.turnOnMCMRM();

                window.getCashMemory().setCash(source_String, outputMemory_BigDecimal);

                cashTwoDigits.clearCash();
                break;

            default:
                System.out.println("switch OneDigitCommand Error");
        }


        setNumber_Current(output_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}