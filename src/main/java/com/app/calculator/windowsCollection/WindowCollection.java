package com.app.calculator.windowsCollection;

import com.app.calculator.abstractclasses.Window;

import java.util.ArrayList;
import java.util.List;

public class WindowCollection {
    static List <Window> list_windows;
    public WindowCollection() {
        list_windows = new ArrayList<>();
    }
    public static void add(Window window) {
        list_windows.add(window);
    }

    public static List<Window> getList_windows() {
        return list_windows;
    }
}
