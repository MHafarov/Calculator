package com.app.calculator.coefficients;

import com.app.calculator.categories.Categories;
import com.app.calculator.constants.Unit;

import java.math.BigDecimal;

public class CubicKilometers extends Categories {
    public CubicKilometers() {
        nameCategory = Unit.CUBIC_KILOMETER.getUnit();
        coeficient.put(Unit.CUBIC_CENTIMETER.getUnit(), new BigDecimal("0.000000000000001"));
        coeficient.put(Unit.CUBIC_METER.getUnit(), new BigDecimal("0.000001"));
        coeficient.put(Unit.CUBIC_KILOMETER.getUnit(), new BigDecimal("1"));
    }

    @Override
    public String toString() {
        return new String (coeficient.keySet() + " " + coeficient.get("cm³") + " " + coeficient.get("m³") + " " + coeficient.get("кm³"));
    }
}
