package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class CubicMeters extends Categories {
    public CubicMeters() {
        nameCategory = "m³";
        coeficient.put("cm³", new BigDecimal(0.000001));
        coeficient.put("m³", new BigDecimal(1));
        coeficient.put("кm³", new BigDecimal(1000000000L));
    }
}
