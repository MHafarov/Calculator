package com.app.calculator.categories;

import com.app.calculator.coefficients.*;

public class Pressure extends Categories {
    public Pressure() {
        nameCategory = "Pressure";
        subCategory.put("MPa", new MegaPascal());
        subCategory.put("Bar", new Bar());
        subCategory.put("kg/cm²", new KilogramPerSquareCentimeter());
    }
}
