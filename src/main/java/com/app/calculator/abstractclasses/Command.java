package com.app.calculator.abstractclasses;

import javafx.event.ActionEvent;

public abstract class Command {
    public Window window;
    public ActionEvent event;
    private String backup;

    public Command(Window window, ActionEvent event) {
        this.window = window;
        this.event = event;
    }

    void backup() {
        backup = window.displayField.getText();
    }

    public void undo() {
        window.displayField.setText(backup);
    }

    public abstract boolean execute();
}

