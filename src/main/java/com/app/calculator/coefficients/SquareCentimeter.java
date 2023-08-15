package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class SquareCentimeter extends Categories {
    public SquareCentimeter() {
        nameCategory = Unit.SQUARE_CENTIMETER.getUnit();
        coeficient.put(Unit.SQUARE_CENTIMETER.getUnit(), new BigDecimal("1"));
        coeficient.put(Unit.SQUARE_METER.getUnit(), new BigDecimal("10000"));
        coeficient.put(Unit.SQUARE_KILOMETER.getUnit(), new BigDecimal( "10000000000000000"));
    }
}
