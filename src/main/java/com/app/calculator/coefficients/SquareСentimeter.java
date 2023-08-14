package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;

import java.math.BigDecimal;

public class SquareСentimeter extends Categories {
    public SquareСentimeter() {
        nameCategory = "cm²";
        coeficient.put("cm²", new BigDecimal(1));
        coeficient.put("m²", new BigDecimal(10000));
        coeficient.put("кm²", new BigDecimal( 10000000000000000L));
    }
}
