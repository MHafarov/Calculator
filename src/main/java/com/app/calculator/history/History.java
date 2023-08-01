package com.app.calculator.history;

import com.app.calculator.abstractclasses.Command;

import java.util.ArrayList;
import java.util.List;

public class History {
    public List<Command> history = new ArrayList<>();
    public History(){
        history.add(null);
    }
    public int currentIndex = 0;

    public void push(Command c) {

        if (history.size() == (currentIndex - 1)) {
            currentIndex -= 1;
        }

        if (history.get(currentIndex) == null) {
            history.add(currentIndex, c);
            currentIndex += 1;
        } else
            if (history.get(currentIndex + 1) instanceof Command) {
            history = history.subList(0, currentIndex);
            history.add(c);
            history.add(null);
            currentIndex += 1;
        }
    }
    public Command pop() {
        currentIndex -= 1;

        if (currentIndex < 0) {
            currentIndex += 1;
        }
        if (history.get(currentIndex) == null) {
            currentIndex -= 1;
        }
        return history.get(currentIndex);
    }
    public Command next() {
        if (currentIndex == history.size() | history.size() == (currentIndex - 1)) {
            currentIndex -= 1;
        }

        if (history.get(currentIndex) == null) {

            return history.get(currentIndex++);
        } else {
            return history.get(currentIndex++);
        }
    }
    public boolean isEmpty() {
        return history.isEmpty(); }

    public void clearHistory() {
        history = history.subList(history.size()-1, history.size());
        currentIndex = 0;
    }
}

