package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.text.TextEnglish;
import com.app.calculator.text.TextRussian;
import com.app.calculator.text.TextUkrainian;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioMenuItem;

public class ChooseLanguageCommand extends Command {
    Window currentWindow;
    RadioMenuItem selectedMenuItem = (RadioMenuItem) event.getSource();
    String rMI_name = selectedMenuItem.getText();
    public ChooseLanguageCommand(Window window, ActionEvent event) {
        super(window, event);
        currentWindow = window;
    }
    @Override
    public boolean execute() {
        switch (rMI_name) {
            case "English":
                window.text = new TextEnglish(currentWindow);
                break;
            case "Українська":
                window.text = new TextUkrainian(currentWindow);
                break;
            case "Русский":
                window.text = new TextRussian(currentWindow);
                break;
            default:
                System.out.println("switch ChooseLanguageCommand Error");
        }
        return true;
    }
}

