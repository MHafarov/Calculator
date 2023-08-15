package com.app.calculator.constants;

public enum Unit {
    BAR("Bar"),  MEGAPASCAL("MPa"),  KILOGRAM_PER_SQUAREC_SENTIMETER("kg/cm"),
    CUBIC_CENTIMETER("cm³"),  CUBIC_METER("m³"),  CUBIC_KILOMETER("кm³"),
    SQUARE_CENTIMETER("cm²"),  SQUARE_METER("m²"),  SQUARE_KILOMETER("кm²");


    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }
    public String getUnit() {
        return unit;
    }
}