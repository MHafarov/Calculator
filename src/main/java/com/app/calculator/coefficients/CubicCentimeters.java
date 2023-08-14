package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class CubicCentimeters extends Categories {
    public CubicCentimeters() {
        nameCategory = "cm³";
        coeficient.put("cm³", new BigDecimal(1));
        coeficient.put("m³", new BigDecimal(1000000));
        coeficient.put("кm³", new BigDecimal(1000000000000L));
    }
}
