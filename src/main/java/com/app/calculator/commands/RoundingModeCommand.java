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
    }

    @Override
    public boolean execute() {
        if (window.rBtn_Up.isSelected()) {
            window.label_TypeRounding.setText("Округление вверх");
            Command.roundMode = RoundingMode.CEILING;
        }
        if (window.rBtn_FiveDivFour.isSelected()) {
            window.label_TypeRounding.setText("Математическое округление");
            Command.roundMode = RoundingMode.HALF_UP;
        }
        if (window.rBtn_Down.isSelected()) {
            window.label_TypeRounding.setText("Округление вниз");
            Command.roundMode = RoundingMode.FLOOR;
        }
        return true;
    }
}
