package com.app.calculator.constants;

public enum Position {
    ARITHMETIC_WINDOW(10, 100), TRIGONOMETRIC_WINDOW(430, 100),
    CONVERTION_WINDOW(850, 100),
    MEMORY_WINDOW(ARITHMETIC_WINDOW.getHorizontal(), ARITHMETIC_WINDOW.getVertical() - 71);
    private final int horizontal;
    private final int vertical;

    Position(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }
}