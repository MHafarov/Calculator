package com.app.calculator.categories;

import com.app.calculator.coefficients.*;
import com.app.calculator.constants.Unit;

public class Area extends Categories {
    public Area() {
        nameCategory = "Area";
        subCategory.put(Unit.SQUARE_CENTIMETER.getUnit(), new SquareCentimeter());
        subCategory.put(Unit.SQUARE_METER.getUnit(), new SquareMeter());
        subCategory.put(Unit.SQUARE_KILOMETER.getUnit(), new SquareKilometer());
    }
}
