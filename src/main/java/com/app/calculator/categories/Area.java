package com.app.calculator.categories;

import com.app.calculator.coefficients.*;

public class Area extends Categories {
    public Area() {
        nameCategory = "Area";
        subCategory.put("cm²", new SquareСentimeter());
        subCategory.put("m²", new SquareMeter());
        subCategory.put("km²", new SquareKilometer());
    }
}
