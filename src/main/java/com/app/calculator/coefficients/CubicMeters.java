package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class CubicMeters extends Categories {
    public CubicMeters() {
        nameCategory = Unit.CUBIC_METER.getUnit();
        coeficient.put(Unit.CUBIC_CENTIMETER.getUnit(), new BigDecimal("0.000001"));
        coeficient.put(Unit.CUBIC_METER.getUnit(), new BigDecimal("1"));
        coeficient.put(Unit.CUBIC_KILOMETER.getUnit(), new BigDecimal("1000000000"));
    }
}
