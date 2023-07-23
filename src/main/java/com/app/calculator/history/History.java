package com.app.calculator.history;

import com.app.calculator.abstractclasses.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class History {
    public List<Command> history = new ArrayList<>();
    public History(){
        history.add(null);
    }
    public int currentIndex = 0;
    public void push(Command c) {
        //history.add(null);
        if (history.get(currentIndex) == null) {
            System.out.println("1 currentIndex " + currentIndex);
            System.out.println("Стек до добавления элемента: " + history);

            history.add(currentIndex, c);
            System.out.println("2 currentIndex " + currentIndex);
            System.out.println("Стек после добавления элемента: " + history);

            currentIndex += 1;
            System.out.println("3 currentIndex " + currentIndex);
            System.out.println("");
        } else
            if (history.get(currentIndex + 1) instanceof Command) {
            System.out.println("12 currentIndex " + currentIndex);
            history = history.subList(0, currentIndex);
            System.out.println("Стек 2 после добавления элемента: " + history);
            history.add(c);
            System.out.println("Стек 3 после добавления элемента: " + history);
            history.add(null);
            System.out.println("Стек 4 после добавления элемента: " + history);
            currentIndex += 1;
            System.out.println("13 currentIndex " + currentIndex);
            System.out.println("Стек 5 после добавления элемента: " + history);
        }
    }
    public Command pop() {
        System.out.println("4 currentIndex " + currentIndex);
        currentIndex -= 1;
        System.out.println("5 currentIndex " + currentIndex);

        if (currentIndex < 0) {
            System.out.println("6 currentIndex " + currentIndex);
            currentIndex += 1;
            System.out.println("7 currentIndex " + currentIndex);
        }
        System.out.println("8 currentIndex " + currentIndex);

        if (history.get(currentIndex) == null) {
            System.out.println("9 currentIndex " + currentIndex);
            currentIndex -= 1;
            System.out.println("10 currentIndex " + currentIndex);
        }

        System.out.println("11 currentIndex " + currentIndex);
        System.out.println("Стек после добавления элемента: " + history);
        return history.get(currentIndex);
    }
    public Command next() {
        currentIndex += 1;
        if (history.get(currentIndex) == null) {
            currentIndex -= 1;
        }
        return history.get(currentIndex);
    }
    public boolean isEmpty() {
        return history.isEmpty(); }
}

//package com.app.calculator.history;
//
//import com.app.calculator.abstractclasses.Command;
//
//import java.util.Stack;
//
// class History {
//    public Stack<Command> history = new Stack<>();
//    public void push(Command c) {
//            history.push(c);
//        }
//        public Command pop() {
//            return history.pop();
//        }
//        public boolean isEmpty() { return history.isEmpty(); }
//    }
