package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;

public class AddCommand extends Command {
    public AddCommand(Window window, ActionEvent event) {
        super(window, event);
    }
    @Override
    public boolean execute() {




        return false;
    }
}
