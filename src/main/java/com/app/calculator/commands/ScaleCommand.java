package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ScaleCommand extends Command {
    public ScaleCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        if (window.rBtn_A.isSelected()) {
            window.label_ScaleRounding.setText(window.text.automaticComma);
            Command.scale = 11;
        }
        if (window.rBtn_Zero.isSelected()) {
            window.label_ScaleRounding.setText(window.text.noChargesAfterCommal);
            Command.scale = 0;
        }
        if (window.rBtn_Two.isSelected()) {
            window.label_ScaleRounding.setText(window.text.twoChargesAfterCommal);
            Command.scale = 2;
        }
        if (window.rBtn_Three.isSelected()) {
            window.label_ScaleRounding.setText(window.text.threeChargesAfterCommal);
            Command.scale = 3;
        }
        if (window.rBtn_Four.isSelected()) {
            window.label_ScaleRounding.setText(window.text.fourChargesAfterCommal);
            Command.scale = 4;
        }
        if (window.rBtn_F.isSelected()) {
            window.label_ScaleRounding.setText(window.text.withoutRounding);
            Command.scale = 11;
        }
        return true;
    }
}