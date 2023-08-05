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
            window.label_ScaleRounding.setText("Автоматическая запятая");
            Command.scale = 11;
        }
        if (window.rBtn_Zero.isSelected()) {
            window.label_ScaleRounding.setText("0 знаков после запятой");
            Command.scale = 0;
        }
        if (window.rBtn_Two.isSelected()) {
            window.label_ScaleRounding.setText("2 знака после запятой");
            Command.scale = 2;
        }
        if (window.rBtn_Three.isSelected()) {
            window.label_ScaleRounding.setText("3 знака после запятой");
            Command.scale = 3;
        }
        if (window.rBtn_Four.isSelected()) {
            window.label_ScaleRounding.setText("4 знака после запятой");
            Command.scale = 4;
        }
        if (window.rBtn_F.isSelected()) {
            window.label_ScaleRounding.setText("Без округления");
            Command.scale = 11;
        }
        return true;
    }
}