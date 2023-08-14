package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class MegaPascal extends Categories {
    public MegaPascal() {
        nameCategory = "MPa";
        coeficient.put("MPa", new BigDecimal(1));
        coeficient.put("Bar", new BigDecimal(0.1));
        coeficient.put("kg/cm²", new BigDecimal(0.0980665 ));
    }
}
