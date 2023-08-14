package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class KilogramPerSquareCentimeter extends Categories {
    public KilogramPerSquareCentimeter() {
        nameCategory = "kg/cm²";
        coeficient.put("MPa", new BigDecimal(10.19716213));
        coeficient.put("Bar", new BigDecimal(1.01972));
        coeficient.put("kg/cm²", new BigDecimal(1));
    }
}
