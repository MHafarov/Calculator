package com.app.calculator.categories;

import com.app.calculator.coefficients.CubicCentimeters;
import com.app.calculator.coefficients.CubicKilometers;
import com.app.calculator.coefficients.CubicMeters;

import java.util.HashMap;

public class Volume extends Categories {
    public Volume() {
        nameCategory = "Volume";
        subCategory.put("cm³", new CubicCentimeters());
        subCategory.put("m³", new CubicMeters());
        subCategory.put("km³", new CubicKilometers());
    }
}
