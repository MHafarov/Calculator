package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.BigDecimalDigit;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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

        BigDecimal output_BigDecimal = null;


        switch (source_String) {
            case "MC":
                window.m_Window.textField.setText("");
                window.turnOffMCMRM();
                window.getCashMemory().clearCash();
                break;

            case "MR":
                break;

            case "M+":
                break;

            case "M-":
                break;

            case "MS":
                window.m_Window.textField.setText(input_String);
                window.turnOnMCMRM();
                window.getCashMemory().setCash(source_String, input_BigDecimal);
                break;

            default:
                System.out.println("switch OneDigitCommand Error");
        }

       // String output_String = toString(output_BigDecimal);
        setNumber_Current(input_String);
        show_CurrentNumber();
        window.nextDigitShouldBeNew = true;
        return true;
    }
}