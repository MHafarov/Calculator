package com.app.calculator;

import com.app.calculator.application.Calculator;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        System.out.println("В методе main");
        Application.launch(Calculator.class, args);
    }
}
