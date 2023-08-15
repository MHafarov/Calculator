package com.app.calculator.categories;

import com.app.calculator.coefficients.*;
import com.app.calculator.constants.Unit;

public class Pressure extends Categories {
    public Pressure() {
        nameCategory = "Pressure";
        subCategory.put(Unit.MEGAPASCAL.getUnit(), new MegaPascal());
        subCategory.put(Unit.BAR.getUnit(), new Bar());
        subCategory.put(Unit.KILOGRAM_PER_SQUAREC_SENTIMETER.getUnit(), new KilogramPerSquareCentimeter());
    }
}
