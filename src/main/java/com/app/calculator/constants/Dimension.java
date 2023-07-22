package com.app.calculator.constants;

public enum Dimension {
    ARITHMETIC_WINDOW(415, 450), TRIGONOMETRIC_WINDOW(415, 450),
    CONVERTION_WINDOW(400, 450);
    private final double width;
    private final double height;

    Dimension(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}