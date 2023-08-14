package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class Bar extends Categories {
    public Bar() {
        nameCategory = "Bar";
        coeficient.put("MPa", new BigDecimal(10));
        coeficient.put("Bar", new BigDecimal(1));
        coeficient.put("kg/cm²", new BigDecimal(0.980665));
    }
}
