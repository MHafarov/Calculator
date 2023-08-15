package com.app.calculator.windowsCollection;

import com.app.calculator.abstractclasses.Window;

import java.util.HashMap;

public class WindowCollection {
    public static HashMap<String, Window> hashMap_windows;
    public WindowCollection() {
        hashMap_windows = new HashMap<>();
    }
    public static void add(String windowName, Window window) {
        hashMap_windows.put(windowName, window);
    }

    public static HashMap<String, Window> getHashMap_windows() {
        return hashMap_windows;
    }

    public static void turnOnWindow(String windowName, Double positionX, Double positionY) {
        if (windowName == "Arithmetic") {
            hashMap_windows.get(windowName).stage.setX(positionX);
            hashMap_windows.get(windowName).stage.setY(positionY);
            hashMap_windows.get(windowName).stage.show();
            hashMap_windows.get(windowName).cMI_ArithmeticWindow.setSelected(true);
            hashMap_windows.get(windowName).cMI_TrigonometricWindow.setSelected(false);
            hashMap_windows.get(windowName).cMI_ConvertionWindow.setSelected(false);
            hashMap_windows.get("Trigonometric").stage.hide();
            hashMap_windows.get("Convertion").stage.hide();
            hashMap_windows.get(windowName).displayField = hashMap_windows.get(windowName).textField_ArithmeticTrigonometric;

            System.out.println("A2");
        }
        if (windowName == "Trigonometric") {
            hashMap_windows.get(windowName).stage.setX(positionX);
            hashMap_windows.get(windowName).stage.setY(positionY);
            hashMap_windows.get(windowName).stage.show();
            hashMap_windows.get(windowName).cMI_ArithmeticWindow.setSelected(false);
            hashMap_windows.get(windowName).cMI_TrigonometricWindow.setSelected(true);
            hashMap_windows.get(windowName).cMI_ConvertionWindow.setSelected(false);
            hashMap_windows.get("Arithmetic").stage.hide();
            hashMap_windows.get("Convertion").stage.hide();
            hashMap_windows.get(windowName).displayField = hashMap_windows.get(windowName).textField_ArithmeticTrigonometric;
            System.out.println("T2");
        }
        if (windowName == "Convertion") {
            hashMap_windows.get(windowName).stage.setX(positionX);
            hashMap_windows.get(windowName).stage.setY(positionY);
            hashMap_windows.get(windowName).stage.show();
            hashMap_windows.get(windowName).cMI_ArithmeticWindow.setSelected(false);
            hashMap_windows.get(windowName).cMI_TrigonometricWindow.setSelected(false);
            hashMap_windows.get(windowName).cMI_ConvertionWindow.setSelected(true);
            hashMap_windows.get("Arithmetic").stage.hide();
            hashMap_windows.get("Trigonometric").stage.hide();
            hashMap_windows.get(windowName).displayField = hashMap_windows.get(windowName).textField_Convertion_In;
            System.out.println("C2");
        }
    }
}
