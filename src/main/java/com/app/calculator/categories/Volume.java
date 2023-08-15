package com.app.calculator.categories;

import com.app.calculator.coefficients.CubicCentimeters;
import com.app.calculator.coefficients.CubicKilometers;
import com.app.calculator.coefficients.CubicMeters;
import com.app.calculator.constants.Unit;

import java.util.HashMap;

public class Volume extends Categories {
    public Volume() {
        nameCategory = "Volume";
        subCategory.put(Unit.CUBIC_CENTIMETER.getUnit(), new CubicCentimeters());
        subCategory.put(Unit.CUBIC_METER.getUnit(), new CubicMeters());
        subCategory.put(Unit.CUBIC_KILOMETER.getUnit(), new CubicKilometers());
    }
}
