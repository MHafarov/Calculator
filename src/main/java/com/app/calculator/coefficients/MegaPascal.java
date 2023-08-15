package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class MegaPascal extends Categories {
    public MegaPascal() {
        nameCategory = Unit.MEGAPASCAL.getUnit();
        coeficient.put(Unit.MEGAPASCAL.getUnit(), new BigDecimal("1"));
        coeficient.put(Unit.BAR.getUnit(), new BigDecimal("0.1"));
        coeficient.put(Unit.KILOGRAM_PER_SQUAREC_SENTIMETER.getUnit(), new BigDecimal("0.0980665"));
    }
}
