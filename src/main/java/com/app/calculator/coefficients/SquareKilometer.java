package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class SquareKilometer extends Categories {
    public SquareKilometer() {
        nameCategory = "кm²";
        coeficient.put("cm²", new BigDecimal(0.0000000001));
        coeficient.put("m²", new BigDecimal(0.000001));
        coeficient.put("кm²", new BigDecimal(1));
    }
}
