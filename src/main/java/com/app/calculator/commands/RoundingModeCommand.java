package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingModeCommand extends Command {
    public RoundingModeCommand(Window window, ActionEvent event) {
        super(window, event);
        this.window = window;
    }

    @Override
    public boolean execute() {
        if (window.rBtn_Up.isSelected()) {
            window.label_TypeRounding.setText(window.text.roundUP);
            System.out.println(window.text.roundUP);
            Command.roundMode = RoundingMode.CEILING;
        }
        if (window.rBtn_FiveDivFour.isSelected()) {
            window.label_TypeRounding.setText(window.text.mathematicalRounding);
            System.out.println(window.text.mathematicalRounding);
            Command.roundMode = RoundingMode.HALF_UP;
        }
        if (window.rBtn_Down.isSelected()) {
            window.label_TypeRounding.setText(window.text.roundDown);
            System.out.println(window.text.roundDown);
            Command.roundMode = RoundingMode.FLOOR;
        }
        return true;
    }
}
