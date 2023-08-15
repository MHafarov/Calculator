package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class SquareKilometer extends Categories {
    public SquareKilometer() {
        nameCategory = Unit.SQUARE_KILOMETER.getUnit();
        coeficient.put(Unit.SQUARE_CENTIMETER.getUnit(), new BigDecimal("0.0000000001"));
        coeficient.put(Unit.SQUARE_METER.getUnit(), new BigDecimal("0.000001"));
        coeficient.put(Unit.SQUARE_KILOMETER.getUnit(), new BigDecimal("1"));
    }
}
