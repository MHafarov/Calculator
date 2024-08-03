package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Text;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.text.TextEnglish;
import com.app.calculator.text.TextRussian;
import com.app.calculator.text.TextUkrainian;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioMenuItem;

public class ChooseLanguageCommand extends Command {
    Window currentWindow;
    Text currentText;
    Text newText;

    RadioMenuItem selectedMenuItem = (RadioMenuItem) event.getSource();
    String rMI_name = selectedMenuItem.getText();
    public ChooseLanguageCommand(Window window, ActionEvent event) {
        super(window, event);
        currentWindow = window;
        currentText = currentWindow.text;
    }
    @Override
    public boolean execute() {
        System.out.println("rMI_name " + rMI_name);

        switch (rMI_name) {
            case "English":
                newText = new TextEnglish(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Английский":
                newText = new TextEnglish(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Англійська":
                newText = new TextEnglish(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Ukranian":
                newText = new TextUkrainian(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Украинский":
                window.text = new TextUkrainian(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Українська":
                window.text = new TextUkrainian(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Russian":
                window.text = new TextRussian(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Русский":
                window.text = new TextRussian(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            case "Російська":
                window.text = new TextRussian(currentWindow);
                window.text.chooseText(currentWindow, newText);
                break;
            default:
                System.out.println("switch ChooseLanguageCommand Error");
        }
        return true;
    }
}

