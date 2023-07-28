package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class EditDigitCommand extends Command {
    private int history_size = window.getHistory().history.size();
    public EditDigitCommand(Window window, ActionEvent event) {
        super(window, event);
    }

    @Override
    public boolean execute() {
        save_PreviousNumber();
        String input_String = getNumber_Previous();

        Button source = getSource(event);
        String source_String = source.getText();

        String output_String = null;

        switch (source_String) {
            case "←":
                if (isDigit(input_String)) {
                    output_String = input_String.substring(0,input_String.length()-1);
                }
                if (isOnlyOneDigit(input_String) | digitIsMinus(input_String) | digitIsMinusZeroComma(input_String)
                    | digitIsMinusAndOneDigit(input_String)) {
                    output_String = "0";
                }
                break;

            case "±":
                if (isGreaterThanZero(input_String)) {
                    output_String = "-" + input_String;
                } else {
                    output_String = input_String.substring(1);
                }
                if (digitIsZero(input_String)) {
                    output_String = "0";
                    if (history_size > 1 && lastCommandWas("±")
                        && window.getHistory().currentIndex == history_size-2) {
                        window.getHistory().history.remove(history_size-2);
                        window.getHistory().currentIndex -= 1;
                    }
                }
                break;

            case ",":
                if (digitIsZero(input_String)) {
                    output_String = input_String + ",";
                    System.out.println("Zero 1");
                    break;
                }
                if (digitHasComma(input_String)) {
                    System.out.println("input_String на ВХОДЕ " + input_String);
                    output_String = input_String;
                    System.out.println("output_String " + input_String);
                    System.out.println("Has comma 1");
                    System.out.println("Стек " + window.getHistory().history);
                    if (history_size > 1 && lastCommandWas(",")) {
                        setNumber_Previous((window.getHistory().history.get(window.getHistory().history.size()-3).getNumber_Previous()));
                        setNumber_Current((window.getHistory().history.get(window.getHistory().history.size()-3).getNumber_Current()));
                        System.out.println("Previous " + getNumber_Previous());
                        System.out.println("Current " + getNumber_Current());
                        window.getHistory().history.remove(history_size-2);
                        window.getHistory().currentIndex -= 1;
                        System.out.println("Has comma 2");
                        System.out.println("Стек " + window.getHistory().history);
                        break;
                    }
                    break;
                }
                if (clearDisplay(input_String)) {
                    output_String = "";
                    break;
                }
                output_String = input_String + ",";
                System.out.println("Add comma 1");
                System.out.println("Стек " + window.getHistory().history);
                break;

            default:
                System.out.println("switch OneDigitCommand Error");
        }

        setNumber_Current(output_String);
        show_CurrentNumber();

        return true;
    }
    public boolean isDigit(String input_String) {
        if (!input_String.equals("")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean clearDisplay(String input_String) {
        if (input_String.equals("")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isOnlyOneDigit(String input_String) {
        if (!input_String.equals("") & (input_String.length()) == 1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean digitIsMinus(String input_String) {
        if (!input_String.equals("") & (input_String.length()) == 1 & input_String.indexOf("-") != -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean digitIsZero(String input_String) {
        if (input_String.equals("0")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean digitIsMinusZeroComma(String input_String) {
        if (input_String.equals("-0,")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean digitIsMinusAndOneDigit(String input_String) {
        if (input_String.substring(0, 1).equals("-") & input_String.length() == 2) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isGreaterThanZero(String input_String) {
        if (input_String.indexOf('-') == -1 & !input_String.equals("0")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean digitHasComma(String input_String) {
        if (input_String.indexOf(',') != -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean lastCommandWas(String input_String) {
        if (window.getHistory().history.get(window.getHistory().history.size()-2).getTextCommand() == input_String) {
            return true;
        } else {
            return false;
        }
    }
}