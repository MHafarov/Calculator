package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class SquareMeter extends Categories {
    public SquareMeter() {
        nameCategory = "m²";
        coeficient.put("cm²", new BigDecimal(0.0001));
        coeficient.put("m²", new BigDecimal(1));
        coeficient.put("кm²", new BigDecimal(1000000));
    }
}
