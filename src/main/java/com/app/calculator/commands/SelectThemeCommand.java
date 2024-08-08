package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import com.app.calculator.theme.AnimatedTheme;
import com.app.calculator.theme.ClassicTheme;
import com.app.calculator.theme.DarkTheme;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioMenuItem;

public class SelectThemeCommand extends Command {
    Window currentWindow;
    RadioMenuItem selectedMenuItem = (RadioMenuItem) event.getSource();
    String rMI_name = selectedMenuItem.getText();
    public SelectThemeCommand(Window window, ActionEvent event) {
        super(window, event);
        currentWindow = window;
    }
    @Override
    public boolean execute() {
        switch (rMI_name) {
            case "Classic":
                window.theme = new ClassicTheme(currentWindow);
                break;
            case "Класична":
                window.theme = new ClassicTheme(currentWindow);
                break;
            case "Классическая":
                window.theme = new ClassicTheme(currentWindow);
                break;
            case "Dark":
                window.theme = new DarkTheme(currentWindow);
                break;
            case "Темна":
                window.theme = new DarkTheme(currentWindow);
                break;
            case "Темная":
                window.theme = new DarkTheme(currentWindow);
                break;
            case "Animated":
                window.theme = new AnimatedTheme(currentWindow);
                break;
            case "Анімована":
                window.theme = new AnimatedTheme(currentWindow);
                break;
            case "Анимированная":
                window.theme = new AnimatedTheme(currentWindow);
                break;
            default:
                System.out.println("switch ChooseThemeCommand Error");
        }
        return true;
    }
}
