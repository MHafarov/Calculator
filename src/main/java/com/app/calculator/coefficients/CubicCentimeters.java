package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class CubicCentimeters extends Categories {
    public CubicCentimeters() {
        nameCategory = Unit.CUBIC_CENTIMETER.getUnit();
        coeficient.put(Unit.CUBIC_CENTIMETER.getUnit(), new BigDecimal("1"));
        coeficient.put(Unit.CUBIC_METER.getUnit(), new BigDecimal("1000000"));
        coeficient.put(Unit.CUBIC_KILOMETER.getUnit(), new BigDecimal("1000000000000"));
    }
}
