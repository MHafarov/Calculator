package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Text;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.text.TextEnglish;
import com.app.calculator.text.TextRussian;
import com.app.calculator.text.TextUkrainian;
import com.app.calculator.windowsCollection.WindowCollection;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioMenuItem;

import java.math.RoundingMode;

public class SelectLanguageCommand extends Command {
    Window currentWindow;
    Text newText;

    RadioMenuItem selectedMenuItem = (RadioMenuItem) event.getSource();
    String rMI_name = selectedMenuItem.getText();
    public SelectLanguageCommand(Window window, ActionEvent event) {
        super(window, event);
        currentWindow = window;

    }
    @Override
    public boolean execute() {
        System.out.println("rMI_name " + rMI_name);

        switch (rMI_name) {
            case "English":
                currentWindow.text = new TextEnglish();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 1 " + currentWindow.text.getClass());
                break;
            case "Английский":
                currentWindow.text = new TextEnglish();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 2 " + currentWindow.text.getClass());
                break;
            case "Англійська":
                currentWindow.text = new TextEnglish();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 3 " + currentWindow.text.getClass());
                break;
            case "Ukranian":
                currentWindow.text = new TextUkrainian();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 4 " + currentWindow.text.getClass());
               // currentWindow.text = newText;
                break;
            case "Украинский":
                currentWindow.text = new TextUkrainian();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 5 " + currentWindow.text.getClass());
                break;
            case "Українська":
                currentWindow.text = new TextUkrainian();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }
                System.out.println("В execute 6 " + currentWindow.text.getClass());
                break;
            case "Russian":
                currentWindow.text = new TextRussian();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 7 " + currentWindow.text.getClass());
                break;
            case "Русский":
                currentWindow.text = new TextRussian();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 8 " + currentWindow.text.getClass());
                break;
            case "Російська":
                currentWindow.text = new TextRussian();

                for (Window window : WindowCollection.getHashMap_windows().values()) {
                    window.text.updateText(window, currentWindow.text);
                }

                System.out.println("В execute 9 " + currentWindow.text.getClass());
                break;
            default:
                System.out.println("switch ChooseLanguageCommand Error");
        }
        return true;
    }

}

