package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class SquareMeter extends Categories {
    public SquareMeter() {
        nameCategory = Unit.SQUARE_METER.getUnit();
        coeficient.put(Unit.SQUARE_CENTIMETER.getUnit(), new BigDecimal("0.0001"));
        coeficient.put(Unit.SQUARE_METER.getUnit(), new BigDecimal("1"));
        coeficient.put(Unit.SQUARE_KILOMETER.getUnit(), new BigDecimal("1000000"));
    }
}
