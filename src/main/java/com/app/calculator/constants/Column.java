package com.app.calculator.constants;

public enum Column {
    FIRST(0), SECOND(1),THIRD(2),FOURTH(3),FIFTH(4),SIXTH(5),
    SEVENTH(6),EIGHTH(7),NINTH(8),TENTH(9),ELEVENTH(10), TWELFTH(11),
    THIRTEENTH(12);

    private final int number;

    Column (int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
