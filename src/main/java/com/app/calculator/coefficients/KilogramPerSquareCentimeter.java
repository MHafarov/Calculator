package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class KilogramPerSquareCentimeter extends Categories {
    public KilogramPerSquareCentimeter() {
        nameCategory = Unit.KILOGRAM_PER_SQUAREC_SENTIMETER.getUnit();
        coeficient.put(Unit.MEGAPASCAL.getUnit(), new BigDecimal("10.19716213"));
        coeficient.put(Unit.BAR.getUnit(), new BigDecimal("1.01972"));
        coeficient.put(Unit.KILOGRAM_PER_SQUAREC_SENTIMETER.getUnit(), new BigDecimal("1"));
    }
}
