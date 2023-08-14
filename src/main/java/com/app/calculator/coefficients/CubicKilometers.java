package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class CubicKilometers extends Categories {
    public CubicKilometers() {
        nameCategory = "кm³";
        coeficient.put("cm³", new BigDecimal(0.000000000000001));
        coeficient.put("m³", new BigDecimal(0.000001));
        coeficient.put("кm³", new BigDecimal(1));
    }
}
