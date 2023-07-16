package com.app.calculator.constants;

public enum Size {
    ONE_PIXEL(1), TWO_PIXELS(2),THREE_PIXELS(3),FOUR_PIXELS(4),
    FIVE_PIXELS(5), SIX_PIXELS(6), SEVEN_PIXELS(7),EIGHT_PIXELS(8),
    NINE_PIXELS(9),TEN_PIXELS(10);
    private int number;

    Size  (int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}

