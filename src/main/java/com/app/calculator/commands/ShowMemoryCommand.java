package com.app.calculator.commands;

import com.app.calculator.abstractclasses.Command;
import com.app.calculator.abstractclasses.Window;
import javafx.event.ActionEvent;

public class ShowMemoryCommand extends Command {
    public ShowMemoryCommand(Window window, ActionEvent event) {
        super(window, event);
    }
    @Override
    public boolean execute() {
        if (window.mStageIsHide) {
            window.mWindow_Stage.show();
            window.getHistory().history.remove(this);
            window.getHistory().currentIndex -= 1;
            window.mStageIsHide = false;
        } else {
            window.mWindow_Stage.hide();
            window.getHistory().history.remove(this);
            window.getHistory().currentIndex -= 1;
            window.mStageIsHide = true;
        }
        return true;
    }
}
