package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.constants.BigDecimalDigit;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneDivXCommand extends Command {
    public OneDivXCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        save_PreviousNumber();
        if (getNumber_Previous().equals("0")) {
            window.previousCommandWasSimple = true;
            setNumber_Current("Деление на ноль невозможно");
            window.displayField.setText(getNumber_Current());
        } else {
            Button source = getSource(event);
            String source_String = source.getText();
            window.previousCommandWasSimple = true;

            if (source_String == "1/X") {
                String input_String = getNumber_Previous();
                BigDecimal input_BigDecimal = toBigDecimal(input_String);

                BigDecimal output_BigDecimal = BigDecimalDigit.ONE.getNumber().divide(input_BigDecimal,8, RoundingMode.HALF_UP);

                String output_String = toString(output_BigDecimal);
                setNumber_Current(output_String);
                show_CurrentNumber();
            }
        }
        return true;
    }
}
