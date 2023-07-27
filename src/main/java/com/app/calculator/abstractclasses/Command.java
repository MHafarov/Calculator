package com.app.calculator.abstractclasses;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.math.BigDecimal;

public abstract class Command {
    public Window window;
    public ActionEvent event;
    private String number_Previous;
    private String number_Current;


    public Command(Window window, ActionEvent event) {
        this.window = window;
        this.event = event;
    }

    public void save_PreviousNumber() {
        number_Previous = window.displayField.getText();
    }

    public void show_PreviousNumber() {
        window.displayField.setText(number_Previous);
    }

    public void save_CurrentNumber() {

        Button source = getSource(event);
        String outputString = source.getText();
        setNumber_Current(outputString);

        if (getNumber_Previous().equals("0") | window.previousCommandWasSimple == true) {
            setNumber_Current(outputString);
            window.previousCommandWasSimple = false;
        } else {
            setNumber_Current(getNumber_Previous() + getNumber_Current());
            window.previousCommandWasSimple = false;
        }
    }

    public void show_CurrentNumber() {
        window.displayField.setText(number_Current);
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

    public String getNumber_Previous() {
        return number_Previous;
    }

    public void setNumber_Previous(String number_Previous) {
        this.number_Previous = number_Previous;
    }

    public String getNumber_Current() {
        return number_Current;
    }

    public void setNumber_Current(String number_Current) {
        this.number_Current = number_Current;
    }

    @Override
    public String toString() {
        return getSource(event).getText();
    }
}

