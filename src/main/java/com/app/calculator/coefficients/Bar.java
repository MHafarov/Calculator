package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class Bar extends Categories {
    public Bar() {
        nameCategory = Unit.BAR.getUnit();
        coeficient.put(Unit.MEGAPASCAL.getUnit(), new BigDecimal("10"));
        coeficient.put(Unit.BAR.getUnit(), new BigDecimal("1"));
        coeficient.put(Unit.KILOGRAM_PER_SQUAREC_SENTIMETER.getUnit(), new BigDecimal("0.980665"));
    }
}
