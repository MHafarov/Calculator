package com.app.calculator.history;

import com.app.calculator.abstractclasses.Command;

import java.util.Stack;

public class History {
    private Stack<Command> history = new Stack<>();
    public void push(Command c) {
            history.push(c);
        }
        public Command pop() {
            return history.pop();
        }
        public boolean isEmpty() { return history.isEmpty(); }
    }
