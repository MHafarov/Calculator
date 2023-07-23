package com.app.calculator.abstractclasses;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;

public abstract class Command {
    public Window window;
    public ActionEvent event;
    private String backup;


    public Command(Window window, ActionEvent event) {
        this.window = window;
        this.event = event;
    }

    public void backup() {
        backup = window.displayField.getText();
    }

    public void undo() {
        window.displayField.setText(backup);
    }

    public abstract boolean execute();

    public Button getSource(ActionEvent actionEvent) {
        return (Button) actionEvent.getSource();
    }

    public BigDecimal toBigDecimal(String inputString) {
        inputString = inputString.replace(',','.');
        return new BigDecimal(inputString);
    }

    public String toString(BigDecimal bigDecimal) {
        String outputString = String.valueOf(bigDecimal);
        outputString = outputString.replace('.',',');
        return outputString;
    }

    @Override
    public String toString() {
        return getSource(event).getText();
    }
}

